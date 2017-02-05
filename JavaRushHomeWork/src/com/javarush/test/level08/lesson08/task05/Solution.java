package com.javarush.test.level08.lesson08.task05;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        HashMap<String, String> m = new HashMap<String, String>();
        m.put("Гулаева", "Анна");
        m.put("Смердяков", "Алексей");
        m.put("Попова", "Анна");
        m.put("Попович", "Иван");
        m.put("Пенькова", "Мария");
        m.put("Пеньков", "Алёна");
        m.put("Вострецова", "Анна");
        m.put("Попов", "Алексей");
        m.put("Звягин", "Алексей");
        m.put("Долгушина", "Юлия");
        //removeTheFirstNameDuplicates(m);
        return m;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        HashMap<String, String> chtoUdalit = new HashMap<String, String>(map);
        HashSet<String> newarr = new HashSet<String>();


        for(String f: chtoUdalit.values())
        {
            if (newarr.contains(f))
            {
                removeItemFromMapByValue(map, f);
            } else
                newarr.add(f);
        }
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
    public  static void main(String[] args)
    {
        HashMap<String,String> hm = createMap();
        HashMap<String, String> copy = new HashMap<String, String>(hm);
        for (Map.Entry<String, String> pair : copy.entrySet())
        {
            System.out.println(pair.getValue());
        }

    }

}