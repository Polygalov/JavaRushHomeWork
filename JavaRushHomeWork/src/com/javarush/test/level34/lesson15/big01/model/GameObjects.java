package com.javarush.test.level34.lesson15.big01.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Andy on 24.09.2016.
 */
public class GameObjects
{
    private Set<Wall> walls;
    private Set<Box> boxes;
    private Set<Home> homes;
    private Player player;

    public Set<Wall> getWalls()
    {
        return walls;
    }

    public Set<Box> getBoxes()
    {
        return boxes;
    }

    public Set<Home> getHomes()
    {
        return homes;
    }

    public Player getPlayer()
    {
        return player;
    }

    public GameObjects(Set<Wall> walls, Set<Box> boxes, Set<Home> homes, Player player)
    {
        this.walls = walls;
        this.boxes = boxes;
        this.homes = homes;
        this.player = player;
    }
    public Set<GameObject> getAll(){
        Set<GameObject> getAll = new HashSet<>();
        getAll.addAll(getWalls());
        getAll.addAll(getBoxes());
        getAll.addAll(getHomes());
        getAll.add(getPlayer());
        return getAll;
}

}
/*
	Ты создал полную коллекцию типов игровых объектов. Давай создадим класс, который
будет хранить эти объекты.
8.1.	Создай класс GameObjects в пакте model.
8.2.	Добавь в него:
8.2.1.	Поля Set<Wall> walls, Set<Box> boxes, Set<Home> homes и Player player.
8.2.2.	Геттеры для этих полей.
8.2.3.	Конструктор класса, принимающий Set<Wall> walls, Set<Box> boxes, Set<Home>
homes, Player player и инициализирующий поля класса.
8.2.4.	Метод Set<GameObject> getAll(). Он должен возвращать множество, содержащее
все объекты, хранящиеся внутри класса.
12.2.	Добавь в класс контроллера метод GameObjects getGameObjects(), он должен
запросить игровые объекты у модели и вернуть их. Добавь такой же метод и в класс
представления, он должен получать объекты у контроллера.
12.3.	Правильно реализуй в классе Field метод paint(Graphics g). Он должен:
12.3.1.	Залить все поле каким-то цветом, например, черным (вызови методы setColor и
fillRect с правильными параметрами).
12.3.2.	Получить у представления все игровые объекты.
12.3.3.	Отрисовать все игровые объекты.

Запусти программу и проверь, что все игровые объекты рисуются правильно.
 */