package com.javarush.test.level38.lesson04.task02;

/* Непроверяемые исключения (unchecked exception)
Напиши реализацию метода methodThrowsClassCastException(). Он должен
всегда кидать непроверяемое исключение ClassCastException.

Напиши реализацию метода methodThrowsNullPointerException(). Он должен
всегда кидать непроверяемое исключение NullPointerException.

Кинуть исключение (throw) явно нельзя.
*/

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        Object ch = new Character('*');
        System.out.println((Byte)ch);
        //напишите тут ваш код
    }

    public void methodThrowsNullPointerException() {
        int[] nNulArray = new int[5];
        nNulArray = null;
        int i = nNulArray.length;
        //напишите тут ваш код
    }
}
