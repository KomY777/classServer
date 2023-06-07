package com.Service.repository;

import com.Service.dto.UserDto;
import com.Service.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {
    boolean addUser(UserDto userDto);
    boolean updateUser(UserDto userDto);
    boolean removeUser(Integer userId);
    UserEntity login(String username, String password);
}
