package com.javarush.test.level22.lesson18.big01;

/**
 * Created by Andy on 29.05.2016.
 */
public class Figure
{
    int x;
    int y;
    int[][] matrix;

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public int[][] getMatrix()
    {
        return matrix;
    }

    public Figure(int x, int y, int[][] matrix)
    {
        this.x = x;
        this.y = y;
        this.matrix = matrix;
    }
    public void left(){

    }
    public void right(){

    }
    public void down(){

    }
    public void up(){

    }

    public void downMaximum(){

    }
    public void rotate(){

    }
    public boolean isCurrentPositionAvailable(){
return true;
    }
    public void landed(){

    }
}

/*
Так же нам понадобятся методы для управления фигуркой.
Добавь в класс Figure методы:
left() - для движения фигурки влево.
right() - для движения фигурки вправо.
down() - для движения фигурки вниз.
up() - для движения фигурки вверх.
downMaximum() - падение фигурки в низ до дна.
rotate() - для поворота фигурки вокруг главной диагонали.
boolean isCurrentPositionAvailable() - проверка - может ли фигурка быть помещена в текущую позицию. Для теста захардкодь результат в true.
landed() - вызывается, когда фигурка достигла дна или уперлась в другую фигурку
Все ее занятые клетки теперь должны добавиться в Field.

 */