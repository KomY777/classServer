package com.Service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
@Data
@ApiModel(value = "参与课程数据传输对象")
public class StudentCourseDto implements Serializable {
    @ApiModelProperty(value = "课程id，主键自增",example = "1",position = 1,required = true)
    private Integer id;
    @ApiModelProperty(value = "课程名称，最大长度20",example = "字符串",position = 2)
    private String courseName;
    @ApiModelProperty(value = "课程状态",example = "0/1",position = 3)
    private String courseStatus;
    @ApiModelProperty(value = "学生id,外键",example = "1",position = 4,required = true)
    private Integer studentId;
    @ApiModelProperty(value = "课程id,外键",example = "1",position = 5,required = true)
    private Integer courseId;

}
