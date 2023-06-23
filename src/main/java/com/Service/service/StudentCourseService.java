package com.Service.service;

import com.Service.dto.CourseDto;
import com.Service.dto.StudentCourseDto;
import com.Service.entity.StudentCourseEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface StudentCourseService  extends IService<StudentCourseEntity> {
    boolean joinCourse(StudentCourseDto studentCourseDto);
    boolean exitCourse(Long id);
    List<CourseDto> getCourse(Long id);
    boolean archiveCourse(Long id);
    boolean cancelArchive(Long id);
}
