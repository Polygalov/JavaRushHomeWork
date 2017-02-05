package com.javarush.test.level05.lesson12.bonus02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Нужно добавить в программу новую функциональность
Задача: Программа вводит два числа с клавиатуры и выводит минимальное из них на экран.
Новая задача: Программа вводит пять чисел с клавиатуры и выводит минимальное из них на экран.
*/

public class Solution
{

    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());
        int d = Integer.parseInt(reader.readLine());
        int e = Integer.parseInt(reader.readLine());

        int minimum1 = min_a(a, b);
        int minimum2 = min_b(c, d);
        int minimum;
        if (e < minimum1 && e < minimum2)
            minimum=e;
        else if (minimum1 < minimum2 && minimum1 < e)
            minimum=minimum1;
            else
            minimum=minimum2;


        System.out.println("Minimum = " + minimum);
    }


    public static int min_a(int a, int b)
    {
        return a < b ? a : b;
    }
    public static int min_b(int c, int d)
    {
        return c < d ? c : d;
    }

}
