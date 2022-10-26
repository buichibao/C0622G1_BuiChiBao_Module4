package com.example.repository;

import com.example.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepository extends JpaRepository<Student,Integer> {

    Student findById(int id);

    Page<Student> findByNameContaining(Pageable pageable,String nameStudent);
}
