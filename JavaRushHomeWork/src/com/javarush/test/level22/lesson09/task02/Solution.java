package com.javarush.test.level22.lesson09.task02;

import java.util.LinkedHashMap;
import java.util.Map;

/* Формируем Where
Сформируйте часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.
Пример:
{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}
Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
*/
public class Solution {
/*
    public static StringBuilder getCondition(Map<String, String> params) {
        StringBuilder s2 = new StringBuilder("");

        for (Map.Entry<String, String> pair : params.entrySet())
        {
            String key = pair.getKey();
            String value = pair.getValue();
            if(value!=null){
                s2.append(key + " = '"+value+"' and ");
            }

        }
        String tmp = s2.toString();
        String name = tmp.substring(0, tmp.length()-5);
        StringBuilder s3 = new StringBuilder(name);
        return s3;
    }
    */
public static StringBuilder getCondition(Map<String, String> params) {
    StringBuilder stringBuilder = new StringBuilder();
    for (Map.Entry<String, String> entry : params.entrySet()) {
        if (entry.getValue() != null) {
            if (stringBuilder.toString().equals(""))
                stringBuilder.append(entry.getKey()).append(" = '").append(entry.getValue()).append("'");
            else
                stringBuilder.append(" and ").append(entry.getKey()).append(" = '").append(entry.getValue()).append("'");
        }

    }
    return stringBuilder;
}

    public static void main(String[] args)
    {
        Map<String, String> map = new LinkedHashMap<>();
//        Map<String, String> map = new HashMap<>();
        map.put("name", "Ivanich");
        map.put("country", "Rashka");
        map.put("city", "Moscow");
        map.put("city3", null);
        map.put("city4", null);
        map.put("city5", null);
        System.out.println(getCondition(map));
        System.out.println(map.size());
    }
}
