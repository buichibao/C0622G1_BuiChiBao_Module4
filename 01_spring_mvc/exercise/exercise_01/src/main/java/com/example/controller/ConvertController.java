package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConvertController {
    @GetMapping("")
    public String home() {
        return "/index";
    }

    @GetMapping("/convert")
    public ModelAndView change(@RequestParam double usd){
        return new ModelAndView("/index","result",usd*23000);
    }
}
