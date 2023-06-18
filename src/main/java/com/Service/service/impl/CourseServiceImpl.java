package com.Service.service.impl;

import com.Service.dto.CourseDto;
import com.Service.entity.CourseEntity;
import com.Service.repository.CourseRepository;
import com.Service.service.CourseService;
import com.Service.util.Transform;
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
    public String getCourseCode(Long id,Long teacherId) {
        try{
            String code = Transform.fromDecimal(System.currentTimeMillis()%100000000);
            if (courseRepository.getCourseCode(id,teacherId,code) != 0){
                return code;
            }else {
                throw new RuntimeException("获取失败");
            }
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
