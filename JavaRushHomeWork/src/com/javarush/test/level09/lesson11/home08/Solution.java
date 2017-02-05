package com.javarush.test.level09.lesson11.home08;

import java.util.ArrayList;

/* Список из массивов чисел
Создать список, элементами которого будут массивы чисел. Добавить в список пять объектов–массивов длиной 5, 2, 4, 7, 0 соответственно. Заполнить массивы любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList()
    {
        //напишите тут ваш код
        ArrayList<int[]> list = new ArrayList<int[]>();
        int[] mas1 = {10,20,30,40,50};
        int[] mas2 = {10,20};
        int[] mas3 = {10,20,30,40};
        int[] mas4 = {10,20,30,40,50,60,70};
        int[] mas5 = {};
        list.add(mas1);
        list.add(mas2);
        list.add(mas3);
        list.add(mas4);
        list.add(mas5);
        return list;
    }

    public static void printList(ArrayList<int[]> list)
    {
        for (int[] array: list )
        {
            for (int x: array)
            {
                System.out.println(x);
            }
        }
    }
}
