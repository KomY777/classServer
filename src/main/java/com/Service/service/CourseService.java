package com.Service.service;

import com.Service.dto.CourseDto;
import com.Service.entity.CourseEntity;
import com.baomidou.mybatisplus.extension.service.IService;

public interface CourseService extends IService<CourseEntity> {
    boolean addCourse(CourseDto courseDto);
    boolean updateCourse(CourseDto courseDto);
    boolean removeCourse(Long id,Long teacherId);
    boolean joinCourse(String code);
    boolean exitCourse(String courseId);

}
