package com.javarush.test.level29.lesson15.big01.human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Human implements Alive {
    private List<Human> children = new ArrayList<>();
    private static int nextId = 0;
    private int id;
    protected int age;
    protected String name;


    protected Size size;



  //  public static final int FIRST = 1;
  //  public static final int SECOND = 2;
  //  public static final int THIRD = 3;
 //   public static final int FOURTH = 4;
    private BloodGroup bloodGroup;

    public void setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }
    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public List<Human> getChildren() {

        return Collections.unmodifiableList(children);
    }


    public void addChild(Human human){
        children.add(human);
    }
    public void removeChild(Human human){
        children.remove(human);
    }

    public Human(String name, int age)
    {
        this.name=name;
        this.age=age;

        this.id = nextId;
        nextId++;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public void live(){
    }

    public int getId() {
        return id;
    }


    public void printSize() {
        System.out.println("Рост: " + size.height + " Вес: " + size.weight);
    }
    public String getPosition(){
        return "Человек";
    }
    public void printData() {
        System.out.println(getPosition() + ": " + name);
    }
    public class Size{
        public int height;
        public int weight;

    }
}
/*
9.2.	Замена поля-массива объектом. Замени массив int[] size. Объектом нового типа Size,
содержащим публичные поля: рост int height и вес int weight. Публичный класс Size объяви
внутри класса Human.
9.4.	Замена кодирования типа классом.
9.4.1.	Объяви публичный класс группы крови BloodGroup внутри пакета human.
9.4.2.	Добавь в класс BloodGroup константное поле int code, приватный конструктор,
принимающий int и инициализирующий поле code, геттер для поля класса.
9.4.3.	Добавь в класс BloodGroup статические методы first(), second(), third() и fourth(),
создающие и возвращающие объекты типа BloodGroup с правильным кодом внутри (1,
2, 3 и 4 соответственно).
9.4.4.	Примени в классе Human новый тип BloodGroup.
 */