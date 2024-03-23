package com.bgtb01.bgtb.pojo_ban;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Provinces {
        @TableId(type = IdType.AUTO)
        private Integer ProvinceID;
        private String ProvinceName;
}
