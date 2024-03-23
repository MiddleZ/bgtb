package com.bgtb01.bgtb.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bgtb01.bgtb.common.vo.Result;
import com.bgtb01.bgtb.entity.Forumtitles;
import com.bgtb01.bgtb.mapper.ForumtitlesMapper;
import com.bgtb01.bgtb.service.IForumtitlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class ForumtitlesController {

    @Autowired
    private IForumtitlesService  forumtitlesService;
    @Autowired
    private ForumtitlesMapper forumtitlesMapper;

    @GetMapping("/comment")
    public Result<Map<String,Object>>  shouCommentPage(@RequestParam(value = "Province" ,required = false) String ProvinceName,
                                                       @RequestParam(value = "University",required = false) String UniversityName,
                                                       @RequestParam(value = "pageNo") Long pageNo,
                                                       @RequestParam(value = "pageSize") Long pageSize){
        System.out.println(UniversityName);
        Integer universityId = forumtitlesMapper.getFid(UniversityName);
        if(universityId == null) System.out.println("未能查出");

        System.out.println(universityId);
        LambdaQueryWrapper<Forumtitles> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(StringUtils.hasLength(String.valueOf(universityId)),Forumtitles::getUniversityID,universityId);
        //wrapper.eq(Forumtitles::getUniversityID,universityId);
        Page<Forumtitles> page = new Page<>(pageNo,pageSize);//分页
        forumtitlesService.page(page,wrapper);//分页查询
        Map<String,Object> data = new HashMap<>();//返回数据

        data.put("total",page.getTotal());
        data.put("rows",page.getRecords());

//        System.out.println("Before returning Result: " + data); // 添加这一行
//        Result<Map<String,Object>> result = Result.success(data);
//        System.out.println("After returning Result: " + result); // 添加这一行


        return  Result.success(data);

    }

    @GetMapping("/comments")
    public Result<Map<String,Object>> showPages(@RequestParam(value = "UniversityID")String UniversityID,
                                                @RequestParam(value = "pageNo")Long pageNo,
                                                @RequestParam(value = "pageSize")Long pageSize){

        LambdaQueryWrapper<Forumtitles> wrapper = new LambdaQueryWrapper<>();
        //Map<String, Object> data = forumtitlesMapper.getFByid(UniversityID);
        wrapper.eq(Forumtitles::getUniversityID,UniversityID);
       // wrapper.select(Forumtitles::getUniversityID,Forumtitles::getTitleContent,Forumtitles::getPublishTime,Forumtitles::getCategory,Forumtitles::)
        Page<Forumtitles> page = new Page<>(pageNo,pageSize);
        forumtitlesService.page(page,wrapper);
        Map<String,Object> data = new HashMap<>();

        data.put("total",page.getTotal());
        data.put("rows",page.getRecords());

        return Result.success(data);

    }




}
