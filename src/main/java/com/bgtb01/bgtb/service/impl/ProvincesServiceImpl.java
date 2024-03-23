package com.bgtb01.bgtb.service.impl;

import com.bgtb01.bgtb.entity.Provinces;
import com.bgtb01.bgtb.mapper.ProvincesMapper;
import com.bgtb01.bgtb.service.IProvincesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ProvincesServiceImpl extends ServiceImpl<ProvincesMapper, Provinces> implements IProvincesService {

    @Autowired
    private ProvincesMapper provincesMapper;
    @Override
    public List<Provinces> getProvinces() {
        return provincesMapper.selectList(null);
    }
}
