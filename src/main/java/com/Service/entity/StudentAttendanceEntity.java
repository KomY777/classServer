package com.Service.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
@ApiModel(value = "学生考勤情况数据库实体类")
public class StudentAttendanceEntity implements Serializable {
    @ApiModelProperty(value = "每个学生考勤情况id，主键自增",example = "1",position = 1,required = true)
    private Long id;
    @ApiModelProperty(value = "考勤id，外键",example = "1",position = 2,required = true)
    private Long attendanceId;
    @ApiModelProperty(value = "考勤状态",example = "0/1",position = 3)
    private Integer attendaceState;
    @ApiModelProperty(value = "学生id，外键",example = "1",position = 4,required = true)
    private Long studentId;
    @ApiModelProperty(value = "签到状态",example = "0/1",position = 5)
    private Integer studentState;
    @ApiModelProperty(value = "创建时间",example = "1",position = 6)
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @ApiModelProperty(value = "结束时间",example = "1",position = 7)
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date endTime;
    @ApiModelProperty(value = "提交时间",example = "1",position = 8)
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date commitTime;
}
