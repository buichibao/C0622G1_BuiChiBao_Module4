package com.example.service;

import com.example.model.Customer;

import java.util.List;

public interface ICustomerService {

    List<Customer> findAllCustomer();

    void save(Integer integer,Customer customer);
}
