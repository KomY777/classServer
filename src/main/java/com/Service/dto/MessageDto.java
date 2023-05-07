package com.Service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
@ApiModel(value = "消息表数据传输对象")
public class MessageDto implements Serializable {
    @ApiModelProperty(value = "消息id，主键自增",example = "1",position = 1,required = true)
    private Integer id;
    @ApiModelProperty(value = "消息发送者",example = "1",position = 2,required = true)
    private String createBy;
    @ApiModelProperty(value = "学生id,外键",example = "1",position = 3,required = true)
    private Integer studentId;
    @ApiModelProperty(value = "消息体",example = "字符串",position = 4)
    private String messageName;
    @ApiModelProperty(value = "消息正文",example = "字符串",position = 5)
    private String remark;
    @ApiModelProperty(value = "消息发送时间",example = "字符串",position = 6)
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;
}
