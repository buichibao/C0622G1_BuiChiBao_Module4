package com.example.controller;

import com.example.dto.CustomerDto;
import com.example.model.customer.Customer;
import com.example.service.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService iCustomerService;

    @GetMapping("/list")
    public String showList(Model model){
        model.addAttribute("listCustomer",iCustomerService.findAll());
        return "/customer/list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model){
        model.addAttribute("customerDto",new CustomerDto());
        return "/customer/create";
    }


    @PostMapping("/create")
    public String saveSong(@Validated @ModelAttribute CustomerDto customerDto,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes){
        if(bindingResult.hasFieldErrors()){
            return "/customer/create";
        }else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto,customer);
            iCustomerService.save(customer);
            redirectAttributes.addFlashAttribute("messCreate","Tao moi thanh cong"+customer.getName());
            return "redirect:/customer/list";
        }

    }

}
