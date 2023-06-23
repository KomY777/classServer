package com.Service.service.impl;

import com.Service.dto.CourseDto;
import com.Service.dto.StudentCourseDto;
import com.Service.entity.CourseEntity;
import com.Service.entity.StudentCourseEntity;
import com.Service.repository.CourseRepository;
import com.Service.repository.StudentCourseRepository;
import com.Service.service.StudentCourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class StudentCourseServiceImpl extends ServiceImpl<StudentCourseRepository, StudentCourseEntity> implements StudentCourseService {

    @Autowired
    private StudentCourseRepository studentCourseRepository;
    @Autowired
    private CourseRepository courseRepository;

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

    @Override
    public List<CourseDto> getCourse(Long id) {
        try{
            List <Long> courseIdList = studentCourseRepository.getCourse(id);
            List<CourseDto> list =new ArrayList<>();
            for (Long courseId : courseIdList){
                CourseEntity courseEntity = courseRepository.selectById(courseId);
                CourseDto courseDto = new CourseDto();
                BeanUtils.copyProperties(courseEntity, courseDto);
                courseDto.setTeacherName(courseRepository.getName(courseDto.getTeacherId()));
                list.add(courseDto);
            }
            return list;
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean archiveCourse(Long id) {
        try{
          return studentCourseRepository.archiveCourse(id);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
