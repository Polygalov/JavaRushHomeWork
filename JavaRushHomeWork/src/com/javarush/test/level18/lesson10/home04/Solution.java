package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = br.readLine();
        String filename2 = br.readLine();

        RandomAccessFile randomAccessFile = new RandomAccessFile(filename1, "rw");
        byte[] array = new byte[(int) randomAccessFile.length()];
        randomAccessFile.read(array);
        randomAccessFile.seek(0);

        FileInputStream fileInputStream = new FileInputStream(filename2);
        while (fileInputStream.available()>0) {
            randomAccessFile.write(fileInputStream.read());
        }
        randomAccessFile.write(array);

        br.close();
        fileInputStream.close();
        randomAccessFile.close();

    }
}
