package com.Service.repository;

import com.Service.entity.StudentCourseEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentCourseRepository extends BaseMapper<StudentCourseEntity> {
     int joinCourse(StudentCourseEntity studentCourseEntity,String courseCode);
}
