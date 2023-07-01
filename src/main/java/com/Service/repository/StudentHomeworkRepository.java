package com.Service.repository;


import com.Service.entity.StudentHomeworkEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentHomeworkRepository extends BaseMapper<StudentHomeworkEntity> {
    List<StudentHomeworkEntity> getAllHomeworkInfo(Long id);
    boolean updateHomework(StudentHomeworkEntity studentHomeworkEntity);
}
