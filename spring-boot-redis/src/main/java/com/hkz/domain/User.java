package com.hkz.domain;

import java.io.Serializable;

/**
 * Created by huangkz on 2018/5/18.
 */

public class User implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer id;

    private String username;


    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
