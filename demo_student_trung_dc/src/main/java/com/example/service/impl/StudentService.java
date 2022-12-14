package com.example.service.impl;

import com.example.model.Student;
import com.example.repository.IStudentRepository;
import com.example.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements IStudentService {

    @Autowired
    private IStudentRepository iStudentRepository;

    @Override
    public void save(Student student) {
        iStudentRepository.save(student);
    }

    @Override
    public void delete(int id) {
        iStudentRepository.deleteById(id);
    }

    @Override
    public void update(Student student) {
       iStudentRepository.save(student);
    }

    @Override
    public Student findById(int id) {
        return iStudentRepository.findById(id);
    }

    @Override
    public Page<Student> findByNameContaining(Pageable pageable, String nameStudent) {
        return iStudentRepository.findByNameContaining(pageable,nameStudent);
    }
}
