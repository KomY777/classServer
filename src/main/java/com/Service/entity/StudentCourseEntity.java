package com.Service.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "学生参加课程数据库实体类")
@TableName(value = "course_student")
public class StudentCourseEntity implements Serializable {
    @ApiModelProperty(value = "参加的课程id，主键自增",example = "1",position = 1,required = true)
    @TableId(value = "id")
    private Long id;
    @ApiModelProperty(value = "课程名称，最大长度20",example = "字符串",position = 2)
    @TableField(value = "course_name")
    private String courseName;
    @ApiModelProperty(value = "学生id,外键",example = "1",position = 3,required = true)
    @TableField(value = "student_id")
    private Long studentId;
    @ApiModelProperty(value = "课程id,外键",example = "1",position = 4,required = true)
    @TableField(value = "course_id")
    private Long courseId;
    @ApiModelProperty(value = "学生的状态",example = "1",position = 5)
    @TableField(value = "state")
    private Integer state;
    @ApiModelProperty(value = "更新时间",example = "1",position = 6)
    @TableField(value = "update_time")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

}
