package com.Ritik.Security01.controller;

import com.Ritik.Security01.model.AppUsers;
import com.Ritik.Security01.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userController {

    @Autowired
    private AppUserService service;

    @GetMapping("/greet")
    public static String greet() {
        return "hello Spring Boot Security";
    }

    @GetMapping("/open")
    public static String open() {
        return " 'OPEN' Accessing this resource without logging in";
    }

    @GetMapping("closed")
    public static String closed() {
        return " 'CLOSED' Closed resource cannot access without log in";
    }

    @PostMapping("/register")
    public AppUsers register(@RequestBody AppUsers appUsers) {
        return service.register(appUsers);
    }

    @PostMapping("/login")
    public String login(@RequestBody AppUsers user) {
        System.out.println(user);
        return service.verify(user);
    }

}
