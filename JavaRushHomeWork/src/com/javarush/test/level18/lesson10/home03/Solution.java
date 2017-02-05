package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName3 = reader.readLine();
        FileOutputStream outputStream = new FileOutputStream(fileName3);
        String fileName = reader.readLine();
        FileInputStream inputStream = new FileInputStream(fileName);
        //Создаем поток-чтения-байт-из-файла
        String fileName2 = reader.readLine();
        FileInputStream inputStream2 = new FileInputStream(fileName2);
        // Создаем поток-записи-байт-в-файл


        while (inputStream.available() > 0) //пока есть еще непрочитанные байты
        {
            int data = inputStream.read(); // прочитать очередной байт в переменную data
            outputStream.write(data); // и записать его во второй поток
        }
        while (inputStream2.available() > 0) //пока есть еще непрочитанные байты
        {
            int data = inputStream2.read(); // прочитать очередной байт в переменную data
            outputStream.write(data); // и записать его во второй поток
        }
reader.close();
        inputStream.close(); //закрываем оба потока. Они больше не нужны.
        inputStream2.close();
        outputStream.close();
    }


}
