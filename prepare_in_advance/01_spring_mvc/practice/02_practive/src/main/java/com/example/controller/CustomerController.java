package com.example.controller;

import com.example.model.Customer;
import com.example.service.ICustomerService;
import com.example.service.impl.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private ICustomerService iCustomerService = new CustomerService();

    @GetMapping("/customer")
    public String showList(Model model){
        List<Customer> customerList = iCustomerService.findAllCustomer();
        model.addAttribute("customerList",customerList);
      return "/list";
    }

    @GetMapping("/create")
    public String showForm(Model model){
        model.addAttribute("customer",new Customer());
        return "/create";
    }

    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes){
        iCustomerService.save(customer.getId(),customer);
        redirectAttributes.addFlashAttribute("mess","successful new create "+customer.getName());
        return "redirect:/customer";
    }

}
