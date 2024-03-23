package com.bgtb01.bgtb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bgtb01.bgtb.entity.Users;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersMapper extends BaseMapper<Users>{

    @Select("select password from users where username = #{username}")
    public String getPassword(String username);
}
