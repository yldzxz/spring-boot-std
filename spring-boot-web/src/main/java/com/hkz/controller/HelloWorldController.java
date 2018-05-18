package com.hkz.controller;

import com.hkz.dao.UserRepository;
import com.hkz.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by huangkz on 2018/5/18.
 */

@RestController
public class HelloWorldController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("select")
    public User selectUser(){
        User user = userRepository.findByUsername("hkz");
        return  user;
    }

    @RequestMapping("test")
    public User testUser(){
        User user = new User();
        user.setUsername("hkz");
        user.setPassword("kl");
        userRepository.save(user);
        userRepository.findByUsername("hkz");
        return  user;
    }
}
