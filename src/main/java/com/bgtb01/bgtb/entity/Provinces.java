package com.bgtb01.bgtb.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author xiaozhang
 * @since 2024-03-14
 */
public class Provinces implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ProvinceID", type = IdType.AUTO)
    private Integer provinceID;

    private String provinceName;

    public Integer getProvinceID() {
        return provinceID;
    }

    public void setProvinceID(Integer provinceID) {
        this.provinceID = provinceID;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    @Override
    public String toString() {
        return "Provinces{" +
            "provinceID = " + provinceID +
            ", provinceName = " + provinceName +
        "}";
    }
}
