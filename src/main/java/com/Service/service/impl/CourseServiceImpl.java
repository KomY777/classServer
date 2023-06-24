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

import java.util.ArrayList;
import java.util.List;


@Service
public class CourseServiceImpl extends ServiceImpl<CourseRepository, CourseEntity> implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public boolean addCourse(CourseDto courseDto) {
        try {
            CourseEntity courseEntity = new CourseEntity();
            BeanUtils.copyProperties(courseDto, courseEntity);
            courseEntity.setCourseCode(Transform.fromDecimal(System.currentTimeMillis()%1000000000));
            return courseRepository.addCourse(courseEntity) !=0;
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
            String code = Transform.fromDecimal(System.currentTimeMillis()%1000000000);
            if (courseRepository.getCourseCode(id,teacherId,code) != 0){
                return code;
            }else {
                throw new RuntimeException("获取失败");
            }
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<CourseDto> getCourse(Long id) {
        try{
           List <CourseEntity> courseEntityList = courseRepository.getCourse(id);
           List<CourseDto> list =new ArrayList<>();
           for (CourseEntity entity : courseEntityList){
               CourseDto courseDto = new CourseDto();
               BeanUtils.copyProperties(entity,courseDto);
               courseDto.setTeacherName(courseRepository.getName(courseDto.getTeacherId()));
               list.add(courseDto);
           }
           return list;
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public CourseDto getOneCourse(Long id) {
        try{
            CourseEntity courseEntity = courseRepository.selectById(id);
            CourseDto courseDto = new CourseDto();
            BeanUtils.copyProperties(courseEntity, courseDto);
            return courseDto;
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean archiveCourse(Long id) {
        try{
            archiveMe(id,2);
          return courseRepository.archiveCourse(id);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean archiveMe(Long id,Integer state) {
        try{
            return courseRepository.archiveMe(id,state);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
