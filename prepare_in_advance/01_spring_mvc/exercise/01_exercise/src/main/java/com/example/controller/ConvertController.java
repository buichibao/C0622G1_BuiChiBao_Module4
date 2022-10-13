package com.example.controller;

import com.example.service.IConvertService;
import com.example.service.impl.ConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertController {

    @Autowired
    private IConvertService iConvertService;

    @GetMapping("/")
    public String form(){
        return "/index";
    }

    @GetMapping("/change")
    public String change(@RequestParam double usd, Model model){
        model.addAttribute("vnd",iConvertService.convert(usd));
        return "/index";
    }
}
