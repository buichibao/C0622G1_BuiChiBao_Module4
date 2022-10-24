package com.example.student.controller;

import com.example.student.model.Student;
import com.example.student.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private IStudentService iStudentService;

    @GetMapping("")
    public  String listStudent(@PageableDefault(value = 2) Pageable pageable,
                               @RequestParam(value = "nameStudent",defaultValue = "") String nameStudent,
                               Model model){
        model.addAttribute("listStudent",iStudentService.findByNameContaining(pageable,nameStudent));
        return "/student/list";
    }

    @GetMapping("/create")
    public String showFormStudent(Model model){
        model.addAttribute("student",new Student());
        return "/student/create";
    }

    @PostMapping("/create")
    public String saveCreate(@ModelAttribute Student student, RedirectAttributes redirectAttributes){
        iStudentService.save(student);
        redirectAttributes.addFlashAttribute("messCreate","Tao moi thanh cong "+student.getName());
        return "redirect:/student";
    }

    @GetMapping("{id}-delete")
    public String showFormDelete(@PathVariable int id, Model model){
       model.addAttribute("student",iStudentService.findById(id));
       return "/student/delete";
    }

    @PostMapping("/delete")
    public String deleteStudent(@ModelAttribute Student student,RedirectAttributes redirectAttributes){
        iStudentService.delete(student.getId());
        redirectAttributes.addFlashAttribute("messDelete","Xoa thanh cong "+student.getName());
        return "redirect:/student";
    }

}
