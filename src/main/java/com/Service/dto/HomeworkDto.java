package com.Service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
@ApiModel(value = "作业表数据传输对象")
public class HomeworkDto implements Serializable {
    @ApiModelProperty(value = "作业id，主键自增",example = "1",position = 1,required = true)
    private Long id;
    @ApiModelProperty(value = "课程id，外键",example = "1",position = 2,required = true)
    private Long courseId;
    @ApiModelProperty(value = "课程状态",example = "0/1",position = 3)
    private Integer homeworkState;
    @ApiModelProperty(value = "课程状态",example = "0/1",position = 4)
    private String title;
    @ApiModelProperty(value = "备注",example = "字符串",position = 5)
    private String remark;
    @ApiModelProperty(value = "文件路径",example = "字符串",position = 6)
    private String filePath;
    @ApiModelProperty(value = "创建时间",example = "1",position = 7)
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="YYYY-MM-dd HH:mm:ss")
    private Date startTime;
    @ApiModelProperty(value = "结束时间",example = "1",position = 8)
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="YYYY-MM-dd HH:mm:ss")
    private Date endTime;
}
