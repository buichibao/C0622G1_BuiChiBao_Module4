package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String showHomePage(){
        return "/home";
    }

    @GetMapping("/login")
    public String showLoginPage(){
        return "/myLogin";
    }

}
