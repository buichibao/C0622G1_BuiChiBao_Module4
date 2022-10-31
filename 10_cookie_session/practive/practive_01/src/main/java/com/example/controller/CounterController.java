package com.example.controller;

import com.example.model.Counter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("counter")
public class CounterController {

    @ModelAttribute("counter")
    public Counter setUpSession(){
        return new Counter();
    }


    @GetMapping("")
    public  String get1(@ModelAttribute(value = "counter") Counter counter){
        counter.increment();
        return "/home";
    }

}
