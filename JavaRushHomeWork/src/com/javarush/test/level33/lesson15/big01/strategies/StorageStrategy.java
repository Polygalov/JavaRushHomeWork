package com.javarush.test.level33.lesson15.big01.strategies;

/**
 * Created by Andy on 16.09.2016.
 */
public interface StorageStrategy
{
    public boolean containsKey(Long key); //должен вернуть true, если хранилище  содержит переданный ключ.
    boolean containsValue(String value); // должен вернуть true, если хранилище  содержит переданное значение.
    void put(Long key, String value); // добавить в хранилище новую пару ключ – значение.
    Long getKey(String value); //вернуть ключ для переданного значения.
    String getValue(Long key); //вернуть значение для переданного ключа
}
/*
2.1.	Добавь интерфейс StorageStrategy в пакет strategies.
2.2.	Добавь в интерфейс следующие методы:
2.2.1.	boolean containsKey(Long key) – должен вернуть true, если хранилище
содержит переданный ключ.
2.2.2.	boolean containsValue(String value) - должен вернуть true, если хранилище
содержит переданное значение.
2.2.3.	void put(Long key, String value) – добавить в хранилище новую пару ключ –
значение.
2.2.4.	Long getKey(String value) – вернуть ключ для переданного значения.
2.2.5.	String getValue(Long key) – вернуть значение для переданного ключа.
 */