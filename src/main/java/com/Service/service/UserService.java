package com.Service.service;

import com.Service.dto.UserDto;
import com.Service.entity.UserEntity;
import com.baomidou.mybatisplus.extension.service.IService;

public interface UserService extends IService<UserEntity> {
    boolean addUser(UserDto userDto);
    boolean removeUser(UserDto userDto);
    boolean updateUser(UserDto userDto);
    UserDto login(UserDto user);
}
