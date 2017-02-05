package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
//Создаем поток-чтения-байт-из-файла
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(br.readLine());
        FileOutputStream outputStream = new FileOutputStream(br.readLine());

        byte[] buffer = new byte[inputStream.available()];
        byte[] buffer_rev = new byte[inputStream.available()];
        int buf_size = inputStream.read(buffer);
        for(int i = buf_size - 1; i >= 0; i--)
        {
            buffer_rev[buf_size - 1 - i] = buffer[i];
        }

            outputStream.write(buffer_rev); //записать блок(часть блока) во второй поток

        br.close();
        inputStream.close(); //закрываем оба потока. Они больше не нужны.
        outputStream.close();



    }
    }

