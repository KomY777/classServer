package com.Service.service.impl;

import com.Service.dto.UserDto;
import com.Service.entity.UserEntity;
import com.Service.repository.UserRepository;
import com.Service.service.UserService;
import com.Service.util.SaltedHash;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
            if(userRepository.login(userEntity) == null) {
                System.out.println(userEntity);
            return userRepository.insert(userEntity) == 0;
            }else {
                throw new RuntimeException("账号已存在");
            }
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean removeUser(UserDto userDto) {
        try {
           UserDto userEntity = login(userDto);
            return userRepository.deleteById(userEntity.getId()) == 0;
        }catch (Exception e) {
            throw new RuntimeException("111");
        }
    }

//    @Override
//    public boolean updateUser(UserDto userDto,String password) {
//        try {
//            UserDto user = login(userDto);
//            UserEntity userEntity = new UserEntity();
//            BeanUtils.copyProperties(userDto,userEntity);
//            userEntity.setPassword(password);
//            user
//            return userRepository.update();
//        }catch (Exception e){
//            throw new RuntimeException(e);
//        }
//    }

    @Override
    public UserDto login(UserDto user) {
        try {
            UserEntity userEntity = new UserEntity();
            BeanUtils.copyProperties(user, userEntity);
            UserEntity userOut= userRepository.login(userEntity);
            if (userRepository !=null){
               UserDto userDto = new UserDto();
               BeanUtils.copyProperties(userOut, userDto);
               if(SaltedHash.check(user.getPassword(),userDto.getPassword())){
                   throw new RuntimeException("密码错误");
               }
               return userDto;
            }else {
               throw new RuntimeException("用户名错误");
            }
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
