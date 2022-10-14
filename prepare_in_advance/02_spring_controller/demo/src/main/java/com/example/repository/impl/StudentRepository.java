package com.example.repository.impl;

import com.example.model.Student;
import com.example.repository.IStudentRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentRepository implements IStudentRepository {
    private static Map<Integer, Student> studentMap = new HashMap<>();

    static {
        studentMap.put(1,new Student(1,"Ronaldo",1,new String[]{"Java","C++"}));
        studentMap.put(2,new Student(2,"Messi",1,new String[]{"C++"}));
        studentMap.put(3,new Student(3,"Son",0,new String[]{"PHP"}));
    }

    @Override
    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        for (Integer integer:studentMap.keySet()) {
              students.add(studentMap.get(integer));
        }
        return students;
    }
}
