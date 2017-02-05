package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        String fileName2 = reader.readLine();
        String fileName3 = reader.readLine();
        FileInputStream inputStream = new FileInputStream(fileName);
        FileOutputStream outputStream1 = new FileOutputStream(fileName2);
        FileOutputStream outputStream2 = new FileOutputStream(fileName3);

        while(inputStream.available() > 0){
            if(inputStream.available() % 2 == 0){
                byte[] o1 = new byte[inputStream.available()/2];
                byte[] o2 = new byte[inputStream.available()/2];
                int count1 = inputStream.read(o1);
                int count2 = inputStream.read(o2);
                outputStream1.write(o1, 0, count1);
                outputStream2.write(o2, 0, count2);
            } else {
                byte[] o1 = new byte[inputStream.available()/2 + 1];
                byte[] o2 = new byte[inputStream.available()/2];
                int count1 = inputStream.read(o1);
                int count2 = inputStream.read(o2);
                outputStream1.write(o1, 0, count1);
                outputStream2.write(o2, 0, count2);
            }
        }


        reader.close();
        inputStream.close(); //закрываем оба потока. Они больше не нужны.
        outputStream1.close();
        outputStream2.close();
    }
}
