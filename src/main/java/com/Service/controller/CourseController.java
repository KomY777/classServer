package com.Service.controller;

import com.Service.conf.Result;
import com.Service.dto.CourseDto;
import com.Service.service.CourseService;
import com.Service.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/course", produces = "application/json;charset=UTF-8")
@Slf4j
@Api(tags = "课程管理表")
public class CourseController {
    @Autowired
    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @ApiOperation(value = "新增课程",notes = "权限，老师")
    @RequestMapping(path = "/addCourse",method = RequestMethod.POST)
    public Result<String> addCourse(@RequestBody CourseDto courseDto){
        if (courseService.addCourse(courseDto)){
            return Result.success(null,"success");
        }
        return Result.error("fail");
    }@ApiOperation(value = "修改课程信息",notes = "权限，老师")
    @RequestMapping(path = "/updateCourse",method = RequestMethod.POST)
    public Result<String> updateCourse(@RequestBody CourseDto courseDto){
        if (courseService.updateCourse(courseDto)){
            return Result.success(null,"success");
        }
        return Result.error("fail");
    }

}
