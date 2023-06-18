package com.Service.controller;

import com.Service.conf.Result;
import com.Service.dto.CourseDto;
import com.Service.service.CourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        try {
            if (courseService.addCourse(courseDto)) {
                return Result.success(null, "success");
            }else {
            return Result.error("fail");
            }
        }catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }
    @ApiOperation(value = "修改课程信息",notes = "权限，老师")
    @RequestMapping(path = "/updateCourse",method = RequestMethod.POST)
    public Result<String> updateCourse(@RequestBody CourseDto courseDto){
        try {
            if (courseService.updateCourse(courseDto)) {
                return Result.success(null, "success");
            }else {
            return Result.error("fail");
            }
        }catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }
    @ApiOperation(value = "删除课程",notes = "权限，老师")
    @RequestMapping(path = "/removeCourse",method = RequestMethod.GET)
    public Result<String> removeCourse(@RequestParam Long id,Long teacherId){
        try {
            if (courseService.removeCourse(id, teacherId)) {
                return Result.success(null, "success");
            }else {
            return Result.error("fail");
            }
        }catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation(value = "获取课程码",notes = "权限，老师")
    @RequestMapping(path = "/getCourseCode",method = RequestMethod.GET)
    public Result<String> getCourseCode(@RequestParam Long id,Long teacherId){
        try{
            String code = courseService.getCourseCode(id,teacherId);
                return Result.success(code, "success");
        }catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }
}
