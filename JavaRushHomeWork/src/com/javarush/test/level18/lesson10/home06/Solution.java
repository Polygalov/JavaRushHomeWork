package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Solution
{
    public static List<Character> integerList = new ArrayList<Character>();
    public static Map<Character, Integer> map = new HashMap<Character, Integer>();


    public static void main(String[] args) throws Exception
    {

        FileInputStream inputStream = new FileInputStream(args[0]);


        int count = 0;


        while (inputStream.available() > 0)
        {
            int data = inputStream.read();
            integerList.add((char)data);
        }

        for (Character i : integerList)
        {
            count = Collections.frequency(integerList, i);
            map.put(i, count);
        }




        Map<Character, Integer> treeMap = new TreeMap<Character, Integer>(map);
        printMap(treeMap);
        inputStream.close();
    }
    public static void printMap(Map<Character, Integer> map)
    {
        for (Map.Entry<Character, Integer> entry : map.entrySet())
        {

            System.out.println((char)entry.getKey()+ " "+ entry.getValue()  );
        }
    }


    }

