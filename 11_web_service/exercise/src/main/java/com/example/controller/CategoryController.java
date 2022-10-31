package com.example.controller;

import com.example.model.Blog;
import com.example.model.Category;
import com.example.service.IBlogService;
import com.example.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private ICategoryService iCategoryService;

    @Autowired
    private IBlogService iBlogService;

    @GetMapping
    public ResponseEntity<List<Category>> findAllCategory(){
        List<Category> categories = (List<Category>) iCategoryService.findAll();
        if (categories.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Blog>> findCategoryById(@PathVariable Integer id) {
   List<Blog> blogList = iBlogService.findListBlog(id);
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList,HttpStatus.OK);
    }

}
