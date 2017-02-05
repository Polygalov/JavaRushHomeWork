package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //создаем объект FileInputStream, привязанный к файлу «c:/a.txt».
        String name1 = br.readLine();
        String name2 = br.readLine();


            FileReader reader = new FileReader(name1);
            FileWriter writer = new FileWriter(name2);
            int count=1;
            while (reader.ready()) //пока есть непрочитанные байты в потоке ввода
            {
                count++;
                int data = reader.read(); //читаем один символ (char будет расширен до int)
                if (count%2!=0)
                writer.write(data); //пишем один символ (int будет обрезан/сужен до char)
                else continue;
            }

            //закрываем потоки после использования
        br.close();
            reader.close();
            writer.close();

    }
}
