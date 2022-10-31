package com.example.model;

public class Counter {
    private int counter;

    public Counter() {
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public int increment(){
        return  counter++;
    }

    public int increment1(){
        return  counter+=2;
    }
}
