package com.javarush.test.level05.lesson12.home05;


import java.io.*;

/* Вводить с клавиатуры числа и считать их сумму
Вводить с клавиатуры числа и считать их сумму, пока пользователь не введёт слово «сумма». Вывести на экран полученную сумму.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        int sum = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //int sum = 0;
        while (true)
        {
            String word = reader.readLine();
            if (word.equals("сумма"))
            {
                System.out.println(sum);
                break;
            }
            sum += Integer.parseInt(word);
        }



        }
    }




