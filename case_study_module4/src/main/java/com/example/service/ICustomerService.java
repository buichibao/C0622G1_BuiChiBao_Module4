package com.example.service;

import com.example.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
       List<Customer> findAll();

       void save (Customer customer);

       Page<Customer> searchCustomer(String nameSearch, String emailSearch, String addressSearch, Pageable pageable);

       void deleteLogical(Integer id);

       void update(Customer customer);

       Optional<Customer> findById(Integer id);
}
