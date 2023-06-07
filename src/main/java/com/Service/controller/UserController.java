package com.Service.controller;

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

@RestController
@RequestMapping(path = "/user", produces = "application/json;charset=UTF-8")
@Slf4j
@Api(tags = "用户登录信息表")
public class UserController {

    private final ModelMapper mapper;
    @Autowired
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
        ModelMapper mapper=new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        this.mapper = mapper;
    }
    @ApiOperation(value = "注册新用户",notes = "权限，无")
    @RequestMapping(path = "/register",method = RequestMethod.POST)
    public boolean addUser(@RequestBody UserDto userDto) throws RuntimeException {
        return userService.addUser(userDto);
    }


    @ApiOperation(value = "更改密码",notes = "权限，无")
    @RequestMapping(path = "/update",method = RequestMethod.POST)
    public boolean updateUser(@RequestBody UserDto userDto) throws RuntimeException{
        return userService.updateUser(userDto);
    }

    @ApiOperation(value = "注销用户",notes = "权限，无")
    @RequestMapping(path = "/logout",method = RequestMethod.POST)
    public boolean removeUser(@RequestBody UserDto userDto) throws RuntimeException{
        return userService.removeUser(userDto);
    }
    @ApiOperation(value = "用户登录",notes = "权限，无")
    @RequestMapping(path = "/login",method = RequestMethod.POST)
    public UserDto login(@RequestBody String username,String password) throws RuntimeException{
        return userService.login(username,password);
    }
}
