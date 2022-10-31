package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class CookieController {

    @GetMapping("")
    public String home(@CookieValue(value = "counter",defaultValue = "0") Long counter, HttpServletResponse response, Model model){
        counter++;
        Cookie cookie = new Cookie("counter",counter.toString());
        cookie.setMaxAge(20);
        response.addCookie(cookie);
        model.addAttribute("cookie",cookie);
        return "/home";
    }
}
