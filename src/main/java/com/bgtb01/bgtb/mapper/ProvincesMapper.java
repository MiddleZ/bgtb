package com.bgtb01.bgtb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bgtb01.bgtb.entity.Provinces;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProvincesMapper extends BaseMapper<Provinces> {

    @Select("SELECT * FROM Provinces;")
    public List<Provinces> selectList();
}
