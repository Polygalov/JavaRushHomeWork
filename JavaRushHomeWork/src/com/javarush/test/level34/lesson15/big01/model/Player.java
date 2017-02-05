package com.javarush.test.level34.lesson15.big01.model;

import java.awt.*;

/**
 * Created by Andy on 24.09.2016.
 */
public class Player extends CollisionObject implements Movable
{
    public Player(int x, int y)
    {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics)
    {
        //graphics.drawOval(getX(), getY(), getWidth(), getHeight());
        graphics.setColor(Color.YELLOW);
        int leftUpperCornerX = getX() - getWidth() / 2;
        int leftUpperCornerY = getY() - getHeight() / 2;

        graphics.drawOval(leftUpperCornerX, leftUpperCornerY, getWidth(), getHeight());
        graphics.fillOval(leftUpperCornerX, leftUpperCornerY, getWidth(), getHeight());
    }

    @Override
    public void move(int x, int y)
    {
        this.setX(this.getX()+x);
        this.setY(this.getY()+y);

    }

}
/*
5.3.	Добавь в созданные классы конструкторы, принимающие int x и int y.
5.4.	В каждом из классов, реализуй метод, отвечающий за движение. Он должен смещать
координаты объектов (x и y) на переданные значения.
5.5.	В каждом из них, реализуй метод, отвечающий за отрисовку. Этот метод должен:
устанавливать какой-то цвет и рисовать какие-то примитивные фигуры. Проследи,
чтобы центр фигуры имел координаты x и y, а высота и ширина соответствовали
значениям полей height и width.
Подсказка: игрока можешь нарисовать желтым залитым кругом, а ящик – оранжевым
квадратом с прорисованными диагоналями. Это пример, ты можешь сам выбрать цвет
и вид каждого объекта, ты ограничен только методами доступными для Graphics и
своей фантазией.

Для того чтобы проверить как рисуется твой ящик или игрок, ты можешь создать
объект типа Box или Player в методе paint() класса Field и вызвать у объекта метод
draw(). Сделай это исключительно для проверки методов draw(), в дальнейшем метод
paint() мы реализуем иначе.
 */