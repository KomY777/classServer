package com.Service.controller;

import com.Service.conf.Result;
import com.Service.dto.UserDto;
import com.Service.service.UserService;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(path = "/user", produces = "application/json;charset=UTF-8")
@Slf4j
@Api(tags = "用户登录信息表")
public class UserController {

    @Autowired
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @ApiOperation(value = "注册新用户",notes = "权限，无")
    @RequestMapping(path = "/register",method = RequestMethod.POST)
    public Result<String> addUser(@RequestBody UserDto userDto) throws RuntimeException {
        try {
            if (userService.addUser(userDto)) {
                return Result.success(null, "User added successfully");
            }
            return Result.error("注册失败");
        }catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }


    @ApiOperation(value = "更改密码",notes = "权限，无")
    @RequestMapping(path = "/update",method = RequestMethod.GET)
    public Result<String> updateUser(@RequestParam String username, String password, String newPassword) throws RuntimeException{
        try {
            if (userService.updateUser(username, password, newPassword)) {
                return Result.success(null, "修改成功");
            }
            return Result.error("修改失败");
        }catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation(value = "注销用户",notes = "权限，无")
    @RequestMapping(path = "/logout",method = RequestMethod.GET)
    public Result<String> removeUser(HttpServletRequest request) throws RuntimeException{
        try {
            request.getSession().removeAttribute("user");
            request.getSession().removeAttribute("name");
            request.getSession().invalidate();
            return Result.success(null, "ok");
        }catch (Exception e){
            return Result.error(e.getMessage());
        }
    }
    @ApiOperation(value = "用户登录",notes = "权限，无")
    @RequestMapping(path = "/login",method = RequestMethod.GET)
    public Result<Object> login(@RequestParam String username, String password, HttpServletRequest request) throws RuntimeException{
       try {
           UserDto userDto = userService.login(username, password);
           if (userDto == null) {
               return Result.error("登录失败");
           } else {
               SimplePropertyPreFilter filter = new SimplePropertyPreFilter(UserDto.class, "id");
               String jsonString = JSONObject.toJSONString(userDto,filter);
               JSONObject jsonObject = JSONObject.parseObject(jsonString);
               request.getSession().setAttribute("user", userDto.getId());
               request.getSession().setAttribute("name", userDto.getName());
               return Result.success(jsonObject, "登录成功");
           }
       } catch (Exception e) {
           return Result.error(e.getMessage());
       }
    }
}
