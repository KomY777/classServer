package com.Service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "用户数据传输对象")
public class UserDto implements Serializable {
    @ApiModelProperty(value = "用户id，主键自增",example = "1",position = 1,required = true)
    private Long id;
    @ApiModelProperty(value = "用户名,最大长度20",example = "字符串",position = 2)
    private String username;
    @ApiModelProperty(value = "密码,最大长度255",example = "字符串",position = 3)
    private String password;
    @ApiModelProperty(value = "用户的身份标识",example = "0/1",position = 4)
    private Integer identity;
    @ApiModelProperty(value = "用户的名称",example = "1",position = 5)
    private String name;
    @ApiModelProperty(value = "学号/教工号",example = "1",position = 6)
    private String number;
}
