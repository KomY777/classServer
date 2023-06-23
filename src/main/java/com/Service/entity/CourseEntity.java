package com.Service.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "课程表数据库实体类")
@TableName(value = "course")
public class CourseEntity implements Serializable {
    @ApiModelProperty(value = "课程id，主键自增",example = "1",position = 1,required = true)
    @TableId(value = "id")
    private Long id;
    @ApiModelProperty(value = "课程名",example = "1",position = 2)
    @TableField(value = "course_name")
    private String courseName;
    @ApiModelProperty(value = "课程状态",example = "1",position = 3)
    @TableField(value = "course_state")
    private Integer courseState;
    @ApiModelProperty(value = "课程教师id,外键",example = "1",position = 4, required =true)
    @TableField(value = "teacher_id")
    private Long teacherId;
    @ApiModelProperty(value = "学年",example = "2022-2023",position = 5)
    @TableField(value = "academic_year")
    private String academicYear;
    @ApiModelProperty(value = "学期",example = "第一学期",position = 6)
    @TableField(value = "semester")
    private String semester;
    @ApiModelProperty(value = "班级",example = "1",position = 7)
    @TableField(value = "class_name")
    private String className;
    @ApiModelProperty(value = "课程码",example = "485S8Y",position = 8)
    @TableField(value = "course_code")
    private String courseCode;
}
