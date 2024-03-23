package com.bgtb01.bgtb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bgtb01.bgtb.entity.Universities;
import com.bgtb01.bgtb.mapper.UniversitiesMapper;
import com.bgtb01.bgtb.service.IUniversitiesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xiaozhang
 * @since 2024-03-14
 */
@Service
public class UniversitiesServiceImpl extends ServiceImpl<UniversitiesMapper, Universities> implements IUniversitiesService {

    @Autowired
    private UniversitiesMapper universitiesMapper;
    @Override
    public List<Universities> getSchoolByProvince(String provinceId) {
        QueryWrapper<Universities> wrapper = new QueryWrapper<>();
        wrapper.eq("ProvinceId",provinceId);
        return universitiesMapper.selectList(wrapper);
    }
}
