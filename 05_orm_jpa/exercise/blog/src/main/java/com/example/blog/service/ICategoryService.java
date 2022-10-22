package com.example.blog.service;

import com.example.blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICategoryService {
    Page<Category> findByNameCategoryContaining(Pageable pageable, String name);

    void delete(int id);

    void save(Category category);


    Category findById(int id);
}
