package com.Service.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
@ApiModel(value = "学生作业完成情况数据库实体类")
public class StudentHomeworkEntity implements Serializable {
    @ApiModelProperty(value = "学生作业id，主键自增",example = "1",position = 1,required = true)
    private Integer id;
    @ApiModelProperty(value = "作业id,外键",example = "1",position = 2,required = true)
    private Integer homeworkId;
    @ApiModelProperty(value = "作业状态",example = "1",position = 3)
    private String homeworkState;
    @ApiModelProperty(value = "学生id,外键",example = "1",position = 4, required =true)
    private Integer studentId;
    @ApiModelProperty(value = "作业提交状态",example = "0/1",position = 5)
    private String commitState;
    @ApiModelProperty(value = "作业成绩",example = "1",position = 6)
    private String grade;
    @ApiModelProperty(value = "备注",example = "1",position =7)
    private String remark;
    @ApiModelProperty(value = "创建时间",example = "1",position = 8)
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @ApiModelProperty(value = "结束时间",example = "1",position = 9)
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date endTime;
    @ApiModelProperty(value = "提交时间",example = "1",position = 10)
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date commitTime;
}
