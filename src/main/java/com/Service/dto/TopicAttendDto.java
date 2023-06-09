package com.Service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
@ApiModel(value = "话题讨论数据传输对象")
public class TopicAttendDto implements Serializable {
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
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="YYYY-MM-dd HH:mm:ss")
    private Date createTime;
}
