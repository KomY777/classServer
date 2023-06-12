package com.Service.repository;

import com.Service.entity.CourseEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CourseRepository extends BaseMapper<CourseEntity> {
    int addCourse(CourseEntity courseEntity);
    int updateCourse(CourseEntity courseEntity);
    boolean removeCourse(Long id,Long teacherId);
}
