package com.Service.service;

import com.Service.dto.HomeworkDto;
import com.Service.entity.HomeworkEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface HomeworkService extends IService<HomeworkEntity> {
    public boolean createHomework(HomeworkDto homeworkDto);
    public boolean updateHomework(HomeworkDto homeworkDto);
    public List<HomeworkDto> getAllHomework(Long courseId);
    public boolean deleteHomework(Long homeworkId);

}
