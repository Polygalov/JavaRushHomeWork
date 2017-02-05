package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;


public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //создаем объект FileInputStream, привязанный к файлу «c:/a.txt».
        String name1 = br.readLine();
        BufferedReader fin = new BufferedReader(new FileReader(name1));
        String line;
        FileWriter fileWriter = new FileWriter(br.readLine());

        while ((line = fin.readLine()) != null)
        {
            String aCats[] = (line.split(" "));

            for (int i = 0; i < aCats.length; i++)
            {
                if (isDigit(aCats[i]))
                {
                    fileWriter.write(aCats[i] + " ");

                }
            }
        }
        br.close();
        fin.close();
        fileWriter.close();
    }


        public static boolean isDigit(String string){
            try {
                int a = Integer.parseInt(string);
            } catch (Exception e) {
                return false;
            }
            return true;
        }


    }


