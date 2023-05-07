package com.Service.repository;

import com.Service.dto.UserDto;
import com.Service.entity.UserEntity;

public interface UserRepository {
    boolean addUser(UserDto userDto);
    boolean updateUser(UserDto userDto);
    boolean removeUser(Integer userId);
    UserEntity login(String username, String password);
}
