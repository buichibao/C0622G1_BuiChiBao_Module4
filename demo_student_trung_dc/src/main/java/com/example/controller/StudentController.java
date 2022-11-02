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
@RequestMapping()
public class StudentController {

    @Autowired
    private IStudentService iStudentService;

    @GetMapping("/student")
    public String list(@PageableDefault(value = 3)Pageable pageable,
                       @RequestParam(value = "nameStudent",defaultValue = "") String nameStudent,
                       Model model){
        model.addAttribute("nameStudent",nameStudent);
        model.addAttribute("listStudent",iStudentService.findByNameContaining(pageable,nameStudent));
        return "/list";
    }

}
