package com.example.service;

import com.example.model.Student;

import java.util.List;

public interface IStudentService {

    List<Student> findAll();

    List<Student> searchByName(String name);

    List<String> findAllLanguage();

    void save(Student student);
}
