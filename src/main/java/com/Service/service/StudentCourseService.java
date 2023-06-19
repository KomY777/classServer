package com.Service.service;

import com.Service.dto.StudentCourseDto;
import com.Service.entity.StudentCourseEntity;
import com.baomidou.mybatisplus.extension.service.IService;

public interface StudentCourseService  extends IService<StudentCourseEntity> {
    boolean joinCourse(StudentCourseDto studentCourseDto);
    boolean exitCourse(Long id);
}
