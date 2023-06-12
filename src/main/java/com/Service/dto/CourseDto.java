package com.Service.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "课程表数据传输对象")
public class CourseDto implements Serializable {
    @ApiModelProperty(value = "课程id，主键自增",example = "1",position = 1,required = true)
    private Long id;
    @ApiModelProperty(value = "课程id，主键自增",example = "1",position = 1,required = true)
    private String courseName;
    @ApiModelProperty(value = "课程id，主键自增",example = "1",position = 1,required = true)
    private String courseState;
    @ApiModelProperty(value = "课程教师id,外键",example = "1",position = 4, required =true)
    private String teacherId;
    @ApiModelProperty(value = "学年",example = "2022-2023",position = 5)
    private String academicYear;
    @ApiModelProperty(value = "学期",example = "第一学期",position = 6)
    private String semester;
}
