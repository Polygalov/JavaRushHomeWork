package com.javarush.test.level34.lesson15.big01.model;

/**
 * Created by Andy on 24.09.2016.
 */
public abstract class CollisionObject extends GameObject
{
    public CollisionObject(int x, int y)
    {
        super(x, y);
    }
    public boolean isCollision(GameObject gameObject, Direction direction){
        boolean result = false;
        switch (direction)
        {
            case RIGHT:
                if(getX() + Model.FIELD_SELL_SIZE == gameObject.getX() && getY() == gameObject.getY())
                    result = true;
                break;
            case LEFT:
                if(getX() - Model.FIELD_SELL_SIZE == gameObject.getX() && getY() == gameObject.getY())
                    result = true;
                break;
            case UP:
                if(getX() == gameObject.getX() && getY() - Model.FIELD_SELL_SIZE == gameObject.getY())
                    result = true;
                break;
            case DOWN:
                if(getX() == gameObject.getX() && getY() + Model.FIELD_SELL_SIZE == gameObject.getY())
                    result = true;
                break;
        }
        return result;
    }
}
/*
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