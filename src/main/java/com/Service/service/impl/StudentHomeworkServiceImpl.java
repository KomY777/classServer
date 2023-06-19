package com.Service.service.impl;

import com.Service.entity.StudentHomeworkEntity;
import com.Service.repository.StudentHomeworkRepository;
import com.Service.service.StudentHomeworkService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class StudentHomeworkServiceImpl extends ServiceImpl<StudentHomeworkRepository, StudentHomeworkEntity> implements StudentHomeworkService {

}
