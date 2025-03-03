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
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer userid;

    private String username;

    private String password;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Users{" +
            "userid = " + userid +
            ", username = " + username +
            ", password = " + password +
        "}";
    }
}
