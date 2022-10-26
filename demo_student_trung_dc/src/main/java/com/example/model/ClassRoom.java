package com.example.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ClassRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;


    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @OneToMany(mappedBy = "classRoom")
    private Set<Student> students;

    public ClassRoom() {
    }

    public Set<Student> getStudents() {
        return students;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
