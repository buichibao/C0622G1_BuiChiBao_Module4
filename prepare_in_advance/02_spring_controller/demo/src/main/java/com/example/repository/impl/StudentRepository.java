package com.example.repository.impl;

import com.example.model.Student;
import com.example.repository.IStudentRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class StudentRepository implements IStudentRepository {
    private static Map<Integer, Student> studentMap = new HashMap<>();

    private static List<String> languagesList = new ArrayList<>();

    static {
        studentMap.put(1,new Student(1,"Ronaldo",1,new String[]{"Java","C++"}));
        studentMap.put(2,new Student(2,"Messi",1,new String[]{"C++"}));
        studentMap.put(3,new Student(3,"Son",0,new String[]{"PHP"}));

        languagesList.add("JAVA");
        languagesList.add("C++");
        languagesList.add("PHP");
        languagesList.add("C#");
    }

    @Override
    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        for (Integer integer:studentMap.keySet()) {
              students.add(studentMap.get(integer));
        }
        return students;
    }

    @Override
    public List<Student> searchByName(String name) {
        List<Student> students = new ArrayList<>();
        for (Integer integer:studentMap.keySet()) {
            if(studentMap.get(integer).getName().toLowerCase().contains(name)){
                students.add(studentMap.get(integer));
            }
        }
        return students;
    }

    @Override
    public List<String> findAllLanguage() {
        return languagesList;
    }

    @Override
    public void save(Student student) {
        studentMap.put(student.getId(),student);
    }
}
