package com.Service.repository;

import com.Service.entity.HomeworkEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface HomeworkRepository extends BaseMapper<HomeworkEntity> {
    public List<HomeworkEntity> getAll(Long courseId);
}
