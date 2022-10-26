package com.example.model;

import javax.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String author;

    private int  amount;

    private int  startAmount;



    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "code_book_id",referencedColumnName = "id")
    private CodeBook codeBook;

    public Book() {
    }

    public int getId() {
        return id;
    }

    public int getStartAmount() {
        return startAmount;
    }

    public void setStartAmount(int startAmount) {
        this.startAmount = startAmount;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public CodeBook getCodeBook() {
        return codeBook;
    }

    public void setCodeBook(CodeBook codeBook) {
        this.codeBook = codeBook;
    }
}
