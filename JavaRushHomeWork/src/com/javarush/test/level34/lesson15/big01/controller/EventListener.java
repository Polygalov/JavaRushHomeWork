package com.javarush.test.level34.lesson15.big01.controller;

import com.javarush.test.level34.lesson15.big01.model.Direction;

/**
 * Created by Andy on 24.09.2016.
 */
public interface EventListener
{
    void move(Direction direction);
    void restart();
    void startNextLevel();
    void levelCompleted(int level);


}
/*
9.1.	Добавь интерфейс EventListener в пакет controller.
9.2.	Добавь в интерфейс методы:
9.2.1.	move(Direction direction) – передвинуть объект в определенном направлении.
9.2.2.	restart() – начать заново текущий уровень.
9.2.3.	startNextLevel() – начать следующий уровень.
9.2.4.	levelCompleted(int level) – уровень с номером level завершён.
9.3.	Добавь классу Controller интерфейс EventListener, напиши необходимые заглушки-
реализации интерфейса.
9.4.	Добавь в классы Model и Field по полю EventListener eventListener.
9.5.	Добавь в классы Model, View и Field по методу setEventListener(EventListener
eventListener). Этот метод в классе View должен вызвать аналогичный метод у объекта
field, а в классах Model и Field устанавливать значение внутренних полей eventListener.
 */