package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Date;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private IBlogService iBlogService;

//    phân trang và sắp xếp
    @GetMapping("")
    // title 1 là tên biến bên list gửi qua title 2 là biến tương tác với phương thức
    public String listBlog(@PageableDefault(value = 1) Pageable pageable,
                           @RequestParam(value = "title",defaultValue = "") String title,
                           Model model){
        model.addAttribute("blogList",iBlogService.findByTitleContaining(pageable,title));
        return "/blog/list";
    }

    @GetMapping("/{id}-delete")
    public String showFormDelete(@PathVariable int id, Model model){
        model.addAttribute("blog",iBlogService.findById(id));
        return "/blog/delete";
    }

    @PostMapping("/delete")
    public String deleteBolg(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes){
        iBlogService.remove(blog.getId());
        redirectAttributes.addFlashAttribute("messDelete","Xoa thanh cong");
        return "redirect:/blog";
    }

    @GetMapping("/{id}-update")
    public String showFormUpdate(@PathVariable int id, Model model){
        model.addAttribute("blog",iBlogService.findById(id));
        return "/blog/update";
    }

    @PostMapping("/update")
    public String updateBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes){
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("messUpdate","update thanh cong");
        return "redirect:/blog";
    }

    @GetMapping("/{id}-view")
    public String showFormViews(@PathVariable int id, Model model){
        model.addAttribute("blog",iBlogService.findById(id));
        return "/blog/view";
    }

    @GetMapping("/create")
    public  String showForm(Model model){
        model.addAttribute("blog",new Blog());
        return "/blog/create";
    }

    @PostMapping("/create")
    public String saveBlog(@ModelAttribute Blog blog,RedirectAttributes redirectAttributes){
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("messCreate","create thanh cong "+blog.getTitle());
        return "redirect:/blog";
    }
}
