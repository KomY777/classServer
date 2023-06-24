package com.Service.service;

import com.Service.dto.HomeworkDto;
import com.Service.entity.HomeworkEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

public interface HomeworkService extends IService<HomeworkEntity> {
     boolean createHomework(HomeworkDto homeworkDto);
     boolean updateHomework(HomeworkDto homeworkDto);
     List<HomeworkDto> getAllHomework(Long courseId);
     boolean deleteHomework(Long homeworkId);
    ArrayList<String> uploadFile(MultipartFile[] files);
}
