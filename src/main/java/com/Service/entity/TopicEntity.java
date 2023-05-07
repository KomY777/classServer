package com.Service.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
@ApiModel(value = "话题表数据库实体类")
public class TopicEntity implements Serializable {
    @ApiModelProperty(value = "话题id，主键自增",example = "1",position = 1,required = true)
    private Integer id;
    @ApiModelProperty(value = "课程id，外键",example = "1",position = 2,required = true)
    private Integer courseId;
    @ApiModelProperty(value = "创建者",example = "1",position = 3)
    private String createBy;
    @ApiModelProperty(value = "话题状态",example = "1",position = 4)
    private String topicState;
    @ApiModelProperty(value = "标题",example = "1",position = 5)
    private String title;
    @ApiModelProperty(value = "正文",example = "1",position = 6)
    private String remark;
    @ApiModelProperty(value = "创建时间",example = "1",position = 7)
    private Date createTime;
}
