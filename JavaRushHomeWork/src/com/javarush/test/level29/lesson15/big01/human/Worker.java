package com.javarush.test.level29.lesson15.big01.human;

public class Worker extends Human {
    //private Human human;
    private double salary;
    private String company;

    public Worker(String name, int age)
    {
        super(name, age);
    }

    public String getCompany()
    {
        return company;
    }

    public void setCompany(String company)
    {
        this.company = company;
    }

    public void live() {
        live();
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
/*
9.3.	Инкапсуляция поля. Сокрой поле company в классе Worker. Добавь сеттер и геттер для
него.
 */