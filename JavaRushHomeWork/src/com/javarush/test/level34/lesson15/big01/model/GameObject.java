package com.javarush.test.level34.lesson15.big01.model;

import java.awt.*;

/**
 * Created by Andy on 23.09.2016.
 */
public abstract class GameObject
{
    private int x;
    private int y;
    private int width;
    private int height;  //позиция и размер объекта для отрисовки.

    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public int getY()
    {
        return y;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public int getWidth()
    {
        return width;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public GameObject(int x, int y)
    {
        this.x = x;
        this.y = y;
        width = Model.FIELD_SELL_SIZE;
        height = Model.FIELD_SELL_SIZE;
    }

    public GameObject(int x, int y, int width, int height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    public abstract void draw(Graphics graphics);
}
/*
2.1.	Добавь абстрактный класс GameObject в пакет model.
2.2.	Добавь в класс GameObject поля: int x, int y, int width и int height. Это будет позиция и
размер объекта для отрисовки.
2.3.	Добавь сеттеры и геттеры для полей класса.
2.4.	Добавь в класс Model публичную статическую константу int FIELD_SELL_SIZE = 20, это
будет размер ячейки игрового поля. Все игровые объекты будут занимать одну ячейку
игрового поля. Именно этот размер будет участвовать в расчёте движения и
столкновений объектов. Размер, который будет храниться внутри объекта, будет
использоваться только при его отрисовке.
2.5.	Добавь в класс GameObject два конструктора:
2.5.1.	GameObject(int x, int y)
2.5.2.	GameObject(int x, int y, int width, int height)
Конструкторы должны инициализировать все поля класса. Если width и height не переданы,
используй FIELD_SELL_SIZE в качестве ширины и высоты.
2.6.	Добавь абстрактный метод void draw(Graphics graphics) в класс GameObject. Этот метод
будет реализован в каждом типе игровых объектов по-своему. Другими словами,
каждый тип игровых объектов будет знать, как он должен рисоваться и будет сам себя
рисовать в графический контекст graphics. Graphics – это абстрактный класс из
библиотеки java.awt.
 */