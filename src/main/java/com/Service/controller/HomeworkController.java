package com.Service.controller;

import com.Service.conf.Result;
import com.Service.dto.HomeworkDto;
import com.Service.service.HomeworkService;
import com.Service.service.StudentHomeworkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @ApiOperation(value = "获取作业信息",notes = "权限，无")
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
    @RequestMapping(value = "/uploadImage", method = RequestMethod.POST)
    public Result<String> uploadImageFile(@RequestParam("img") MultipartFile uploadImage,
                                          @RequestParam String token,
                                          @RequestParam String type){
        System.out.println(uploadImage);
        System.out.println(token);
        System.out.println(type);
        return  Result.error("");
    }

}
