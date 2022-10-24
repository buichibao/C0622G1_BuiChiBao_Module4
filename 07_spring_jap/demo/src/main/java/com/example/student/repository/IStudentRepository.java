package com.example.student.repository;

import com.example.student.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepository extends JpaRepository<Student,Integer> {

    Page<Student> findByNameContaining(Pageable pageable,String name);

    Student findById(int id);
}
