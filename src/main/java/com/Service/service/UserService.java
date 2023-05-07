package com.Service.service;

import com.Service.dto.UserDto;

public interface UserService {
    boolean addUser(UserDto userDto);
    boolean removeUser(UserDto userDto);
    boolean updateUser(UserDto userDto);
    UserDto login(String username, String password);
}
