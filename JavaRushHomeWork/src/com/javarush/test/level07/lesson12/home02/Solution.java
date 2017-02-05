package com.javarush.test.level07.lesson12.home02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Переставить M первых строк в конец списка
Ввести с клавиатуры 2 числа N  и M.
Ввести N строк и заполнить ими список.
Переставить M первых строк в конец списка.
Вывести список на экран, каждое значение с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //напишите тут ваш код
        //System.out.println("Введите N");
        String a = reader.readLine();
        int n = Integer.parseInt(a);

        //System.out.println("Введите M");
        String b = reader.readLine();
        int m = Integer.parseInt(b);

        ArrayList<String> list = new ArrayList<String>();

        for (int i = 0; i < n; i++)
        {
            String s = reader.readLine();
            //int a = Integer.parseInt(s);
            list.add(s);
        }
        for(int i = 0; i < m; i++){
            list.add(list.remove(0));
        }
        for (int j = 0; j < list.size(); j++)
        {

            System.out.println(list.get(j));

        }
    }
}