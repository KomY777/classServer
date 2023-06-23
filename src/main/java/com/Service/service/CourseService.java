package com.Service.service;

import com.Service.dto.CourseDto;
import com.Service.entity.CourseEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface CourseService extends IService<CourseEntity> {
    boolean addCourse(CourseDto courseDto);
    boolean updateCourse(CourseDto courseDto);
    boolean removeCourse(Long id,Long teacherId);
    String getCourseCode(Long id,Long teacherId);
    List<CourseDto> getCourse(Long id);
    boolean archiveCourse(Long id);
    boolean archiveMe(Long id);
}
