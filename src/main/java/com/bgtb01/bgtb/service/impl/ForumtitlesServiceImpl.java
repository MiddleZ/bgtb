package com.bgtb01.bgtb.service.impl;

import com.bgtb01.bgtb.entity.Forumtitles;
import com.bgtb01.bgtb.mapper.ForumtitlesMapper;
import com.bgtb01.bgtb.service.IForumtitlesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xiaozhang
 * @since 2024-03-14
 */
@Service
public class ForumtitlesServiceImpl extends ServiceImpl<ForumtitlesMapper, Forumtitles> implements IForumtitlesService {


    @Override
    public int getFpu(String provinceName, String universityName) {
        return 0;
    }
}
