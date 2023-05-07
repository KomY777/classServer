package com.Service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
@Data
@ApiModel(value = "课程表数据传输对象")
public class CourseDto implements Serializable {
    @ApiModelProperty(value = "课程id，主键自增",example = "1",position = 1,required = true)
    private Integer id;
    @ApiModelProperty(value = "课程id，主键自增",example = "1",position = 1,required = true)
    private String courseName;
    @ApiModelProperty(value = "课程id，主键自增",example = "1",position = 1,required = true)
    private String courseState;
    @ApiModelProperty(value = "课程教师id,外键",example = "1",position = 4, required =true)
    private String teacherId;
}
