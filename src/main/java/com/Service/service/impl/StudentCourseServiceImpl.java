package com.Service.service.impl;

import com.Service.dto.StudentCourseDto;
import com.Service.entity.StudentCourseEntity;
import com.Service.repository.StudentCourseRepository;
import com.Service.service.StudentCourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentCourseServiceImpl extends ServiceImpl<StudentCourseRepository, StudentCourseEntity> implements StudentCourseService {

    @Autowired
    private StudentCourseRepository studentCourseRepository;

    @Override
    public boolean joinCourse(StudentCourseDto studentCourseDto) {
        try{
            String courseCode = studentCourseDto.getCoruseCode();
            StudentCourseEntity studentCourseEntity = new StudentCourseEntity();
            BeanUtils.copyProperties(studentCourseDto, studentCourseEntity);
           return studentCourseRepository.joinCourse(studentCourseEntity,courseCode) ==  1;
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean exitCourse(Long id) {
        try{
            return studentCourseRepository.deleteById(id) == 1;
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
