package com.Service.service;

import com.Service.dto.UserDto;
import com.Service.entity.UserEntity;
import com.baomidou.mybatisplus.extension.service.IService;

public interface UserService extends IService<UserEntity> {
    boolean addUser(UserDto userDto);
//    boolean removeUser(UserDto userDto);
    boolean updateUser(String username,String password,String newPassword);
    UserDto login(String username,String password);
}
