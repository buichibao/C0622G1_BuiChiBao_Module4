package com.example.repository.impl;

import com.example.model.Product;
import com.example.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class ProductRepository implements IProductRepository {

    private static Map<Integer,Product> productList = new HashMap<>();

    static {
        productList.put(1,new Product(1,"Bim bim",10,"good","Osi"));
        productList.put(2,new Product(2,"Pen",10,"good","Gucci"));
        productList.put(3,new Product(3,"Durex",100,"thin","Durex"));
    }

    @Override
    public List<Product> findAll() {
        List<Product> productList1 = new ArrayList<>();
        for (Product product:productList.values()) {
            productList1.add(product);
        }
        return productList1;
    }

    @Override
    public void save(Product product) {
        productList.put(product.getId(),product);
    }

    @Override
    public Product findById(int id) {
        for (Product product:productList.values()) {
              if(product.getId()==id){
                  return product;
              }
        }
        return null;
    }

    @Override
    public void delete(int id) {
       productList.remove(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> productList1 = new ArrayList<>();
        for (Product product:productList.values()) {
            if(product.getName().contains(name)){
                productList1.add(product);
            }
        }
        return productList1;
    }
}
