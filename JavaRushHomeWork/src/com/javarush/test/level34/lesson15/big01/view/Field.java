package com.javarush.test.level34.lesson15.big01.view;

import com.javarush.test.level34.lesson15.big01.controller.EventListener;
import com.javarush.test.level34.lesson15.big01.model.Direction;
import com.javarush.test.level34.lesson15.big01.model.GameObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Set;

/**
 * Created by Andy on 23.09.2016.
 */
public class Field extends JPanel
{
    private View view;
    private EventListener eventListener;

    public Field(View view)
    {
        this.view = view;
        KeyHandler keyHandler = new KeyHandler();
        this.addKeyListener(keyHandler);
        this.setFocusable(true);

    }
   public void paint(Graphics g)
   {
       g.setColor(Color.BLACK);
       g.fillRect(getX(), getY(), getWidth(), getHeight());
       Set<GameObject> spisok = view.getGameObjects().getAll();
       for (GameObject obj : spisok)
       {
           obj.draw(g);
       }
   }
    public void setEventListener(EventListener eventListener){
        this.eventListener = eventListener;

        }

   public class KeyHandler extends KeyAdapter{
       @Override
       public void keyPressed(KeyEvent e)
       {
           int key = e.getKeyCode();

           if (key == KeyEvent.VK_LEFT) {
               eventListener.move(Direction.LEFT);
           }

           if (key == KeyEvent.VK_RIGHT) {
               eventListener.move(Direction.RIGHT);
           }

           if (key == KeyEvent.VK_UP) {
               eventListener.move(Direction.UP);
           }

           if (key == KeyEvent.VK_DOWN) {
               eventListener.move(Direction.DOWN);
           }
           if (key == KeyEvent.VK_R) {
               eventListener.restart();
           }
       }
   }
    }

/*
14.1.	Добавь в класс Field вложенный класс KeyHandler унаследованный от
KeyAdapter.
14.2.	Перегрузи у него метод keyPressed(). Если была нажата клавиша с кодом
VK_LEFT, то пошли eventListener-у событие move с параметром Direction.LEFT.
Аналогичным образом обработай нажатия клавиш с кодом VK_RIGHT, VK_UP и
VK_DOWN. Если пользователь нажал клавишу R с кодом VK_R, то вызови у слушателя
событий метод restart().
14.3.	В конструкторе класса Field:
14.3.1.	Создай объект класса KeyHandler.
14.3.2.	Установи его слушателем с помощью метода addKeyListener().
14.3.3.	Установи focusable в true (метод setFocusable()).
3.1.	Добавь в пакет view класс Field, унаследованный от JPanel.
3.2.	Добавь в класс Field:
3.2.1.	Конструктор с параметром View view.
3.2.2.	Поле View view, которое должно инициализироваться в конструкторе.
3.2.3.	Создай заглушку для метода paint(Graphics g), она пока ничего не будет делать.
3.3.	Добавь в конструктор класса контроллера вызов метода init() представления.
3.4.	Добавь в класс Controller метод main(), он должен создавать новый объект
контроллера.
9.5.	Добавь в классы Model, View и Field по методу setEventListener(EventListener
eventListener). Этот метод в классе View должен вызвать аналогичный метод у объекта
field, а в классах Model и Field устанавливать значение внутренних полей eventListener.
12.3.	Правильно реализуй в классе Field метод paint(Graphics g). Он должен:
12.3.1.	Залить все поле каким-то цветом, например, черным (вызови методы setColor и
fillRect с правильными параметрами).
12.3.2.	Получить у представления все игровые объекты.
12.3.3.	Отрисовать все игровые объекты.

Запусти программу и проверь, что все игровые объекты рисуются правильно.

 */