package com.javarush.test.level19.lesson08.task05;

/* Дублируем текст
Считайте с консоли имя файла
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна дублировать вывод всего текста в файл, имя которого вы считали
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток
Закройте поток файла

Пример вывода на экран:
it's a text for testing

Пример тела файла:
it's a text for testing
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException
    {

        //запоминаем настоящий PrintStream в специальную переменную
        PrintStream consoleStream = System.out;

        //Создаем динамический массив
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        //создаем адаптер к классу PrintStream
        PrintStream stream = new PrintStream(outputStream);
        //Устанавливаем его как текущий System.out
        System.setOut(stream);

        //Вызываем функцию, которая ничего не знает о наших манипуляциях
        testString.printSomething();

        //Преобразовываем записанные в наш ByteArray данные в строку
        String result = outputStream.toString();

        //Возвращаем все как было
        System.setOut(consoleStream);

        //разворачиваем строку
        StringBuilder stringBuilder = new StringBuilder(result);
        //stringBuilder.toUpperCase();
        String reverseString = stringBuilder.toString();

        //выводим ее в консоль
        System.out.println(reverseString);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //создаем объект FileInputStream, привязанный к файлу «c:/a.txt».
        String name1 = br.readLine();
        char buffer[]= new char[reverseString.length()];
        reverseString.getChars(0, reverseString.length(), buffer, 0) ;
        FileWriter fl= new FileWriter(name1);
        fl.write(buffer);
        br.close();
        fl.close();
    }


    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

