package com.javarush.test.level15.lesson12.home07;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* Файл в статическом блоке
1. Инициализируй константу Constants.FILE_NAME полным путем к файлу с данными, который содержит несколько строк.
2. В статическом блоке считай из файла с именем Constants.FILE_NAME все строки и добавь их по-отдельности в List lines.
3. Закрой поток ввода методом close().
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();

 /*   {

       // String s = "";
        Scanner in = null;
        try
        {
            in = new Scanner(new File(Constants.FILE_NAME));
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        while(in.hasNext())
            lines.add(in.nextLine() + "\r\n");
        in.close();
    }
*/
 static
 {
     //Этот спец. объект для построения строки
     StringBuilder sb = new StringBuilder();

     //exists(fileName);

     try {
         //Объект для чтения файла в буфер
         BufferedReader in = new BufferedReader(new FileReader( Constants.FILE_NAME));
         try {
             //В цикле построчно считываем файл
             String s;
             while ((s = in.readLine()) != null) {
                 lines.add(s);
                // sb.append(s);
                // sb.append("\n");
             }
         } finally {
             //Также не забываем закрыть файл
             in.close();
         }
     } catch(IOException e) {
         throw new RuntimeException(e);
     }

     //Возвращаем полученный текст с файла
    // return sb.toString();
 }
    public static void main(String[] args) throws FileNotFoundException
    {
        //Solution.read();
        System.out.println(Solution.lines);
    }
}
