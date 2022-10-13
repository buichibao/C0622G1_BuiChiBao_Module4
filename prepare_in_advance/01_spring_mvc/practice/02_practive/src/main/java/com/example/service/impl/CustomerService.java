package com.example.service.impl;

import com.example.model.Customer;
import com.example.service.ICustomerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomerService implements ICustomerService {
    private static  Map<Integer,Customer> customerMap = new HashMap<>();

    static  {
        customerMap.put(1,new Customer(1,"bao","bao@123","Ha Tinh"));
        customerMap.put(2,new Customer(2,"vinh","vinh@123","Ha Tinh"));
        customerMap.put(3,new Customer(3,"huong","huong@123","Ha Tinh"));
        customerMap.put(4,new Customer(4,"thuy","thuy@123","Ha Tinh"));
    }

    @Override
    public List<Customer> findAllCustomer() {
        List<Customer> customerList = new ArrayList<>();
        for (Customer customer:customerMap.values()) {
            customerList.add(customer);
        }
        return customerList;
    }

    @Override
    public void save(Integer integer, Customer customer) {
        customerMap.put(integer,customer);
    }


}
