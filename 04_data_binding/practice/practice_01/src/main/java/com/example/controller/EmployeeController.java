package com.example.controller;

import com.example.model.Employee;
import com.example.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")

public class EmployeeController {

    @Autowired
    private IEmployeeService iEmployeeService;

    @GetMapping("/")
    public String list(Model model){
        model.addAttribute("listEmployee",iEmployeeService.findAll());
        return "/list";
    }
    @GetMapping("/showForm")
    public  String showForm(Model model){
        model.addAttribute("employee",new Employee());
        return "/index";
    }
}
