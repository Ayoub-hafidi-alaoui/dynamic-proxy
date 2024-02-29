package com.dynamic_proxy;

public class ITEmployee implements IEmployee {
    private int id;
    private String name;
    private double salary;

    @Override
    public void giveHike(double amount) {
        this.salary = salary + amount;
    }

    @Override
    public void payCut(double amount) {
        this.salary = salary - amount;


    }
}
