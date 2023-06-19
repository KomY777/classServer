package com.Service.repository;


import com.Service.entity.StudentHomeworkEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentHomeworkRepository extends BaseMapper<StudentHomeworkEntity> {
}
