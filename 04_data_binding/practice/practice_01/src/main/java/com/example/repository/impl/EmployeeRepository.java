package com.example.repository.impl;

import com.example.model.Employee;
import com.example.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class EmployeeRepository implements IEmployeeRepository {

    private static List<Employee> employeeList = new ArrayList<>();

    static {
        employeeList.add(new Employee("1","Ronaldo","123"));
        employeeList.add(new Employee("2","Messi","123"));
        employeeList.add(new Employee("3","Son","123"));
    }
    @Override
    public List<Employee> findAll() {
        return employeeList;
    }

    @Override
    public void save(Employee employee) {
        employeeList.add(employee);
    }
}
