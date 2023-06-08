package com.Service.repository;

import com.Service.dto.UserDto;
import com.Service.entity.UserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository extends BaseMapper<UserEntity> {
    boolean updateUser(UserDto userDto);
    UserEntity login(UserEntity userEntity);
}
