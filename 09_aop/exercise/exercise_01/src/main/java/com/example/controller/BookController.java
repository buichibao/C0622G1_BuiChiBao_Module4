package com.example.controller;

import com.example.exception.EnoughBookException;
import com.example.exception.OutOfBookException;
import com.example.model.Book;
import com.example.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BookController {

    @Autowired
    private IBookService iBookService;

    @GetMapping("/")
    public  String list(Model model){
        model.addAttribute("bookList",iBookService.findAll());
        return "/list";
    }

    @GetMapping("/{id}-view")
    public String showFormView(@PathVariable int id,Model model){
        model.addAttribute("book",iBookService.findById(id));
        return "/view";
    }

    @GetMapping("/{id}-borrow")
    public String borrowBook(@PathVariable int id,Model model) throws OutOfBookException {
        Book book = iBookService.findById(id);
        if(book.getAmount()==0){
           throw new OutOfBookException();
        }else {
            book.setAmount(book.getAmount()-1);
            iBookService.save(book);
            return "redirect:/";
        }
    }
    @ExceptionHandler(OutOfBookException.class)
    public String OutOfBook(){
        return "/outOfBook";
    }

    @GetMapping("/{id}-pay")
    public String payBook(@PathVariable int id,Model model) throws EnoughBookException {
        Book book = iBookService.findById(id);

        if(book.getAmount()== book.getStartAmount()){
            throw  new EnoughBookException();
        }else {
            book.setAmount(book.getAmount()+1);
            iBookService.save(book);
            return "redirect:/";

        }
    }

    @ExceptionHandler(EnoughBookException.class)
    public String Enough(){
        return "/enoughBook";
    }
}
