package com.javarush.test.level05.lesson12.bonus03;

import java.io.*;

/* Задача по алгоритмам
Написать программу, которая:
1. вводит с консоли число N > 0
2. потом вводит N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int maximum = 0;
        int n = Integer.parseInt(reader.readLine()); //считываем n
        //напишите тут ваш код
        for (int i = 0; i<n; i++){ //входим в цикл по числу n

            //считываем число с консоли
            int temp = Integer.parseInt(reader.readLine());

            //если это нулевой цикл, то присваиваем числу
            //maximum значение считанного числа
            if (i==0) maximum=temp;

                //в дальнейшем значение присваиваем только если
                //число с консоли больше maximum
            else if (temp>maximum) maximum=temp;
        }

        System.out.println(maximum);
    }
}
