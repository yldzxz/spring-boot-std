package com.hkz.controller;

import com.hkz.domain.User;
import com.hkz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

/**
 * Created by huangkz on 2018/5/18.
 */

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String selectUser(){
        return  "redirect:user/list";
    }


    @RequestMapping("list")
    public ModelAndView list(){
        ModelAndView modelAndView = new ModelAndView("user/listUser");
        List<User> list = userService.findAll();
        modelAndView.addObject("users",list);
        return modelAndView;
    }

    @RequestMapping("toAdd")
    public String toAdd(User user){
        return "user/addUser";
    }

    @RequestMapping("add")
    public String add(User user){
        userService.save(user);
        return "redirect:/user/list";
    }

    @RequestMapping("toEdit")
    public String toEdit(Model model,Long id){
        User user = userService.findUserById(id);
        model.addAttribute("user",user);
        return "user/editUser";
    }

    @RequestMapping("edit")
    public String edit(User user){
        userService.save(user);
        return "redirect:/user/list";
    }

    @RequestMapping("delete")
    public String delete(int id){
        userService.deleteById(id);
        return "redirect:/user/list";
    }


}
