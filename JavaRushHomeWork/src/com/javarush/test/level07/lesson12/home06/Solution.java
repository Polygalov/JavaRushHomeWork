package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        Human ded1 = new Human("Pavel",true,69, null, null);
        Human ded2 = new Human("Andy",true,72, null, null);

        Human baba1 = new Human("Anna",false,58, null, null);
        Human baba2 = new Human("Olga",false,73, null, null);

        Human mother1 = new Human("Katya",false,33, ded1, baba1);
        Human father1 = new Human("Oleg",true,35, ded2, baba2);

        Human kid1 = new Human("Kat",false,3, father1, mother1);
        Human kid2 = new Human("Oeg",true,5, father1, mother1);
        Human kid3 = new Human("Kaya",false,8, father1, mother1);

        System.out.println(ded1);
        System.out.println(ded2);
        System.out.println(baba1);
        System.out.println(baba2);
        System.out.println(mother1);
        System.out.println(father1);
        System.out.println(kid1);
        System.out.println(kid2);
        System.out.println(kid3);
    }

    public static class Human
    {
        //напишите тут ваш код

          String name;
            boolean sex;
            int age;
        Human father;
        Human mother;

            public Human(String name, boolean sex, int age, Human father, Human mother )
            {
                this.name = name;
                this.age = age;
                this.sex = sex;
               this.father = father;
               this.mother = mother;
            }


        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
