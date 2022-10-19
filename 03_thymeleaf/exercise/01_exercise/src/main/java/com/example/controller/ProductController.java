package com.example.controller;

import com.example.model.Product;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/product")
public class ProductController {


    @Autowired
    public IProductService iProductService;

    @GetMapping("")
    public String list(Model model){
        model.addAttribute("listProduct",iProductService.findAll());
        model.addAttribute("notification","Empty list");
        return "/list";
    }

    @GetMapping("/{id}-delete")
    public String showFormDelete(@PathVariable int id,Model model){
        model.addAttribute("product",iProductService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String deleteProdcut(@ModelAttribute Product product, RedirectAttributes redirectAttributes){
        iProductService.delete(product.getId());
         redirectAttributes.addFlashAttribute("mess","successful delete");
         return  "redirect:/product";
    }


    @GetMapping("/{id}-view")
    public String showFormView(@PathVariable int id,Model model){
        model.addAttribute("product",iProductService.findById(id));
        return "/view";
    }

    @GetMapping("/search")
    public String listSearch(@RequestParam (value = "name",defaultValue = "") String name , Model model){
        model.addAttribute("listProduct",iProductService.findByName(name));
        return "/list";
    }
    @GetMapping("/create")
    public String showFormCreate(Model model){
        model.addAttribute("product",new Product());
        return "/create";
    }

    @PostMapping("/create")
    public String saveCreate(@ModelAttribute Product product,RedirectAttributes redirectAttributes){
        iProductService.save(product);
        redirectAttributes.addFlashAttribute("messCreate","successful create");
        return "redirect:/product";
    }

    @GetMapping("{id}-update")
    public ModelAndView showFormUpdate(@PathVariable int id){
        return new ModelAndView("/update","product",iProductService.findById(id));
    }

    @PostMapping("/update")
    public String saveUpdate(@ModelAttribute Product product,RedirectAttributes redirectAttributes){
        iProductService.update(product);
        redirectAttributes.addFlashAttribute("messUpdate","successful update");
        return "redirect:/product";
    }
}
