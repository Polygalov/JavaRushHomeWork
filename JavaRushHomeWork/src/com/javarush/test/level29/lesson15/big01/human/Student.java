package com.javarush.test.level29.lesson15.big01.human;


import java.util.Date;


public class Student extends UniversityPerson {
    private double averageGrade;
    private Date beginningOfSession;
    private Date endOfSession;
    private int course;
    public Student(String name, int age, double averageGrade) {
        super(name, age);
        this.averageGrade = averageGrade;
    }
    public void live() {
        learn();
    }
    public void learn() {
    }


    public void incAverageGrade(double delta){
        //getAverageGrade() += delta;
        setAverageGrade (getAverageGrade() + delta);
    }

    public void setCourse (int course){
        this.course = course;

    }
    public void setAverageGrade (double averageGrade){
        this.averageGrade = averageGrade;

    }

    public void setBeginningOfSession(Date beginning) {
        beginningOfSession = beginning;
    }
    public void setEndOfSession(Date end) {
        endOfSession = end;
    }
    public double getAverageGrade() {
        return averageGrade;
    }
    public int getCourse() {
        return course;
    }

    @Override
    public String getPosition()
    {
        return "Студент";
    }
}
/*
9.1.	Самоинкапсуляция поля. Перепиши метод incAverageGrade() используя сеттер и геттер для
доступа к averageGrade.
9.2.	Замена поля-массива объектом. Замени массив int[] size. Объектом нового типа Size,
содержащим публичные поля: рост int height и вес int weight. Публичный класс Size объяви
внутри класса Human.
9.3.	Инкапсуляция поля. Сокрой поле company в классе Worker. Добавь сеттер и геттер для
него.
9.4.	Замена кодирования типа классом.
9.4.1.	Объяви публичный класс группы крови BloodGroup внутри пакета human.
9.4.2.	Добавь в класс BloodGroup константное поле int code, приватный конструктор,
принимающий int и инициализирующий поле code, геттер для поля класса.
9.4.3.	Добавь в класс BloodGroup статические методы first(), second(), third() и fourth(),
создающие и возвращающие объекты типа BloodGroup с правильным кодом внутри (1,
2, 3 и 4 соответственно).
9.4.4.	Примени в классе Human новый тип BloodGroup.
 */