package com.hkz.controller;

import com.hkz.dao.UserRepository;
import com.hkz.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangkz on 2018/5/18.
 */

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/")
    public User selectUser(){
        User user = userRepository.findByUsername("hkz");
        return  user;
    }


    @RequestMapping("list")
    public ModelAndView list(){
        ModelAndView modelAndView = new ModelAndView("user/listUser");
        List<User> list = userRepository.findAll();
        modelAndView.addObject("users",list);
        return modelAndView;
    }

    @RequestMapping("add")
    public String add(){
        return "user/addUser";
    }

    @RequestMapping("addUser")
    public ModelAndView addUser(User user){
        ModelAndView modelAndView = new ModelAndView("user/listUser");
        userRepository.save(user);
        List<User> list = userRepository.findAll();
        modelAndView.addObject("users",list);
        return modelAndView;
    }
}
