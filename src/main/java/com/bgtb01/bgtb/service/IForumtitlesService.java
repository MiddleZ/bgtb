package com.bgtb01.bgtb.service;

import com.bgtb01.bgtb.entity.Forumtitles;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xiaozhang
 * @since 2024-03-14
 */
public interface IForumtitlesService extends IService<Forumtitles> {

    int getFpu(String provinceName, String universityName);
}
