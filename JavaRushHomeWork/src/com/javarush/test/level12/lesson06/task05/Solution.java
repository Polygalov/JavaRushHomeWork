package com.javarush.test.level12.lesson06.task05;

/* Классы Cat и Dog от Pet
Унаследуй классы Cat и Dog от Pet.
Реализуй недостающие методы. Классы Cat и Dog не должны быть абстрактными.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static abstract class Pet
    {
        public abstract String getName();
        public abstract Pet getChild();
    }

    public static class Cat extends Pet
    {
        public String getName(){
            String name = "cat";
            return name;
        }
        public Pet getChild(){
            Pet child1 = null;
            return child1;
        }

    }

    public static class Dog extends Pet
    {
        public String getName(){
            String name1 = "cat1";
            return name1;
        }
        public Pet getChild(){
            Pet child2 = null;
            return child2;
        }
    }

}
