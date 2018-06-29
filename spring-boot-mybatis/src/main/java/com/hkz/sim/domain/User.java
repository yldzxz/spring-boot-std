package com.hkz.sim.domain;

import java.io.Serializable;

/**
 * Created by huangkz on 2018/6/22.
 */
public class User implements Serializable{

    private static final long serialVersionUID = 1L;
    private int id;
    private String username;
    private String password;
    private Sex userSex;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Sex getUserSex() {
        return userSex;
    }

    public void setUserSex(Sex userSex) {
        this.userSex = userSex;
    }

    @Override
    public String toString() {
        return "User{" +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userSex=" + userSex +
                '}';
    }
}
