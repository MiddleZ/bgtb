package com.bgtb01.bgtb.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bgtb01.bgtb.common.vo.Result;
import com.bgtb01.bgtb.entity.Forumtitles;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository//代表持久层
public interface ForumtitlesMapper extends BaseMapper<Forumtitles> {

    @Select("SELECT u.`UniversityID` FROM universities u\n" +
            "WHERE u.`UniversityName`=#{UniversityName};")
    public Integer getFid(@Param("UniversityName")String UniversityName);

    @Select("SELECT * FROM forumtitles f\n" +
            "WHERE f.`UniversityID` = #{UniversityID};")
    public Map<String,Object> getFByid(@Param("UniversityID")String UniversityID);

}
