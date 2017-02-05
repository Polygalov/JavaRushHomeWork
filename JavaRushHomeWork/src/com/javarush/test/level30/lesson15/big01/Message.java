package com.javarush.test.level30.lesson15.big01;

import java.io.Serializable;

/**
 * Created by Andy on 30.07.2016.
 */
public class Message implements Serializable
{
    private final MessageType type;
    private final String data;

    public MessageType getType()
    {
        return type;
    }

    public String getData()
    {
        return data;
    }

    public Message(MessageType type)
    {
        this.type = type;
        this.data = null;
    }

    public Message(MessageType type, String data)
    {
        this.type = type;
        this.data = data;
    }
}

/*
Добавь в класс Message:
4.1.	Поддержку интерфейса Serializable
4.2.	Final поле типа MessageType type, которое будет содержать тип сообщения
4.3.	Final поле типа String data, которое будет содержать данные сообщения
4.4.	Геттеры для этих полей
4.5.	Конструктор, принимающий только MessageType, он должен проинициализировать
поле type переданным параметром, а поле data с помощью null.
4.6.	Конструктор, принимающий MessageType type и String data. Он должен также
инициализировать все поля класса.
 */