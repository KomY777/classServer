package com.Service.service.impl;

import com.Service.dto.UserDto;
import com.Service.entity.UserEntity;
import com.Service.repository.UserRepository;
import com.Service.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean addUser(UserDto userDto) {

        return userRepository.addUser(userDto);
    }

    @Override
    public boolean removeUser(UserDto userDto) {
        try {
           UserDto userEntity = login(userDto.getUsername(), userDto.getPassword());
            return userRepository.removeUser(userEntity.getId());
        }catch (Exception e) {
            throw new RuntimeException("111");
        }
    }

    @Override
    public boolean updateUser(UserDto userDto) {
        try {
            UserDto userEntity = login(userDto.getUsername(), userDto.getPassword());
            return userRepository.updateUser(userDto);
        }catch (Exception e){
            throw new RuntimeException("");
        }
    }

    @Override
    public UserDto login(String username, String password) {
        try {

            UserEntity userEntity= userRepository.login(username, password);
            if (userRepository !=null){
               UserDto userDto = new UserDto();
               BeanUtils.copyProperties(userEntity, userDto);
               return userDto;
            }else {
                return null;
            }
        }catch (Exception e) {
            throw new RuntimeException("no such account");
        }
    }
}
