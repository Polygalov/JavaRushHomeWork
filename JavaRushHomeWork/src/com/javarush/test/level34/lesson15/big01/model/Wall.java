package com.javarush.test.level34.lesson15.big01.model;

import java.awt.*;

/**
 * Created by Andy on 24.09.2016.
 */
public class Wall extends CollisionObject
{
    public Wall(int x, int y)
    {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics)
    {
        graphics.setColor(Color.DARK_GRAY);
        int leftUpperCornerX = getX() - getWidth() / 2;
        int leftUpperCornerY = getY() - getHeight() / 2;

        graphics.drawRect(leftUpperCornerX, leftUpperCornerY, getWidth(), getHeight());
        graphics.fillRect(leftUpperCornerX, leftUpperCornerY, getWidth(), getHeight());
    }
}
/*
	Давай сделаем класс стены Wall. Стена может сталкиваться с другими объектами, но не
может двигаться.
7.1.	Добавь класс Wall в пакет model.
7.2.	Унаследуй класс от подходящего родителя.
7.3.	Добавь конструктор с параметрами int x и int y.
7.4.	Реализуй метод отрисовки.
Подсказка: стену можно нарисовать залитым квадратом коричневого цвета, но тебя
никто не ограничивает, прояви свою творческую суть по полной.
 */