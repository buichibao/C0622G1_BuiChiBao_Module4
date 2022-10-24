package com.example.controller;

import com.example.dto.UserDTO;
import com.example.model.User;
import com.example.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

    @Autowired
    private IUserService iUserService;

    @GetMapping("/")
    public String list(){
        return "/list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model){
        model.addAttribute("userDTO",new UserDTO());
        return "/create";
    }

    @PostMapping("/create")
    public String saveUser(@Validated @ModelAttribute UserDTO userDTO,
                           BindingResult bindingResult ,
                           RedirectAttributes redirectAttributes,
                           Model model){
        new UserDTO().validate(userDTO,bindingResult);

        if(bindingResult.hasFieldErrors()){
            //không cần gửi đối tượng mới

            return "/create";
        }
        else {
            User user = new User();
            BeanUtils.copyProperties(userDTO,user);
            iUserService.save(user);
            redirectAttributes.addFlashAttribute("messCreate","Tao moi thanh cong "+user.getLastName());
            return "redirect:/";
        }
    }
}
