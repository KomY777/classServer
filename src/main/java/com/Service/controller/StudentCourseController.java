package com.Service.controller;

import com.Service.conf.Result;
import com.Service.dto.CourseDto;
import com.Service.dto.StudentCourseDto;
import com.Service.service.StudentCourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/studentCourse", produces = "application/json;charset=UTF-8")
@Slf4j
@Api(tags = "学生课程管理表")

public class StudentCourseController {
    @Autowired
    private final StudentCourseService studentCourseService;

    @Autowired
    public StudentCourseController(StudentCourseService studentCourseService) {
        this.studentCourseService = studentCourseService;
    }

    @ApiOperation(value = "加入课程",notes = "权限，无")
    @RequestMapping(path = "/joinCourse",method = RequestMethod.POST)
    public Result<String> joinCourse(@RequestBody StudentCourseDto studentCourseDto){
        try{
            if(studentCourseService.joinCourse(studentCourseDto)){
                return Result.success(null,"success");
            }else {
                return Result.error("加入失败，请检查是否已加入课程");
            }
        }catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }
    @ApiOperation(value = "退出课程",notes = "权限，无")
    @RequestMapping(path = "/exitCourse",method = RequestMethod.GET)
    public Result<String> exitCourse(@RequestParam Long id){
        try{

            if(studentCourseService.exitCourse(id)){
                return Result.success(null,"success");
            }else {
                return Result.error("退出失败，请检查是否已加入课程");
            }
        }catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation(value = "课程归档",notes = "权限，无")
    @RequestMapping(path = "/archive",method = RequestMethod.GET)
    public Result<String> archiveCourse(@RequestParam Long id){
        try{

            if(studentCourseService.archiveCourse(id)){
                return Result.success(null,"success");
            }else {
                return Result.error("归档失败，请检查是否已加入课程");
            }
        }catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }
    @ApiOperation(value = "获取课程信息",notes = "权限，学生")
    @RequestMapping(path = "/getCourse",method = RequestMethod.GET)
    public Result<List<CourseDto>> getCourse(@RequestParam Long id){
        try{
            List<CourseDto> list = studentCourseService.getCourse(id);
            if(list.size()!=0){
                return Result.success(list,"success");
            }else {
                return Result.error("请检查是否已加入课程");
            }
        }catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }
}
