package com.javarush.test.level33.lesson15.big01.strategies;

import com.google.common.collect.HashBiMap;

/**
 * Created by Andy on 18.09.2016.
 */
public class HashBiMapStorageStrategy implements StorageStrategy
{
    private HashBiMap<Long, String> data = HashBiMap.create();
    @Override
    public boolean containsKey(Long key)
    {
        return data.containsKey(key);
    }

    @Override
    public boolean containsValue(String value)
    {
        return data.containsValue(value);
    }

    @Override
    public void put(Long key, String value)
    {
        data.put(key,value);


    }

    @Override
    public Long getKey(String value)
    {

        return data.inverse().get(value);
    }

    @Override
    public String getValue(Long key)
    {
        return data.get(key);
    }
}

/*
12.1.	Скачай и подключи библиотеку guava версии 18.0.
12.2.	Реализуй стратегию HashBiMapStorageStrategy. Она должна:
12.2.1.	Иметь интерфейс StorageStrategy.
12.2.2.	Внутри иметь только одно поле data с типом HashBiMap.
12.3.	Проверь новую стратегию в методе main(). Запусти программу и сравни
скорость работы пяти стратегий.
 */