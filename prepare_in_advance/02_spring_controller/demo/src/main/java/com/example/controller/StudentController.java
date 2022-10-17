package com.example.controller;

import com.example.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {

    @Autowired
    private IStudentService iStudentService;

    @GetMapping("/")
    public String list(Model model){
        model.addAttribute("studentList",iStudentService.findAll());
        return "/index";
    }

    @GetMapping("/search")
    public String showListSearch(@RequestParam (value = "nameStudent",defaultValue = "") String name,Model model){
      model.addAttribute("studentList",iStudentService.searchByName(name));
      return "/index";
    }
}
