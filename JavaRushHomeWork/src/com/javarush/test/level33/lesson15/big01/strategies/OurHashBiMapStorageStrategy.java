package com.javarush.test.level33.lesson15.big01.strategies;

import java.util.HashMap;

/**
 * Created by Andy on 18.09.2016.
 */
public class OurHashBiMapStorageStrategy implements StorageStrategy
{
    private HashMap<Long, String> k2v= new HashMap<>(); //соответствие ключа и значения
    private HashMap<String, Long> v2k= new HashMap<>(); //соответствие  значения и ключа
    @Override
    public boolean containsKey(Long key)
    {
        return k2v.containsKey(key);
    }

    @Override
    public boolean containsValue(String value)
    {
        return v2k.containsKey(value);
    }

    @Override
    public void put(Long key, String value)
    {
        k2v.put(key,value);
        v2k.put(value,key);

    }

    @Override
    public Long getKey(String value)
    {
        return v2k.get(value);
    }

    @Override
    public String getValue(Long key)
    {
        return k2v.get(key);
    }
}
/*
11.1.	Создай класс OurHashBiMapStorageStrategy, реализующий интерфейс
StorageStrategy.
11.2.	Добавь в него два поля HashMap<Long, String> k2v и HashMap<String, Long> v2k.
Первое будет хранить соответствие ключа и значения, а второе наоборот: значения
и ключа.
11.3.	Реализуй методы интерфейса StorageStrategy, обеспечив максимальную
скорость. Подсказка: при добавлении новой пары ключ-значение необходимо
добавлять ее сразу в два поля.
Проверь новую стратегию в методе main(). Запусти программу и сравни скорость работы
всех 4х стратегий. Убедись, что мы значительно увеличили скорость получения
идентификатора. Но как ты понимаешь, у этого решение есть не только плюсы, подумай в
каких случаях имеет смысл использовать OurHashBiMapStorageStrategy, а в каких
HashMapStorageStrategy.
 */