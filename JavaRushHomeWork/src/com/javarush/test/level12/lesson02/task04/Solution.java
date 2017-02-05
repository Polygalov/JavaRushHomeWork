package com.javarush.test.level12.lesson02.task04;

/* Или «Кошка», или «Собака», или «Птица», или «Лампа»
Написать метод, который определяет, объект какого класса ему передали, и выводит на экран одну из надписей: Кошка, Собака, Птица, Лампа.
*/

public class Solution
{
    public static void main(String[] args)
    {
        printObjectType(new Cat());
        printObjectType(new Bird());
        printObjectType(new Lamp());
        printObjectType(new Cat());
        printObjectType(new Dog());
    }

    public static void printObjectType(Object o)
    {
      //Напишите тут ваше решение
        if (o instanceof Cat)
        {
            //Object o = new Cat();
            Cat cat = (Cat) o;
            System.out.println("Кошка");
        }
        if (o instanceof Bird)
        {
            //Object o = new Cat();
            Bird bird = (Bird) o;
            System.out.println("Птица");
        }
        if (o instanceof Lamp)
        {
            //Object o = new Cat();
            Lamp lamp = (Lamp) o;
            System.out.println("Лампа");
        }
        if (o instanceof Dog)
        {
            //Object o = new Cat();
            Dog dog = (Dog) o;
            System.out.println("Собака");
        }

    }

    public static class Cat
    {
    }

    public static class Dog
    {
    }

    public static class Bird
    {
    }

    public static class Lamp
    {
    }
}
