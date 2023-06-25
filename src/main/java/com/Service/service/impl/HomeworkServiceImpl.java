package com.Service.service.impl;


import com.Service.dto.HomeworkDto;
import com.Service.dto.StudentHomeworkDto;
import com.Service.entity.HomeworkEntity;
import com.Service.entity.StudentHomeworkEntity;
import com.Service.repository.HomeworkRepository;
import com.Service.repository.StudentCourseRepository;
import com.Service.repository.StudentHomeworkRepository;
import com.Service.service.HomeworkService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class HomeworkServiceImpl extends ServiceImpl<HomeworkRepository, HomeworkEntity> implements HomeworkService {

    @Autowired
    private HomeworkRepository homeworkRepository;
    @Autowired
    private StudentHomeworkRepository studentHomeworkRepository;
    @Autowired
    private StudentCourseRepository studentCourseRepository;

    @Override
    public boolean createHomework(HomeworkDto homeworkDto) {
        try{
            HomeworkEntity homeworkEntity = new HomeworkEntity();
            BeanUtils.copyProperties(homeworkDto, homeworkEntity);
            homeworkRepository.insert(homeworkEntity);
            List<Long> list = studentCourseRepository.selectStudentIdBycourseId(homeworkDto.getCourseId());
            for(Long id : list) {
                StudentHomeworkEntity studentHomeworkEntity = new StudentHomeworkEntity();
                studentHomeworkEntity.setCommitState("0");
                studentHomeworkEntity.setStudentId(id);
                studentHomeworkEntity.setHomeworkId(homeworkEntity.getId());
                studentHomeworkRepository.insert(studentHomeworkEntity);
            }
            return  true;
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
            for (HomeworkEntity homeworkEntity : listEntity){
                HomeworkDto homeworkDto =new HomeworkDto();
                BeanUtils.copyProperties(homeworkEntity,homeworkDto);
                listDto.add(homeworkDto);
            }
            return listDto;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public HomeworkDto Correcting(Long id) {
        try{
            HomeworkEntity homeworkEntity = homeworkRepository.selectById(id);
            HomeworkDto homeworkDto = new HomeworkDto();
            BeanUtils.copyProperties(homeworkEntity, homeworkDto);
            return homeworkDto;
        }catch (Exception e) {
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

    @Override
    public boolean commitHomework(StudentHomeworkDto studentHomeworkDto) {
        try{
            StudentHomeworkEntity studentHomeworkEntity = new StudentHomeworkEntity();
            BeanUtils.copyProperties(studentHomeworkDto, studentHomeworkEntity);
            return studentHomeworkRepository.updateById(studentHomeworkEntity) == 1;
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<String> uploadFile(MultipartFile[] files) {
        try{
            ArrayList<String> paths = new ArrayList<String>();
            for (MultipartFile file : files) {
                String fileName = file.getOriginalFilename();
                String filePath = "../upload/" + fileName;
                file.transferTo(new File(filePath));
                paths.add(filePath);
            }
            return paths;
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
    }
}
