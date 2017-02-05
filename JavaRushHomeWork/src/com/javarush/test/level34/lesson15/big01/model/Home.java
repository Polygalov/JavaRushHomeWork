package com.javarush.test.level34.lesson15.big01.model;

import java.awt.*;

/**
 * Created by Andy on 24.09.2016.
 */
public class Home extends GameObject
{
    public Home(int x, int y)
    {
        super(x, y);
        setWidth(2);
        setHeight(2);
    }

    @Override
    public void draw(Graphics graphics)
    {
        graphics.setColor(Color.RED);
        int leftUpperCornerX = getX() - getWidth() / 2;
        int leftUpperCornerY = getY() - getHeight() / 2;

        graphics.drawOval(leftUpperCornerX, leftUpperCornerY, getWidth(), getHeight());

    }
}
/*
6.1.	Добавь в пакет model класс Home.
6.2.	Класс должен быть унаследован от максимально подходящего базового класса.
6.3.	Добавь в созданный класс конструктор, принимающий int x и int y. Высота и ширина
дома должна быть равна 2.
6.4.	Реализуй метод отрисовки дома. Подсказка: можешь использовать красный цвет и
прозрачный круг.

Как и с предыдущими игровыми объектами, можешь проверить метод отрисовки в методе
paint() класса Field.
 */