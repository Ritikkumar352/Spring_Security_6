package com.Ritik.Security01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class home {

    @RequestMapping("/")
    public static String about(){
        return "homeeee";
    }


}
