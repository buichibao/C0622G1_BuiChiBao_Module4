package com.example.service;

import com.example.model.Blog;


import java.util.List;
import java.util.Optional;

public interface IBlogService {
    List<Blog>  findAll();

    Optional<Blog> findById(Integer id);

    List<Blog> findListBlog(Integer id);
}
