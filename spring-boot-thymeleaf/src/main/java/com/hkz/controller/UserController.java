package com.hkz.controller;

import com.hkz.dao.UserRepository;
import com.hkz.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangkz on 2018/5/18.
 */

@RestController("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/")
    public User selectUser(){
        User user = userRepository.findByUsername("hkz");
        return  user;
    }


    @RequestMapping("/list")
    public String listUser(Model model){
        List<User> list = userRepository.findAll();
        model.addAttribute("users",list);
        return "/user/list";
    }

}
