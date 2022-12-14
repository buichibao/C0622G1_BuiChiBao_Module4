package com.example.repository;

import com.example.model.Student;

import java.util.List;

public interface IStudentRepository {

    List<Student> findAll();

    List<Student> searchByName(String name);

    List<String> findAllLanguage();

    void save(Student student);
}
