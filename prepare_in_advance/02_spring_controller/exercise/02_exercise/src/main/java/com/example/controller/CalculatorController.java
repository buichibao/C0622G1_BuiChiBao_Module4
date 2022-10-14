package com.example.controller;

import com.example.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @Autowired
    private ICalculatorService iCalculatorService;
    @GetMapping("/")
    public String calculator(){
        return "/index";
    }

    @GetMapping("/convert")
    public String convert(@RequestParam String opera ,@RequestParam double firstNumber ,@RequestParam double secondNumber,
                          Model model){
        model.addAttribute("result",iCalculatorService.convert(opera,firstNumber,secondNumber));
        return "/index";
    }
}
