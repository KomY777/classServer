package com.Service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
@ApiModel(value = "文件数据传输对象")
public class FileDto implements Serializable {
    @ApiModelProperty(value = "文件id，主键自增",example = "1",position = 1,required = true)
    private Long id;
    @ApiModelProperty(value = "教师id，外键",example = "1",position = 2,required = true)
    private Long teacherId;
    @ApiModelProperty(value = "文件名",example = "1",position = 3)
    private String fileName;
    @ApiModelProperty(value = "备注",example = "1",position = 4)
    private String remark;
    @ApiModelProperty(value = "创建时间",example = "1",position = 5)
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;
}
