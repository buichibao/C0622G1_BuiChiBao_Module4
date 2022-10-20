package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BlogController {

    @Autowired
    private IBlogService iBlogService;

    @GetMapping("/")
    public String listBlog(Model model){
        model.addAttribute("blogList",iBlogService.findAll());
        return "/list";
    }

    @GetMapping("/{id}-delete")
    public String showFormDelete(@PathVariable int id, Model model){
        model.addAttribute("blog",iBlogService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String deleteBolg(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes){
        iBlogService.remove(blog.getId());
        redirectAttributes.addFlashAttribute("messDelete","Xoa thanh cong");
        return "redirect:/";
    }

    @GetMapping("/{id}-update")
    public String showFormUpdate(@PathVariable int id, Model model){
        model.addAttribute("blog",iBlogService.findById(id));
        return "/update";
    }

    @PostMapping("/update")
    public String updateBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes){
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("messUpdate","update thanh cong");
        return "redirect:/";
    }
}
