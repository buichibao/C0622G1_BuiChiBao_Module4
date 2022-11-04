package com.example.controller;

import com.example.model.Student;
import com.example.service.IClassRoomService;
import com.example.service.ICourseService;
import com.example.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Date;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private IStudentService iStudentService;

    @Autowired
    private IClassRoomService iClassRoomService;

    @Autowired
    private ICourseService iCourseService;

    @GetMapping("")
    public String list(@PageableDefault(value = 3)Pageable pageable,
                       @RequestParam(value = "nameStudent",defaultValue = "") String nameStudent,
                       Model model){
        model.addAttribute("nameStudent",nameStudent);
        model.addAttribute("listStudent",iStudentService.findByNameContaining(pageable,nameStudent));
        return "/list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model){
        model.addAttribute("student",new Student());
        model.addAttribute("classRoomList",iClassRoomService.findAll());
        model.addAttribute("courseList",iCourseService.findAll());
        return "/create";
    }

    @PostMapping("/create")
    public String saveStudent(@ModelAttribute Student student,RedirectAttributes redirectAttributes){
        student.getAccount().setDateCreate(new Date(System.currentTimeMillis()));
        iStudentService.save(student);
        return "redirect:/student";
    }

    @GetMapping("/{id}-update")
    public String showFormUpdate(@PathVariable int id, Model model){
        model.addAttribute("student",iStudentService.findById(id));
        model.addAttribute("classRoomList",iClassRoomService.findAll());
        model.addAttribute("courseList",iCourseService.findAll());
        return "/update";
    }

    @PostMapping("/update")
    public String saveStudentUpdate(@ModelAttribute Student student,RedirectAttributes redirectAttributes){
        iStudentService.save(student);
        return "redirect:/student";
    }

    @GetMapping("/{id}-delete")
    public  String deleteStudent(@PathVariable int id,Model model){
        model.addAttribute("student",iStudentService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute Student student,RedirectAttributes redirectAttributes){
        iStudentService.delete(student.getId());
        return "redirect:/student";
    }

}
