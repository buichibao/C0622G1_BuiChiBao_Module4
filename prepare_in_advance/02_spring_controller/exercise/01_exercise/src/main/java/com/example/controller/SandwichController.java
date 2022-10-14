package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {

    @GetMapping("/")
    public String home(){
        return "/index";
    }

    @GetMapping("/save")
    public String saveChoose(@RequestParam (value = "choose",defaultValue = "Please choose!") String[] strings , Model model){
        model.addAttribute("result",strings);
        return "/index";
    }
}
