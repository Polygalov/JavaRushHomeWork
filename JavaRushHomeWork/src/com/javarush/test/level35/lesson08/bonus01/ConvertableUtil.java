package com.javarush.test.level35.lesson08.bonus01;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertableUtil {

    public static Map convert(List<? extends Convertable> list) {
        Map<Object, Convertable<?>> result = new HashMap();
        for (Convertable<?> key: list){
            result.put(key.getKey(), key);
        }
        return result;
    }
}
/*
Реализуйте логику метода convert в классе ConvertableUtil, который должен возвращать словарь,
значениями которого являются элементы переданного Списка,
а ключами являются объекты, полученные вызовом интерфейсного метода getKey.

Элементы Списка должны наследоваться от Convertable, который в свою очередь параметризирован каким-то ключом.
Например, ConvertableBook параметризирован String, т.е. ключ в результирующем словаре должен иметь тип - String
ConvertableUser параметризирован Integer, т.е. ключ в результирующем словаре должен иметь тип - Integer

Значения в словаре должны совпадать с элементами Списка.
Смотрите метод main для примера.
 */