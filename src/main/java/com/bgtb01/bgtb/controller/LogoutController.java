package com.bgtb01.bgtb.controller;

import com.bgtb01.bgtb.common.vo.Result;
import com.bgtb01.bgtb.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class LogoutController {
    @Autowired
    private IUsersService usersService;


}
