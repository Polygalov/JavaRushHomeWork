package com.javarush.test.level10.lesson11.home09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* Одинаковые слова в списке
Ввести с клавиатуры в список 20 слов. Нужно подсчитать количество одинаковых слов в списке.
Результат нужно представить в виде словаря Map<String, Integer>, где первый параметр – уникальная строка,
а второй – число, сколько раз данная строка встречалась в списке.
Вывести содержимое словаря на экран.
В тестах регистр (большая/маленькая буква) влияет на результат.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> words = new ArrayList<String>();
        for (int i = 0; i < 20; i++)
        {
            words.add(reader.readLine());
        }

        Map<String, Integer> map = countWords(words);

        for (Map.Entry<String, Integer> pair : map.entrySet())
        {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }

    public static Map<String, Integer> countWords(ArrayList<String> list)
    {
        HashMap<String, Integer> result = new HashMap<String, Integer>();

        //напишите тут ваш код
        //List<Integer> list = Arrays.asList(2,2,2,3,2,3,2,2,3,3,3,5,5,1);

       // HashMap<String, Integer> hm = new HashMap<String, Integer>();
        Integer am;
        for (String i : list) {

            am = result.get(i);
            result.put(i, am == null ? 1 : am + 1);
        }

        //for (Object key : hm.keySet().toArray()) {

        //if (hm.get(key) == 1) {

        //	hm.remove(key);
        //}
        //}
        /*for (Entry<String, Integer> pair : result.entrySet())
        {
            String key = pair.getKey();                      //ключ
            int value = pair.getValue();                  //значение
            System.out.println(key + ":" + value);
        }
*/

        return result;
    }

}
