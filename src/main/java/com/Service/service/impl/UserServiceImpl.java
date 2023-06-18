package com.Service.service.impl;

import com.Service.dto.UserDto;
import com.Service.entity.UserEntity;
import com.Service.repository.UserRepository;
import com.Service.service.UserService;
import com.Service.util.SaltedHash;
import com.Service.util.Transform;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;


@Service
public class UserServiceImpl extends ServiceImpl<UserRepository, UserEntity> implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean addUser(UserDto userDto) {
        try {
            userDto.setPassword(SaltedHash.hash(userDto.getPassword()));
            UserEntity userEntity = new UserEntity();
            BeanUtils.copyProperties(userDto, userEntity);
            if(userRepository.login(userEntity.getUsername(), userEntity.getPassword()) == null) {
                return userRepository.insert(userEntity) == 0;
            }else {
                throw new RuntimeException("账号已存在");
            }
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

//    @Override
//    public boolean removeUser(UserDto userDto) {
//        try {
//           UserDto userEntity = login(userDto);
//            return userRepository.deleteById(userEntity.getId()) == 0;
//        }catch (Exception e) {
//            throw new RuntimeException("111");
//        }
//    }

    @Override
    public boolean updateUser(String username,String password,String newPassword) {
        try {
            UserDto user = login(username,password);
            UserEntity userEntity = new UserEntity();
            BeanUtils.copyProperties(user,userEntity);
            userEntity.setPassword(SaltedHash.hash(newPassword));
            return userRepository.updateById(userEntity) !=0;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public UserDto login(String username,String password) {
        try {
            UserEntity userOut= userRepository.login(username,password);
            if (userOut !=null){
               UserDto userDto = new UserDto();
               BeanUtils.copyProperties(userOut, userDto);
               if(SaltedHash.check(password,userDto.getPassword())){
                    return userDto;
               }else {
                   throw new RuntimeException("密码错误");
               }
            }else {
               throw new RuntimeException("用户名错误");
            }
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean sendMail(MailSender mailSender,String email) {
        try {
            long timestamp = System.currentTimeMillis()%100000000;
            String captcha = Transform.fromDecimal(timestamp);
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom("2930738331@qq.com");
            mailMessage.setTo(email);
            mailMessage.setSubject("CQUT 课堂派");
            String message = "Hi,您正在注册课堂派,以下是您的邮箱验证码:\n\n\n      " + captcha;
            mailMessage.setText(message);
            mailSender.send(mailMessage);
        }catch (Exception e) {
           throw  new RuntimeException(e);
        }
        return true;
    }
}
