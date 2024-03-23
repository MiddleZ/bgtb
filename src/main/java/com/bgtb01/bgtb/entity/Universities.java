package com.bgtb01.bgtb.entity;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author xiaozhang
 * @since 2024-03-14
 */
public class Universities implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer universityID;

    private String universityName;

    private Integer provinceID;

    public Integer getUniversityID() {
        return universityID;
    }

    public void setUniversityID(Integer universityID) {
        this.universityID = universityID;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public Integer getProvinceID() {
        return provinceID;
    }

    public void setProvinceID(Integer provinceID) {
        this.provinceID = provinceID;
    }

    @Override
    public String toString() {
        return "Universities{" +
            "universityID = " + universityID +
            ", universityName = " + universityName +
            ", provinceID = " + provinceID +
        "}";
    }
}
