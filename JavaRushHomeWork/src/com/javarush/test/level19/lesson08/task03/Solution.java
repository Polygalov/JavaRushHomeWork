package com.javarush.test.level19.lesson08.task03;

/* Выводим только цифры
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить только цифры
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток
Вывести модифицированную строку в консоль.

Пример вывода:
12345678
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws Exception
    {
//запоминаем насто€щий PrintStream в специальную переменную
        PrintStream consoleStream = System.out;

//—оздаем динамический массив
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//создаем адаптер к классу PrintStream
        PrintStream stream = new PrintStream(outputStream);
//”станавливаем его как текущий System.out
        System.setOut(stream);

//¬ызываем функцию, котора€ ничего не знает о наших манипул€ци€х
        testString.printSomething();

//ѕреобразовываем записанные в наш ByteArray данные в строку
        String result = outputStream.toString();

//¬озвращаем все как было
        System.setOut(consoleStream);

//разворачиваем строку
        StringBuilder stringBuilder = new StringBuilder(result);
//stringBuilder.toUpperCase();
        String reverseString = stringBuilder.toString();
        String s="";
        Pattern pat=Pattern.compile("[0-9]");
        Matcher matcher=pat.matcher(reverseString);
        while (matcher.find()) {
            s+=matcher.group();
        }
//выводим ее в консоль
        System.out.println(s);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}
