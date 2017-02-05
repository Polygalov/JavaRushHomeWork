package com.javarush.test.level27.lesson06.task01;

/* Убираем deadLock
Используя стратегию избегания deadLock-а сделайте так, чтобы он не возник.
Метод main не участвует в тестировании.
Действуйте аналогично примеру из лекций.
Изменения вносите только в safeMethod.
*/
public class Solution {
    public void safeMethod(Object obj1, Object obj2) {

        int lock1 = obj1.hashCode();
        int lock2 = obj2.hashCode();
        Object firstLock = lock1 > lock2 ? obj1 : obj2;
        Object secondLock = lock1 > lock2 ? obj2 : obj1;
        synchronized (firstLock) {
            longTimeMethod();
            synchronized (secondLock) {
                unsafeMethod(obj1, obj2);
            }
        }
    }

    public void longTimeMethod() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException ignored) {
        }
    }

    protected void unsafeMethod(Object obj1, Object obj2) {
        System.out.println(obj1 + " " + obj2);
    }

    public static void main(String[] args) {
        final Object o1 = new Object();
        final Object o2 = new Object();
        final Solution solution = new Solution();

        new Thread(){
            @Override
            public void run() {
                solution.safeMethod(o1, o2);
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                solution.safeMethod(o2, o1);
            }
        }.start();
    }
}
