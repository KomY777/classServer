package com.Service.repository;

import com.Service.entity.CourseEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseRepository extends BaseMapper<CourseEntity> {
    int addCourse(CourseEntity courseEntity);
    int updateCourse(CourseEntity courseEntity);
    boolean removeCourse(Long id,Long teacherId);
    int getCourseCode(Long id,Long teacherId,String courseCode);
    List<CourseEntity> getCourse(Long id);
    String getName(Long id);
    boolean archiveCourse(Long id);
    boolean archiveMe(Long id,Integer state);
}
