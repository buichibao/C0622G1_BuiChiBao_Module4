package com.example.service;

import com.example.model.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    List<Customer>  findAll();

    Optional<Customer> findById(Long id);

    Customer save(Customer customer);

    void remove(Long id);
}
