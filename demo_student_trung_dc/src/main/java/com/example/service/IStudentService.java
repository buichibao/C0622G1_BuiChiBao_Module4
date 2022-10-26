package com.example.service;

import com.example.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IStudentService {

    void save(Student student);

    void delete(int id);

    void update(Student student);

    Student findById(int id);

    Page<Student> findByNameContaining(Pageable pageable, String nameStudent);
}
