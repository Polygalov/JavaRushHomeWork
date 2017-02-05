package com.javarush.test.level18.lesson03.task01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Максимальный байт
Ввести с консоли имя файла
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            //создаем объект FileInputStream, привязанный к файлу «c:/a.txt».
        String name = br.readLine();
            FileInputStream inputStream = new FileInputStream(name);
            int sum = 0;

            while (inputStream.available() > 0) //пока остались непрочитанные байты
            {
                int data = inputStream.read(); //прочитать очередной байт
                if (sum<data)
                {
                    sum = data; //добавить его к общей сумме
                }
            }
            inputStream.close(); // закрываем поток

            System.out.println(sum);

    }
}