package com.example.dto;

import com.example.model.Account;
import com.example.model.ClassRoom;
import com.example.model.Course;

import java.util.Set;

public class StudentDto {

    private int id;

    private String name;

    private int gender;

    private Account account;

    private ClassRoom classRoom;


    private Set<Course> courses;

    public StudentDto() {
    }

    public StudentDto(int id, String name, int gender, Account account, ClassRoom classRoom, Set<Course> courses) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.account = account;
        this.classRoom = classRoom;
        this.courses = courses;
    }


    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
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

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }
}
