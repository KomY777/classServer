package com.Service.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
@ApiModel(value = "文件表数据库实体类")
public class FileEntity implements Serializable {
    @ApiModelProperty(value = "文件id，主键自增",example = "1",position = 1,required = true)
    private Integer id;
    @ApiModelProperty(value = "教师id，外键",example = "1",position = 2,required = true)
    private Integer teacherId;
    @ApiModelProperty(value = "文件名",example = "1",position = 3)
    private String fileName;
    @ApiModelProperty(value = "备注",example = "1",position = 4)
    private String remark;
    @ApiModelProperty(value = "创建时间",example = "1",position = 5)
    private Date createTime;
}
