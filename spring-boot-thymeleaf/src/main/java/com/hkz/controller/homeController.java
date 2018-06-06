package com.hkz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by huangkz on 2018/6/6.
 */
@Controller
@RequestMapping
public class homeController {

    @RequestMapping("index")
    public String index(){
        return "/index";
    }


}
