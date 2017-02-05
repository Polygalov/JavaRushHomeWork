package com.javarush.test.level32.lesson15.big01.listeners;

import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

/**
 * Created by Andy on 08.09.2016.
 */
public class UndoListener implements UndoableEditListener
{
    private UndoManager undoManager;

    public UndoListener(UndoManager undoManager)
    {
        this.undoManager = undoManager;
    }

    @Override
    public void undoableEditHappened(UndoableEditEvent e)
    {
        undoManager.addEdit(e.getEdit());
    }
}
/*
11.1.	Добавь в представление поле UndoManager undoManager. Разберись для чего
используется этот класс. Проинициализируй поле класса новым объектом.
11.2.	Добавь класс UndoListener реализующий интерфейс UndoableEditListener в пакет
listeners. Этот класс будет следить за правками, которые можно отменить или вернуть.
11.3.	Добавь в класс UndoListener:
11.3.1.	Поле UndoManager undoManager.
11.3.2.	Конструктор, который принимает UndoManager и инициализирует поле класса.
11.3.3.	Метод undoableEditHappened(UndoableEditEvent e). Он должен из переданного
события получать правку и добавлять ее в undoManager.
11.4.	Добавь в представление поле UndoListener undoListener, проинициализируй его
используя undoManager.
11.5.	Добавь в представление методы:
11.5.1.	void undo() - отменяет последнее действие. Реализуй его используя undoManager.
Метод не должен кидать исключений, логируй их.
11.5.2.	void redo() - возвращает ранее отмененное действие. Реализуй его по аналогии с
предыдущим пунктом.
11.5.3.	Реализуй методы boolean canUndo() и boolean canRedo() используя undoManager.
11.5.4.	Реализуй геттер для undoListener.
11.5.5.	Добавь и реализуй метод void resetUndo(), который должен сбрасывать все правки в
менеджере undoManager.
 */