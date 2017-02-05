package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException
    {



        Map<String, Double> map = new TreeMap<String, Double>();


        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        String str;
        String[] strMass;


        while ((str = fileReader.readLine()) != null) {
            strMass = str.split(" ");

            if (map.containsKey(strMass[0])){
                map.put(strMass[0],Double.parseDouble(strMass[1])+map.get(strMass[0]));
            }
            else
                map.put(strMass[0],Double.parseDouble(strMass[1]));

        }

        for (Map.Entry<String, Double> pair : map.entrySet())
        {
            String key = pair.getKey();                      //ключ
            Double value = pair.getValue();                  //значение
            System.out.println(key + " " + value);
        }
        fileReader.close();
    }
}
