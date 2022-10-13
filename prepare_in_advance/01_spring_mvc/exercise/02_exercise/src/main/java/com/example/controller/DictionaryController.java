package com.example.controller;

import com.example.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/dictionary")
public class DictionaryController {

    @Autowired
    private IDictionaryService iDictionaryService;

    @GetMapping("")
    public String index(){
        return "/index";
    }

    @GetMapping("/change")
    public ModelAndView translate(@RequestParam String eng){
        return new ModelAndView("/index","result",iDictionaryService.change(eng));
    }

}
