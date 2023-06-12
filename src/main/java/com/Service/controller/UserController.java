package com.Service.controller;

import com.Service.conf.Result;
import com.Service.dto.UserDto;
import com.Service.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
        if ( userService.addUser(userDto)) {
            return Result.success(null,"User added successfully");
        }
        return Result.error("注册失败");
    }


    @ApiOperation(value = "更改密码",notes = "权限，无")
    @RequestMapping(path = "/update",method = RequestMethod.POST)
    public Result<String> updateUser(@RequestBody UserDto userDto) throws RuntimeException{
        return Result.error("dsa");
    }

    @ApiOperation(value = "注销用户",notes = "权限，无")
    @RequestMapping(path = "/logout",method = RequestMethod.POST)
    public Result<String> removeUser(HttpServletRequest request) throws RuntimeException{
        request.getSession().removeAttribute("user");
        request.getSession().removeAttribute("name");
        request.getSession().invalidate();
        return Result.success(null,"ok");
    }
    @ApiOperation(value = "用户登录",notes = "权限，无")
    @RequestMapping(path = "/login",method = RequestMethod.POST)
    public Result<Object> login(@RequestBody UserDto user, HttpServletRequest request) throws RuntimeException{
        UserDto userDto = userService.login(user);
        if (userDto == null) {
            return  Result.error("登录失败");
        }else {
            request.getSession().setAttribute("user", userDto.getId());
            request.getSession().setAttribute("name", userDto.getName());
            return Result.success(null,"登录成功");
        }
    }
}
