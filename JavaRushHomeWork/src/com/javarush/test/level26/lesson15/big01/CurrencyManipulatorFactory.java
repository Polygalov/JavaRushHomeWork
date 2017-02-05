package com.javarush.test.level26.lesson15.big01;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Andy on 26.06.2016.
 */
public final class CurrencyManipulatorFactory
{
    static HashMap<String, CurrencyManipulator> map = new HashMap<>();
    static boolean isExist = false;

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode)
    {
        isExist = false;
        CurrencyManipulator current;

        if (map.containsKey(currencyCode))
            return map.get(currencyCode);
        else {
            current = new CurrencyManipulator(currencyCode);
            map.put(currencyCode, current);
            return current;
        }
    }

    private CurrencyManipulatorFactory()
    {
    }

    public static Collection<CurrencyManipulator> getAllCurrencyManipulators()
    {
        return map.values();
    }



}
/*
 Валют может быть несколько, поэтому нам понадобится фабрика, которая будет создавать и хранить манипуляторы.
Создадим класс CurrencyManipulatorFactory со статическим методом getManipulatorByCurrencyCode(String currencyCode).
В этом методе будем создавать нужный манипулятор, если он еще не существует, либо возвращать ранее созданный.
Подумайте, где лучше хранить все манипуляторы.
Сделайте так, чтобы невозможно было создавать объекты CurrencyManipulatorFactory класса
 */