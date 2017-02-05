package com.javarush.test.level13.lesson11.home03;

/* Чтение файла
1. Считать с консоли имя файла.
2. Вывести в консоль(на экран) содержимое файла.
3. Не забыть освободить ресурсы. Закрыть поток чтения с файла и поток ввода с клавиатуры.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args)throws IOException
    {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        InputStream inStream = new FileInputStream(reader.readLine());
       // Solution myObject = new Solution();

        while (inStream.available() > 0)
        {
            //int data = inStream.read(); //читаем один int из потока для чтения
            //myObject.write(data); //записываем прочитанный int в другой поток.
            System.out.print((char)inStream.read());
        }

        inStream.close();
        reader.close();


        //закрываем потоки
    }
        //OutputStream outStream = new FileOutputStream("c:/result.txt");


    }

