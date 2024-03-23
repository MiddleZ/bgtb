package com.bgtb01.bgtb.controller;

import com.bgtb01.bgtb.common.vo.Result;
import com.bgtb01.bgtb.entity.Users;
import com.bgtb01.bgtb.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xiaozhang
 * @since 2024-03-14
 */
@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private IUsersService usersService;

    @GetMapping("/all")
    public Result<List<Users>> getAllUsers(){
        List<Users> list = usersService.list();
        return Result.success(list);
    }


}
