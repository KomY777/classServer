package com.Service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "参与课程数据传输对象")
public class StudentCourseDto implements Serializable {
    @ApiModelProperty(value = "课程id，主键自增",example = "1",position = 1,required = true)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    @ApiModelProperty(value = "课程名称，最大长度20",example = "字符串",position = 2)
    private String courseName;
    @ApiModelProperty(value = "学生id,外键",example = "1",position = 3,required = true)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long studentId;
    @ApiModelProperty(value = "课程id,外键",example = "1",position = 4,required = true)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long courseId;
    @ApiModelProperty(value = "学生的状态",example = "1",position = 5)
    private Integer state;
    @ApiModelProperty(value = "更新时间",example = "1",position = 6)
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="YYYY-MM-dd HH:mm:ss")
    private Date updateTime;
    @ApiModelProperty(value = "课程码",example = "1",position = 7)
    private String coruseCode;

}
