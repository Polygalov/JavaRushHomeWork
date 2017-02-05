package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import sun.misc.Sort;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        // напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        BufferedReader reader = new BufferedReader(new FileReader(s));

        ArrayList<Integer> list = new ArrayList<Integer>();

        String num = br.readLine();

        while ((num = reader.readLine()) != null) {
            int number = Integer.parseInt(num);
            if ((number%2==0)) {
                list.add(number);
            }
        }

        Collections.sort(list);
        for (int x: list) {
            System.out.println(x);
        }
    }
}
        /*
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        InputStream inStream = new FileInputStream(reader.readLine());
        // Solution myObject = new Solution();
        ArrayList<Integer>list=new ArrayList<Integer>();
        while (inStream.available() > 0)
        {
            //int data = inStream.read(); //читаем один int из потока для чтения
            //myObject.write(data); //записываем прочитанный int в другой поток.
            list.add((Integer) inStream.read());
            //list.add(Integer)a;
        }

        inStream.close();
        reader.close();

        for (int i = 0; i < list.size(); )  //убрали увеличение i внутрь цикла
        {
            Integer x = list.get(i);
            if (x % 2 != 0)

                list.remove(i);  //не увеличиваем i, если удалили текущий  элемент
            else
                i++;
        }
        Object ia[] = list.toArray();
        Arrays.sort(ia);

        for (int x = 0; x < ia.length; x++)
            System.out.println(ia[x]);
        // c:/result.txt
        */


