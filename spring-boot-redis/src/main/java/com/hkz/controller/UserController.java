package com.hkz.controller;

import com.hkz.domain.User;
import com.hkz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by huangkz on 2018/5/21.
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("select")
    public User select(int id){
        System.out.println("id:"+id);
        User user = userService.findUserById(id);
        return user;
    }

    @RequestMapping("add")
    public User add(){
        User user = new User();
        user.setUsername("hhh");
        user.setPassword("hkllll");
        return userService.addUser(user);
    }

    @RequestMapping("delete")
    public int  delete(int id){

        return userService.deleteUser(id);
    }

}
