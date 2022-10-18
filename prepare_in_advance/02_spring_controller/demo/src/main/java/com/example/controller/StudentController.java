package com.example.controller;

import com.example.model.Student;
import com.example.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping("/create")
    public String showForm(Model model){
        model.addAttribute("student",new Student());
        model.addAttribute("languagesList",iStudentService.findAllLanguage());
        return "/create";
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute Student student, RedirectAttributes redirectAttributes){
        iStudentService.save(student);
        redirectAttributes.addFlashAttribute("mess","Creat "+student.getName()+" ok");
        return "redirect:/";
    }

}
