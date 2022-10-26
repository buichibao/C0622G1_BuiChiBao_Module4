package com.example.model;

import javax.persistence.*;

@Entity
public class CodeBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    private int codeBook1;

    @OneToOne(mappedBy = "codeBook")
    private Book book;

    public CodeBook() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodeBook1() {
        return codeBook1;
    }

    public void setCodeBook1(int codeBook1) {
        this.codeBook1 = codeBook1;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
