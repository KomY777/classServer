package com.Service.repository;

import com.Service.entity.StudentCourseEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentCourseRepository extends BaseMapper<StudentCourseEntity> {
     int joinCourse(StudentCourseEntity studentCourseEntity,String courseCode);
     List<Long> getCourse(Long id);
     boolean archiveCourse(Long id);
}
