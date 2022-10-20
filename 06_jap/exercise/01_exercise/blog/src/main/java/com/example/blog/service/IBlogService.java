package com.example.blog.service;

import com.example.blog.model.Blog;

import java.util.List;

public interface IBlogService {

    List<Blog> findAll();

    Blog findById(int id);

    void remove(int id);

    void save(Blog blog);

    void update(Blog blog);
}
