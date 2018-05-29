package com.hkz.controller;

import com.hkz.domain.UserEhcache;
import com.hkz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by huangkz on 2018/5/29.
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("select")
    public UserEhcache select(int id){

        UserEhcache userEhcache =userService.findUserById(id);

        return userEhcache;
    }

    @RequestMapping("update")
    public UserEhcache update(UserEhcache user){

        UserEhcache userEhcache =userService.updateUser(user);

        return userEhcache;
    }

    @RequestMapping("delete")
    public boolean delete(int id){
        return userService.deleteUserById(id);
    }


}
