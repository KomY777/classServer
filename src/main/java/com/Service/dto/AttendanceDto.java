package com.Service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
@ApiModel(value = "考勤表数据传输对象")
public class AttendanceDto implements Serializable {
    @ApiModelProperty(value = "考勤id，主键自增",example = "1",position = 1,required = true)
    private Long id;
    @ApiModelProperty(value = "课程id，外键",example = "1",position = 2,required = true)
    private Long courseId;
    @ApiModelProperty(value = "考勤状态",example = "0/1",position = 3)
    private Integer  attendanceState;
    @ApiModelProperty(value = "创建者",example = "字符串",position = 4)
    private String createBy;
    @ApiModelProperty(value = "创建时间",example = "1",position = 5)
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @ApiModelProperty(value = "结束时间",example = "1",position = 6)
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date endTime;

}
