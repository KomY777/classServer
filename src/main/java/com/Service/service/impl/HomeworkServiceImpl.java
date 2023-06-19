package com.Service.service.impl;


import com.Service.dto.HomeworkDto;
import com.Service.entity.HomeworkEntity;
import com.Service.repository.HomeworkRepository;
import com.Service.service.HomeworkService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HomeworkServiceImpl extends ServiceImpl<HomeworkRepository, HomeworkEntity> implements HomeworkService {

    @Autowired
    private HomeworkRepository homeworkRepository;

    @Override
    public boolean createHomework(HomeworkDto homeworkDto) {
        try{
            HomeworkEntity homeworkEntity = new HomeworkEntity();
            BeanUtils.copyProperties(homeworkDto, homeworkEntity);
           return homeworkRepository.insert(homeworkEntity)==1;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean updateHomework(HomeworkDto homeworkDto) {
        try{
            HomeworkEntity homeworkEntity = new HomeworkEntity();
            BeanUtils.copyProperties(homeworkDto, homeworkEntity);
            return homeworkRepository.updateById(homeworkEntity)==1;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<HomeworkDto> getAllHomework(Long courseId) {
        try{
            List<HomeworkEntity> listEntity = homeworkRepository.getAll(courseId);
            List<HomeworkDto> listDto = new ArrayList<HomeworkDto>();
            HomeworkDto homeworkDto =new HomeworkDto();
            for (HomeworkEntity homeworkEntity : listEntity){
                BeanUtils.copyProperties(homeworkEntity,homeworkDto);
                listDto.add(homeworkDto);
            }
            return listDto;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteHomework(Long homeworkId) {
        try{
            return homeworkRepository.deleteById(homeworkId) == 1;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}