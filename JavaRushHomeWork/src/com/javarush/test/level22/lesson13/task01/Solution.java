package com.javarush.test.level22.lesson13.task01;

import java.util.ArrayList;
import java.util.StringTokenizer;

/* StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.
Пример,
getTokens("level22.lesson13.task01", ".") == {"level22", "lesson13", "task01"}
*/
public class Solution {
    public static String [] getTokens(String query, String delimiter) {
        ArrayList<String> list = new ArrayList<String>();

        //String s = "Строка, которую мы хотим разобрать на слова";

        StringTokenizer st = new StringTokenizer(query, delimiter);

        while(st.hasMoreTokens()){

// Получаем слово и что-нибудь делаем с ним, например,

// просто выводим на экран
            list.add(st.nextToken());
           // System.out.println(st.nextToken()) ;

        }

        String rez[] = new String[list.size()];
        for(int i =0;i<list.size();i++){
            rez[i] = list.get(i);
        }

        return rez;
    }

    public static void main(String[] args)
    {
        System.out.println(getTokens("level22.lesson13.task01", "."));
    }
}
