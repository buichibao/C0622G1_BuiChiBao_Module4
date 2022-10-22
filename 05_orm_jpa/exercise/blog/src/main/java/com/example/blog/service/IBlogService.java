package com.example.blog.service;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService {

    Page<Blog> findAll(Pageable pageable);

    Blog findById(int id);

    void remove(int id);

    void save(Blog blog);


    Page<Blog> findByTitleContaining(Pageable pageable, String title);
}
