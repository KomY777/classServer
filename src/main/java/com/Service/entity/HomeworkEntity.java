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
@ApiModel(value = "作业表数据库实体类")
@TableName(value = "homework")
public class HomeworkEntity implements Serializable {
    @ApiModelProperty(value = "作业id，主键自增",example = "1",position = 1,required = true)
    @TableId(value = "id")
    private Long id;
    @ApiModelProperty(value = "课程id，外键",example = "1",position = 2,required = true)
    @TableField(value = "course_id")
    private Long courseId;
    @ApiModelProperty(value = "课程状态",example = "0/1",position = 3)
    @TableField(value = "homework_state")
    private Integer homeworkState;
    @ApiModelProperty(value = "标题",example = "0/1",position = 4)
    private String title;
    @ApiModelProperty(value = "备注",example = "字符串",position = 5)
    @TableField(value = "remark")
    private String remark;
    @ApiModelProperty(value = "文件路径",example = "字符串",position = 6)
    @TableField(value = "file")
    private String filePath;
    @ApiModelProperty(value = "创建时间",example = "1",position = 7)
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @TableField(value = "start_time")
    private Date startTime;
    @ApiModelProperty(value = "结束时间",example = "1",position = 8)
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @TableField(value = "end_time")
    private Date endTime;
}
