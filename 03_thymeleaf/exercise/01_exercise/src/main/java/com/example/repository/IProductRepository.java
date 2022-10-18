package com.example.repository;

import com.example.model.Product;

import java.util.List;

public interface IProductRepository {

    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    void delete(int id);

    List<Product> findByName(String name);
}
