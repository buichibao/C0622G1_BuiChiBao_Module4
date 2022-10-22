package com.example.blog.controller;

import com.example.blog.model.Category;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("")
    public String listCategory(@PageableDefault(value = 10) Pageable pageable,
                               @RequestParam(value = "nameCategory",defaultValue = "") String nameCategory,
                               Model model){
        model.addAttribute("listCategory",iCategoryService.findByNameCategoryContaining(pageable,nameCategory));
        return "/category/list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model){
        model.addAttribute("category",new Category());
        return "/category/create";
    }

    @PostMapping("/create")
    public String saveCreate(@ModelAttribute Category category, RedirectAttributes redirectAttributes){
        iCategoryService.save(category);
        redirectAttributes.addFlashAttribute("messCreate","Create thanh cong "+category.getNameCategory());
        return "redirect:/category";
    }

    @GetMapping("/{id}-delete")
    public String showFormDelete(@PathVariable int id,Model model){
        model.addAttribute("category",iCategoryService.findById(id));
        return "/category/delete";
    }

    @PostMapping("/delete")
    public String deleteCategory(@ModelAttribute Category category,RedirectAttributes redirectAttributes){
        iCategoryService.delete(category.getId());
        redirectAttributes.addFlashAttribute("messDelete","Xoa thanh cong "+category.getNameCategory());
        return "redirect:/category";
    }

    @GetMapping("/{id}-update")
    public String showFormUpdate(@PathVariable int id, Model model){
        model.addAttribute("category",iCategoryService.findById(id));
        return "/category/update";
    }


    @PostMapping("/update")
    public String saveCreateUpdate(@ModelAttribute Category category, RedirectAttributes redirectAttributes){
        iCategoryService.save(category);
        redirectAttributes.addFlashAttribute("messCreate","Update thanh cong "+category.getNameCategory());
        return "redirect:/category";
    }

    @GetMapping("/{id}-view")
    public String showFormView(@PathVariable int id, Model model){
        model.addAttribute("category",iCategoryService.findById(id));
        return "/category/view";
    }


}
