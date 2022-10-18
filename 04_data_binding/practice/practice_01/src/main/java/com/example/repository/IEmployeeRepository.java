package com.example.repository;

import com.example.model.Employee;

import java.util.List;

public interface IEmployeeRepository {

    List<Employee> findAll();

    void save (Employee employee);


}
