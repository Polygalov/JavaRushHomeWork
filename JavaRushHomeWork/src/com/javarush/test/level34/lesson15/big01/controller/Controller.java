package com.javarush.test.level34.lesson15.big01.controller;

import com.javarush.test.level34.lesson15.big01.model.Direction;
import com.javarush.test.level34.lesson15.big01.model.GameObjects;
import com.javarush.test.level34.lesson15.big01.model.Model;
import com.javarush.test.level34.lesson15.big01.view.View;

/**
 * Created by Andy on 23.09.2016.
 */
public class Controller implements EventListener
{
    private View view;
    private Model model;
    public Controller()
    {
        view = new View(this);
        model = new Model();
        view.init();
        model.restart();
        model.setEventListener(this);
        view.setEventListener(this);
    }

    public static void main(String[] args)
    {
        Controller controller = new Controller();
    }

    @Override
    public void move(Direction direction)
    {
        model.move(direction);
        view.update();
    }

    @Override
    public void restart()
    {
        model.restart();
        view.update();
    }

    @Override
    public void startNextLevel()
    {
        model.startNextLevel();
        view.update();
    }

    @Override
    public void levelCompleted(int level)
    {
        view.completed(level);
    }
    public GameObjects getGameObjects(){
    return model.getGameObjects();
    }

}
/*
13.1.	Добавь в конструктор класса Controller к тому, что уже есть еще и:
13.1.1.	Перезапуск модели.
13.1.2.	Установку слушателя событий у модели и представления. Слушателем должен
быть сам контроллер.
13.2.	Реализуй методы контроллера:
13.2.1.	move(Direction direction) – должен вызывать move(Direction direction) у модели
и update() у представления. Метода move() у модели еще нет, добавь для него
заглушку, мы его реализуем позже.
13.2.2.	restart() – должен перезапускать модель и обновлять представление.
13.2.3.	startNextLevel() – должен запускать у модели новый уровень и обновлять
представление.
13.3.	Добавь в представление метод completed(int level), который будет сообщать
пользователю, что уровень level пройден. Метод должен:
13.3.1.	Обновлять представление.
13.3.2.	Показывать диалоговое окно с информацией о том, что пользователь прошел
какой-то уровень. Подсказка: используй JOptionPane.showMessageDialog.
13.3.3.	Просить контроллер запустить следующий уровень.
13.4.	Реализуй в контроллере метод levelCompleted(int level), он должен вызвать
метод completed() у представления.     ***
3.3.	Добавь в конструктор класса контроллера вызов метода init() представления.
3.4.	Добавь в класс Controller метод main(), он должен создавать новый объект
контроллера.
9.3.	Добавь классу Controller интерфейс EventListener, напиши необходимые заглушки-
реализации интерфейса.
9.4.	Добавь в классы Model и Field по полю EventListener eventListener.
9.5.	Добавь в классы Model, View и Field по методу setEventListener(EventListener
eventListener). Этот метод в классе View должен вызвать аналогичный метод у объекта
field, а в классах Model и Field устанавливать значение внутренних полей eventListener.
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