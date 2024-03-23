package com.bgtb01.bgtb.service;

import com.bgtb01.bgtb.entity.Users;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xiaozhang
 * @since 2024-03-14
 */
public interface IUsersService extends IService<Users> {

    Map<String, Object> login(Users users);

    Map<String, Object> getUserInfo(String token);

    void logout(String token);
}















