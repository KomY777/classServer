package com.Service.service.impl;

import com.Service.dto.StudentHomeworkDto;
import com.Service.entity.StudentHomeworkEntity;
import com.Service.repository.StudentHomeworkRepository;
import com.Service.service.StudentHomeworkService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class StudentHomeworkServiceImpl extends ServiceImpl<StudentHomeworkRepository, StudentHomeworkEntity> implements StudentHomeworkService {

    @Autowired
    private StudentHomeworkRepository studentHomeworkRepository;
    @Override
    public StudentHomeworkDto viewCommit(Long id) {
        try{
           StudentHomeworkEntity studentHomeworkEntity = studentHomeworkRepository.selectById(id);
           StudentHomeworkDto studentHomeworkDto = new StudentHomeworkDto();
           BeanUtils.copyProperties(studentHomeworkEntity, studentHomeworkDto);
           return studentHomeworkDto;
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean marking(StudentHomeworkDto studentHomeworkDto) {
        try{
            StudentHomeworkEntity studentHomeworkEntity = new StudentHomeworkEntity();
            BeanUtils.copyProperties(studentHomeworkDto, studentHomeworkEntity);
            return studentHomeworkRepository.updateById(studentHomeworkEntity)==1;
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<StudentHomeworkDto> getAllHomeworkInfo(Long id) {
        try{
           List<StudentHomeworkEntity> list =  studentHomeworkRepository.getAllHomeworkInfo(id);
            List<StudentHomeworkDto> listDto = new ArrayList<StudentHomeworkDto>();
            for (StudentHomeworkEntity studentHomeworkEntity : list){
                StudentHomeworkDto studentHomeworkDto =new StudentHomeworkDto();
                BeanUtils.copyProperties(studentHomeworkEntity,studentHomeworkDto);
                listDto.add(studentHomeworkDto);
            }
           return listDto;
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
