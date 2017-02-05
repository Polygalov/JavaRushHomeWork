package com.javarush.test.level32.lesson15.big01.listeners;



import com.javarush.test.level32.lesson15.big01.View;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Created by Andy on 06.09.2016.
 */
public class TabbedPaneChangeListener implements ChangeListener
{
    private View view;

    public TabbedPaneChangeListener(View view)
    {
        this.view = view;
    }

    @Override
    public void stateChanged(ChangeEvent e)
    {
        view.selectedTabChanged();
    }
}

/*
5.1.	Объяви класс TabbedPaneChangeListener реализующий интерфейс ChangeListener в пакете
listeners. Этот класс будет слушать и обрабатывать изменения состояния панели вкладок.
Реализуй в этом классе:
5.1.1.	Конструктор, принимающий представление в виде параметра и сохраняющий во
внутреннее поле класса.
5.1.2.	Переопредели метод из интерфейса ChangeListener, он должен вызывать метод
selectedTabChanged() у представления. Последнего метода еще нет, сделай для него
заглушку.
5.2.	Объяви класс ExceptionHandler. Это будет наш обработчик исключительных ситуаций,
который ты в дальнейшем сможешь переопределить. Пока добавь в него статический метод
log(Exception e), который будет выводить в консоль краткое описание проблемы
(используй метод toString у переданного исключения).
 */