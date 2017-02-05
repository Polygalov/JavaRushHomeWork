package com.javarush.test.level04.lesson16.home02;

import java.io.*;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String sNum1 = reader.readLine();
        int a = Integer.parseInt(sNum1);
        String sNum2 = reader.readLine();
        int b = Integer.parseInt(sNum2);
        String sNum3 = reader.readLine();
        int c = Integer.parseInt(sNum3);
        int k;
        int l;
        int m;
        if (a>b && a>c)
            k=a;
        else if (b>a && b>c)
            k=b;
        else
            k=c;
        if (a<b && a<c)
            l=a;
        else if (b<a && b<c)
            l=b;
        else
            l=c;
        if (b !=k && b !=l)
            m=b;
        else if (a !=k && a !=l)
            m=a;
        else
            m=c;
        System.out.println(m);
    }
}
