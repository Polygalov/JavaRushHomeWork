package com.javarush.test.level33.lesson15.big01.strategies;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Andy on 16.09.2016.
 */
public class HashMapStorageStrategy implements StorageStrategy
{
    private HashMap<Long, String> data = new HashMap<>();
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
        data.put(key, value);
    }

    @Override
    public Long getKey(String value)
    {
        for (Map.Entry<Long, String> entry : data.entrySet()) {
            if (value.equals(entry.getValue()))
                return entry.getKey();
        }
        return null;
    }

    @Override
    public String getValue(Long key)
    {
        return data.get(key);
    }
}
/*
Давай напишем наше первое хранилище (стратегию хранилища). Внутри оно будет
содержать обычный HashMap. Все стратегии будем хранить в пакете strategies.
5.1.	Создай класс HashMapStorageStrategy, реализующий интерфейс StorageStrategy.
5.2.	Добавь в класс поле HashMap<Long, String> data. В нем будут храниться наши
данные.
5.3.	Реализуй в классе все необходимые методы. Реализации методов должны
использовать поле data. Дополнительные поля не создавать.
public boolean containsKey(Long key); //должен вернуть true, если хранилище  содержит переданный ключ.
    boolean containsValue(String value); // должен вернуть true, если хранилище  содержит переданное значение.
    void put(Long key, String value); // добавить в хранилище новую пару ключ – значение.
    Long getKey(String value); //вернуть ключ для переданного значения.
    String getValue(Long key); //вернуть значение для переданного ключа

 */