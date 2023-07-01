package com.Service.controller;

import com.Service.conf.Result;
import com.Service.dto.HomeworkDto;
import com.Service.dto.StudentHomeworkDto;
import com.Service.service.HomeworkService;
import com.Service.service.StudentHomeworkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(path = "/api/studentHomework", produces = "application/json;charset=UTF-8")
@Slf4j
@Api(tags = "作业管理表")
public class HomeworkController {
    @Autowired
    private final HomeworkService homeworkService;
    @Autowired
    private final StudentHomeworkService studentHomeworkService;

    @Autowired
    public HomeworkController(HomeworkService homeworkService,StudentHomeworkService studentHomeworkService) {
        this.homeworkService = homeworkService;
        this.studentHomeworkService = studentHomeworkService;
    }

    @ApiOperation(value = "发布作业",notes = "权限，老师")
    @RequestMapping(value = "/creatHomework", method = RequestMethod.POST)
    public Result<String> createHomework(@RequestBody HomeworkDto homeworkDto){
       if (homeworkService.createHomework(homeworkDto)){
           return Result.success(null,"success");
       }
        return  Result.error("");
    }


    @ApiOperation(value = "修改作业",notes = "权限，老师")
    @RequestMapping(value = "/updateHomework", method = RequestMethod.POST)
    public Result<String> updateHomework(@RequestBody HomeworkDto homeworkDto){
        if (homeworkService.updateHomework(homeworkDto)){
            return Result.success(null,"success");
        }
        return  Result.error("");
    }
    @ApiOperation(value = "提交作业",notes = "权限，老师")
    @RequestMapping(value = "/commitHomework", method = RequestMethod.POST)
    public Result<String> commitHomework(@RequestBody StudentHomeworkDto studentHomeworkDto){
        if (homeworkService.commitHomework(studentHomeworkDto)){
            return Result.success(null,"success!!");
        }
        return  Result.error("");
    }

    @ApiOperation(value = "获取全部作业信息",notes = "权限，无")
    @RequestMapping(value = "/getAllHomework", method = RequestMethod.GET)
    public Result<List<HomeworkDto>> getAllHomework(@RequestParam Long courseId){
       List<HomeworkDto> list = homeworkService.getAllHomework(courseId);
       if (list !=null) {
           return Result.success(list, "success");
       }
        return  Result.error("");
    }
    @ApiOperation(value = "删除作业",notes = "权限，教师")
    @RequestMapping(value = "/deleteHomework", method = RequestMethod.GET)
    public Result<String> deleteHomework(@RequestParam Long homeworkId){
        if (homeworkService.deleteHomework(homeworkId)){
            return Result.success(null,"success");
        }
        return  Result.error("");
    }

    @ApiOperation(value = "获取作业详情信息",notes = "权限，无")
    @RequestMapping(value = "/Correcting", method = RequestMethod.GET)
    public Result<HomeworkDto> Correcting(@RequestParam Long homeworkId){
        HomeworkDto homeworkDto = homeworkService.Correcting(homeworkId);
        if (homeworkDto !=null) {
            return Result.success(homeworkDto, "success");
        }
        return  Result.error("");
    }
    @ApiOperation(value = "查看学生提交的作业",notes = "权限，无")
    @RequestMapping(value = "/viewCommit", method = RequestMethod.GET)
    public Result<StudentHomeworkDto> viewCommit(@RequestParam Long studentHomeworkId){
        StudentHomeworkDto studentHomeworkDto = studentHomeworkService.viewCommit(studentHomeworkId);
        if (studentHomeworkDto !=null) {
            return Result.success(studentHomeworkDto, "success");
        }
        return  Result.error("");
    }
    @ApiOperation(value = "查询所有学生作业信息",notes = "权限，无")
    @RequestMapping(value = "/getAllHomeworkInfo", method = RequestMethod.GET)
    public Result<List<StudentHomeworkDto>> getAllHomeworkInfo(@RequestParam Long homeworkId){
        try {
            List<StudentHomeworkDto> list =studentHomeworkService.getAllHomeworkInfo(homeworkId);
            if (list.size()!=0) {
                return Result.success(list, "success");
            }
            return Result.error("");
        }catch (Exception e) {
            return Result.error("");
        }
    }
    @ApiOperation(value = "批改作业",notes = "权限，无")
    @RequestMapping(value = "/marking", method = RequestMethod.POST)
    public Result<String> marking(@RequestBody StudentHomeworkDto studentHomework){
        if(studentHomeworkService.marking(studentHomework)){
            return Result.success(null, "success");
        }
        return  Result.error("");
    }

    @ApiOperation(value = "上传文件",notes = "权限，无")
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public Result<ArrayList<String>> uploadFile(@RequestParam("file") MultipartFile[] file){
        try{
            ArrayList<String> filePath =homeworkService.uploadFile(file);
            if (filePath.size()!=0) {
                return Result.success(filePath,"success");
            }else {
                return Result.error("error");
            }
        }catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }
}
