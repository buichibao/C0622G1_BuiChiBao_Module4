package com.example.repository.impl;

import com.example.model.Student;
import com.example.repository.IStudentRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class StudentRepository implements IStudentRepository {
    private static List<Student> studentList = new ArrayList<>();

    static {
        studentList.add(new Student(1,"Ronaldo",1,new String[]{"Java","C"}));
        studentList.add(new Student(2,"Messi",1,new String[]{"C++","PHP"}));
        studentList.add(new Student(3,"Son",0,new String[]{"RUBY"}));
    }

    @Override
    public List<Student> findAll() {
        return studentList;
    }
}
