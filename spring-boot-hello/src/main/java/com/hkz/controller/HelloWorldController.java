package com.hkz.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by huangkz on 2018/5/17.
 */
@RestController
public class HelloWorldController {

    @RequestMapping("hello")
    public String hello(){
        return "spring boot hello world ";
    }

}
