package com.Service.service;

import com.Service.dto.StudentHomeworkDto;
import com.Service.entity.StudentHomeworkEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface StudentHomeworkService extends IService<StudentHomeworkEntity> {
    StudentHomeworkDto viewCommit(Long id);
    boolean marking(StudentHomeworkDto studentHomeworkDto);
    List<StudentHomeworkDto> getAllHomeworkInfo(Long id);
}
