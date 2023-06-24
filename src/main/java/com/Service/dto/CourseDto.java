package com.Service.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "课程表数据传输对象")
public class CourseDto implements Serializable {
    @ApiModelProperty(value = "课程id，主键自增",example = "1",position = 1,required = true)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    @ApiModelProperty(value = "课程名",example = "1",position = 2)
    private String courseName;
    @ApiModelProperty(value = "班级",example = "1",position = 3)
    private String className;
    @ApiModelProperty(value = "课程状态",example = "1",position = 4)
    private Integer courseState;
    @ApiModelProperty(value = "课程教师id,外键",example = "1",position = 5, required =true)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long teacherId;
    @ApiModelProperty(value = "学年",example = "2022-2023",position = 6)
    private String academicYear;
    @ApiModelProperty(value = "学期",example = "第一学期",position = 7)
    private String semester;
    @ApiModelProperty(value = "课程码",example = "485S8Y",position = 8)
    private String courseCode;

    private String teacherName;
}
