package com.javarush.test.level34.lesson15.big01.model;

/**
 * Created by Andy on 24.09.2016.
 */
public interface Movable
{
    void move(int x, int y);
}
/*
4.1.1.	Добавь интерфейс Movable в пакет model.
4.1.2.	Интерфейс Movable должен иметь метод void move(int x, int y).
4.2.	Добавь enum Direction в пакет model. Он должен содержать следующие значения:
LEFT, RIGHT, UP и DOWN. Этот тип будет использоваться для описания направления
движения объектов.
4.3.	Игровые объекты типа “дом” не поддерживают логики столкновений (игрок или
ящики могут свободно передвигаться по ним). Что касается остальных объектов, то
они не должны проходить свозь друг друга, они должны сталкиваться. Например,
ящик нельзя протолкнуть сквозь стену.
4.3.1.	Добавь абстрактный класс CollisionObject в пакет model.
4.3.2.	Класс CollisionObject должен быть унаследован от GameObject.
4.3.3.	Добавь в класс CollisionObject:
4.3.3.1.	Конструктор, принимающий int x и int y.
4.3.3.2.	Метод boolean isCollision(GameObject gameObject, Direction direction).
Этот метод должен возвращаться true, если при перемещении текущего
объекта в направлении direction на FIELD_SELL_SIZE произойдет
столкновение с объектом gameObject, переданным в качестве параметра.
Иначе – возвращать false. Столкновением считать совпадение координат x и y.
 */