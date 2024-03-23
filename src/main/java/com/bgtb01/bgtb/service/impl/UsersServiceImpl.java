package com.bgtb01.bgtb.service.impl;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.bgtb01.bgtb.entity.Users;
import com.bgtb01.bgtb.mapper.UsersMapper;
import com.bgtb01.bgtb.service.IUsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xiaozhang
 * @since 2024-03-14
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {
    @Autowired// 自动注入RedisTemplate对象
    private RedisTemplate<String,Object> redisTemplate;
    @Override// 重写IUsersService接口的login方法
    public Map<String, Object> login(Users users) {
        // 创建一个LambdaQueryWrapper对象，用于构建查询条件
        LambdaQueryWrapper<Users> wrapper = new LambdaQueryWrapper<>();
        // 添加用户名和密码的查询条件
        wrapper.eq(Users::getUsername, users.getUsername());
        wrapper.eq(Users::getPassword, users.getPassword());
        // 使用baseMapper执行查询，返回一个用户对象
        Users loginUser = this.baseMapper.selectOne(wrapper);
        //结果不为空，则生成token，并将信息存入redis
        if(loginUser != null){
            // 生成一个UUID作为token的key
            String key = "user:"+ UUID.randomUUID();
            // 清除用户密码信息
            loginUser.setPassword(null);
            // 将用户信息存入Redis，设置过期时间为30分钟
            redisTemplate.opsForValue().set(key,loginUser,30, TimeUnit.MINUTES);
            // 创建一个Map对象，用于返回数据
            Map<String,Object> data = new HashMap<>();
            // 将token添加到返回数据中
            data.put("token",key);
            // 返回数据
            return data;
        }
        // 如果查询结果为空，说明登录失败，返回null
        return null;
    }
    @Override// 重写IUsersService接口的getUserInfo方法
    public Map<String,Object> getUserInfo(String token){
        // 从Redis中获取用户信息，opsForValue()用于操作字符串类型的数据
        Object obj = redisTemplate.opsForValue().get(token);
        // 如果获取的结果不为空
        if(obj != null){
            // 将获取的结果转换为Users对象
            Users loginUser = JSON.parseObject(JSON.toJSONString(obj),Users.class);
            // 创建一个Map对象，用于返回数据
            Map<String,Object> data = new HashMap<>();
            // 将用户信息添加到返回数据中
            data.put("userInfo",obj);
            // 返回数据
            return data;
        }
        // 如果获取的结果为空，说明token无效，返回null
        return null;
    }


    @Override
    public void logout(String token) {
        redisTemplate.delete(token);
    }
    // 从Redis中删除token
}
















