package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        //напишите тут ваши переменные и конструкторы
        String name;
        int age;
        int weight;
        String addres;
        boolean sex;
        String pet;

        Human (int age, String name, int weight, String pet, boolean sex,String addres  )
        {
            this.age=age;
            this.name=name;
            this.weight=weight;
            this.sex=sex;
            this.pet=pet;
            this.addres=addres;

        }
        Human (int age, String name, int weight, String pet, boolean sex )
        {
            this.age=age;
            this.name=name;
            this.weight=weight;
            this.sex=sex;
            this.pet=pet;
                    }
        Human (int age, String name, int weight, boolean sex )
        {
            this.age=age;
            this.name=name;
            this.weight=weight;
            this.sex=sex;
                    }
        Human (int age, String name, int weight, boolean sex, String addres  )
        {
            this.age=age;
            this.name=name;
            this.weight=weight;
            this.sex=sex;

            this.addres=addres;

        }
        Human ( String name, int weight, String pet, boolean sex,String addres  )
        {

            this.name=name;
            this.weight=weight;
            this.sex=sex;
            this.pet=pet;
            this.addres=addres;

        }
        Human (int age, String name, String pet, boolean sex,String addres  )
        {
            this.age=age;
            this.name=name;

            this.sex=sex;
            this.pet=pet;
            this.addres=addres;

        }
        Human (int age, String name  )
        {
            this.age=age;
            this.name=name;


        }
        Human ( String pet, boolean sex)
        {

            this.sex=sex;
            this.pet=pet;


        }
        Human ( boolean sex, String addres  )
        {

            this.sex=sex;
            this.addres=addres;

        }
        Human ( int weight, String pet, boolean sex  )
        {

            this.weight=weight;
            this.sex=sex;
            this.pet=pet;


        }


    }
}
