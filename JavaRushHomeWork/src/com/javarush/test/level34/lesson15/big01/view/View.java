package com.javarush.test.level34.lesson15.big01.view;

import com.javarush.test.level34.lesson15.big01.controller.Controller;
import com.javarush.test.level34.lesson15.big01.controller.EventListener;
import com.javarush.test.level34.lesson15.big01.model.GameObjects;

import javax.swing.*;

public class View extends JFrame {
    private Controller controller;
    private Field field;

    public View(Controller controller) {
        this.controller = controller;
    }
    public void setEventListener(EventListener eventListener){
        this.field.setEventListener(eventListener);
    }
    public void update(){
       this.field.repaint();
    }
    public void init() {
        field = new Field(this);
        add(field);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1000, 1000);
        setLocationRelativeTo(null);
        setTitle("Сокобан");
        setVisible(true);
    }
    public void completed(int level){
        update();
        JOptionPane.showMessageDialog(null, level + "Completed", "Level", JOptionPane.INFORMATION_MESSAGE);
        controller.startNextLevel();
    }
    public GameObjects getGameObjects(){
        return controller.getGameObjects();
    }
}
/*
13.3.	Добавь в представление метод completed(int level), который будет сообщать
пользователю, что уровень level пройден. Метод должен:
13.3.1.	Обновлять представление.
13.3.2.	Показывать диалоговое окно с информацией о том, что пользователь прошел
какой-то уровень. Подсказка: используй JOptionPane.showMessageDialog.
13.3.3.	Просить контроллер запустить следующий уровень.
9.5.	Добавь в классы Model, View и Field по методу setEventListener(EventListener
eventListener). Этот метод в классе View должен вызвать аналогичный метод у объекта
field, а в классах Model и Field устанавливать значение внутренних полей eventListener.
	Попробуем организовать взаимодействие представления и модели.
12.1.	Добавь в класс View метод update(), он должен вызывать у игрового поля field
метод repaint(). Другими словами, метод update() будет обновлять представление
(перерисовывать поле).


 */