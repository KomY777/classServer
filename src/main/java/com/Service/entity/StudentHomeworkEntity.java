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
@ApiModel(value = "学生作业完成情况数据库实体类")
@TableName(value = "homework_student")
public class StudentHomeworkEntity implements Serializable {
    @ApiModelProperty(value = "学生作业id，主键自增",example = "1",position = 1,required = true)
    @TableId(value = "id")
    private Long id;
    @ApiModelProperty(value = "作业id,外键",example = "1",position = 2,required = true)
    @TableField(value = "homework_id")
    private Long homeworkId;
    @ApiModelProperty(value = "学生id,外键",example = "1",position = 4, required =true)
    @TableField(value = "student_id")
    private Long studentId;
    @ApiModelProperty(value = "作业提交状态",example = "0/1",position = 5)
    @TableField(value = "commit_state")
    private String commitState;
    @ApiModelProperty(value = "作业成绩",example = "1",position = 6)
    @TableField(value = "grade")
    private String grade;
    @ApiModelProperty(value = "备注",example = "1",position =7)
    @TableField(value = "remark")
    private String remark;
    @ApiModelProperty(value = "文件",example = "1",position =8)
    @TableField(value = "file")
    private String filePath;
    @ApiModelProperty(value = "更新时间",example = "1",position = 10)
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @TableField(value = "update_time")
    private Date updateTime;
}
