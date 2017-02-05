package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
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


        ValueComparator bvc =  new ValueComparator(map);
        TreeMap<String,Double> sorted_map = new TreeMap<String,Double>(bvc);


        sorted_map.putAll(map);

        //System.out.println("results: "+sorted_map);
        Double money=0.0d;
        ArrayList<String>list=new ArrayList<String>();  //для записи самых богатых
        for(Map.Entry<String, Double>pair: sorted_map.entrySet()){
            if(pair.getValue()>money){
                money=pair.getValue();
                list.clear();
                list.add(pair.getKey());
            }
            else if(pair.getValue().equals(money)) {
                list.add(pair.getKey());
            }
        }
        for (String nameBigMoney:list)
        {
            System.out.print(nameBigMoney + " ");
        }
        /*
        ArrayList<String> list= new ArrayList<String>();

        for (Map.Entry<String, Double> pair : sorted_map.entrySet())
        {
            String key = pair.getKey();                      //ключ
            Double value = pair.getValue();
            list.add(key);

        }
        System.out.println(list.get(0));
        */
        fileReader.close();
    }
    static class ValueComparator implements Comparator<String>
    {

        Map<String, Double> base;

        public ValueComparator(Map<String, Double> base)
        {
            this.base = base;
        }

        // Note: this comparator imposes orderings that are inconsistent with equals.
        public int compare(String a, String b)
        {
            if (base.get(a) >= base.get(b))
            {
                return -1;
            } else
            {
                return 1;
            } // returning 0 would merge keys
        }
    }
}
