package com.bgtb01.bgtb.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.bgtb01.bgtb.common.vo.Result;
import com.bgtb01.bgtb.entity.Users;
import com.bgtb01.bgtb.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/Umanager")
public class UserManagerController {
    @Autowired
    IUsersService usersService;

    @GetMapping("/search")
    public Result<Users> searchUser(@RequestParam(value = "userid") Integer userid){
        LambdaQueryWrapper<Users> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Users::getUserid,userid);
        Users byId = usersService.getOne(wrapper);
        return Result.success(byId);
    }
}
