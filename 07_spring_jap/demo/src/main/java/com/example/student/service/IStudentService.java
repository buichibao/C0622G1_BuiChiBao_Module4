package com.example.student.service;

import com.example.student.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IStudentService {
    Page<Student> findByNameContaining(Pageable pageable, String name);

    void save(Student student);

    void delete(int id);

    void update(Student student);

    Student findById(int id);

}
