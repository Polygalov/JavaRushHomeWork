package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        String key=args[0];
        String fileName = args[1];
        String fileOutputName = args[2];
        FileInputStream fileInputStream = new FileInputStream(fileName);
        FileOutputStream fileOutputStream = new FileOutputStream(fileOutputName);
        if ("-e".equals(key)) {
            while (fileInputStream.available() > 0) //пока есть еще непрочитанные байты
            {
                int data = fileInputStream.read(); // прочитать очередной байт в переменную data
                fileOutputStream.write(data+5); // и записать его во второй поток
            }

        }
        if ("-d".equals(key)) {
            while (fileInputStream.available() > 0) //пока есть еще непрочитанные байты
            {
                int data = fileInputStream.read(); // прочитать очередной байт в переменную data
                fileOutputStream.write(data-5); // и записать его во второй поток
            }

        }
        fileInputStream.close(); //закрываем оба потока. Они больше не нужны.
        fileOutputStream.close();
    }

}
