package com.bgtb01.bgtb.service;

import com.bgtb01.bgtb.entity.Universities;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xiaozhang
 * @since 2024-03-14
 */
public interface IUniversitiesService extends IService<Universities> {

    List<Universities> getSchoolByProvince(String provinceId);
}
