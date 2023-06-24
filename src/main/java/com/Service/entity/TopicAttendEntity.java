package com.Service.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
@ApiModel(value = "用户参与讨论数据库实体类")
public class TopicAttendEntity implements Serializable {
    @ApiModelProperty(value = "每个留言的id，主键自增",example = "1",position = 1,required = true)
    private Long id;
    @ApiModelProperty(value = "话题id，外键",example = "1",position = 2,required = true)
    private Long topicId;
    @ApiModelProperty(value = "话题状态",example = "1",position = 3)
    private String topicState;
    @ApiModelProperty(value = "留言的创建者",example = "1",position = 4)
    private String createBy;
    @ApiModelProperty(value = "正文",example = "1",position = 5)
    private String remark;
    @ApiModelProperty(value = "创建时间",example = "1",position = 6)
    private Date createTime;
}
