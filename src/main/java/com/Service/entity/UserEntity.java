package com.Service.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "用户表数据库实体类")
@TableName(value = "user")
public class UserEntity implements Serializable {
    @ApiModelProperty(value = "用户id，主键自增",example = "1",position = 1,required = true)
    @TableId(value = "id")
    private Long id;
    @ApiModelProperty(value = "用户名,最大长度20",example = "字符串",position = 2,required = true)
    @TableField(value = "username")
    private String username;
    @ApiModelProperty(value = "密码,最大长度255",example = "字符串",position = 3,required = true)
    @TableField(value = "password")
    private String password;
    @ApiModelProperty(value = "用户的身份标识",example = "0/1",position = 4,required = true)
    @TableField(value = "identity")
    private String identity;
    @ApiModelProperty(value = "用户的名称",example = "1",position = 5)
    @TableField(value = "name")
    private String name;
    @ApiModelProperty(value = "学号/教工号",example = "1",position = 6)
    @TableField(value = "number")
    private String number;
}
