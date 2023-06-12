package com.Service.service.impl;

import com.Service.dto.CourseDto;
import com.Service.entity.CourseEntity;
import com.Service.repository.CourseRepository;
import com.Service.service.CourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CourseServiceImpl extends ServiceImpl<CourseRepository, CourseEntity> implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public boolean addCourse(CourseDto courseDto) {
        try {
            CourseEntity courseEntity = new CourseEntity();
            BeanUtils.copyProperties(courseDto, courseEntity);
            return courseRepository.addCourse(courseEntity) != 0;
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean updateCourse(CourseDto courseDto) {
        try {
            CourseEntity courseEntity = new CourseEntity();
            BeanUtils.copyProperties(courseDto, courseEntity);
            return courseRepository.updateCourse(courseEntity) != 0;
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean removeCourse(Long id, Long teacherId) {
        try {
            return courseRepository.removeCourse(id,teacherId);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean joinCourse(String code) {
        return false;
    }

    @Override
    public boolean exitCourse(String courseId) {
        return false;
    }
}
