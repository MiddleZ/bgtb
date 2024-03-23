package com.bgtb01.bgtb.controller;

import com.bgtb01.bgtb.common.vo.Result;
import com.bgtb01.bgtb.mapper.UsersMapper;
import com.bgtb01.bgtb.entity.Users;
import com.bgtb01.bgtb.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class LoginController {
    @Autowired
    private IUsersService usersService;

    @PostMapping("/login")
    public Result<Map<String, Object>> Login(@RequestBody Users users) {
        Map<String,Object> data = usersService.login(users);
        if(data != null) {
            return Result.success(data);
        }
        return Result.fail(20002,"用户名或密码错误");
    }
    @GetMapping("/info")
    public Result<Map<String,Object>> getUserInfo(@RequestParam("token") String token){
        //根据token获取用户信息.redis
        Map<String,Object> data = usersService.getUserInfo(token);
        if(data != null){
            return Result.success(data);
        }
        return Result.fail(20003,"登陆信息无效");
    }

    @PostMapping("/logout")
    public Result<?> logout(@RequestHeader("X-Token") String token){
        usersService.logout(token);
        return Result.success();
    }
}
















