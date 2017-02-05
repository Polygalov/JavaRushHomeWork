package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileReader reader = new FileReader(br.readLine());
        FileWriter writer = new FileWriter(br.readLine());

        while (reader.ready()) //пока есть непрочитанные байты в потоке ввода
        {
            int data = reader.read(); //читаем один символ (char будет расширен до int)
            if (data==46){
                data=33;
            }
           // System.out.println(data);
            writer.write(data); //пишем один символ (int будет обрезан/сужен до char)
        }

        //закрываем потоки после использования
        br.close();
        reader.close();
        writer.close();
    }
}
