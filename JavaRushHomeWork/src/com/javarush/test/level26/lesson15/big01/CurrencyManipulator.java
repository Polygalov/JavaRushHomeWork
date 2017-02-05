package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.*;

/**
 * Created by Andy on 26.06.2016.
 */
public class CurrencyManipulator
{
    private String currencyCode;
    private Map<Integer, Integer> denominations = new HashMap<Integer, Integer>();
    public boolean isAmountAvailable(int expectedAmount)
    {
        return expectedAmount <= getTotalAmount();
    }

    public String getCurrencyCode()
    {
        return currencyCode;
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException
    {
        int sum = expectedAmount;
        HashMap<Integer, Integer> temp = new HashMap<>();
        temp.putAll(denominations);
        ArrayList<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> pair : temp.entrySet())
            list.add(pair.getKey());

        Collections.sort(list);
        Collections.reverse(list);

        TreeMap<Integer, Integer> result = new TreeMap<>(new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                return o2.compareTo(o1);
            }
        });

        for (Integer aList : list) {
            int key = aList;
            int value = temp.get(key);
            while (true) {
                if (sum < key || value <= 0) {
                    temp.put(key, value);
                    break;
                }
                sum -= key;
                value--;

                if (result.containsKey(key))
                    result.put(key, result.get(key) + 1);
                else
                    result.put(key, 1);
            }
        }

        if (sum > 0)
            throw new NotEnoughMoneyException();
        else
        {
            for (Map.Entry<Integer, Integer> pair : result.entrySet())
                ConsoleHelper.writeMessage("\t" + pair.getKey() + " - " + pair.getValue());

            denominations.clear();
            denominations.putAll(temp);
            ConsoleHelper.writeMessage("Transaction was successful!");
        }
        return result;
    }

    public CurrencyManipulator(String currencyCode)
    {
        this.currencyCode = currencyCode;
    }
    public void addAmount(int denomination, int count){
        if (denominations.containsKey(denomination))
        {
            denominations.put(denomination, denominations.get(denomination)+count);
        }
        else
        denominations.put(denomination,count);
    }
    public int getTotalAmount(){
        int total =0;
        for (Map.Entry<Integer, Integer> pair : denominations.entrySet())
        {
            int key = pair.getKey();
            int value = pair.getValue();
            total+= (key * value);
        }
        return total;
    }
    public boolean hasMoney(){
        return denominations.size() != 0;
    }
}
/*
1. Создадим класс CurrencyManipulator, который будет хранить всю информацию про выбранную валюту.
String currencyCode - код валюты, например, USD. Состоит из трех букв
Map<Integer, Integer> denominations - это Map<номинал, количество>
Чтобы можно было посмотреть, к какой валюте относится манипулятор, добавим геттер для currencyCode
Очевидно, что манипулятор никак не может функционировать без названия валюты,
поэтому добавим конструктор с этим параметром и проинициализируем currencyCode

4. В классе CurrencyManipulator создайте метод void addAmount(int denomination, int count),
который добавит введенные номинал и количество банкнот
addAmount: инициализируем мар, проверяем есть ли номинал в мар, если да то прибавляем к ключу count, если нет, то просто добавляем.

1.В предыдущем таске мы реализовали основную логику операции DEPOSIT.
Но посмотреть результат так и не удалось.
Поэтому создадим в манипуляторе метод int getTotalAmount(), который посчитает общую сумму денег для выбранной валюты.
 */