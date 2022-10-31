package com.example.controller;

import com.example.model.Student;
import com.example.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class StudentController {

    @Autowired
    private IStudentService iStudentService;

    @GetMapping("/")
    public String list(@PageableDefault(value = 3)Pageable pageable,
                       @RequestParam(value = "nameStudent",defaultValue = "") String nameStudent,
                       Model model){
        model.addAttribute("nameStudent",nameStudent);
        model.addAttribute("listStudent",iStudentService.findByNameContaining(pageable,nameStudent));
        return "/list";
    }

    @GetMapping("/{id}-update")
    public String showFormUpdate(@PathVariable int id,Model model){
        model.addAttribute("student",iStudentService.findById(id));
        return "/update";
    }

    @PostMapping("/update")
    public String showSaveUpdate(@ModelAttribute Student student, RedirectAttributes redirectAttributes){
        iStudentService.save(student);
        return "redirect:/";
    }
}
