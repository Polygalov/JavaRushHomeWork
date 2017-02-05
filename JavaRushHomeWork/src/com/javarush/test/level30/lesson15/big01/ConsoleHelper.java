package com.javarush.test.level30.lesson15.big01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Andy on 30.07.2016.
 */
public class ConsoleHelper
{
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString(){
        String stroka=null;
        while (true)
        {
            try
            {
                stroka = reader.readLine();
                break;
            }
            catch (IOException e)
            {
                System.out.println("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
            }
        }
        return stroka;
    }
    public static int readInt(){
        int num=0;
        while (true)
        {
            try
            {
                num = Integer.parseInt(readString());
                break;
            }
            catch (NumberFormatException e)
            {
                System.out.println("Произошла ошибка при попытке ввода числа. Попробуйте еще раз.");
            }
        }
        return num;
    }
}

/*
	Первым делом, для удобства работы с консолью реализуем класс ConsoleHelper. В
дальнейшем, вся работа с консолью должна происходить через этот класс.
Добавь в него:
2.1.	Статическое поле типа BufferedReader, проинициализируй его с помощью System.in
2.2.	Добавь статический метод writeMessage(String message), который должен выводить
сообщение message в консоль
2.3.	Добавь статический метод String readString(), который должен считывать строку с
консоли. Если во время чтения произошло исключение, вывести пользователю
сообщение "Произошла ошибка при попытке ввода текста. Попробуйте еще раз." И
повторить ввод. Метод не должен пробрасывать исключения IOException наружу.
2.4.	Добавь статический метод int readInt(). Он должен возвращать введенное число и
использовать метод readString(). Внутри метода обработать исключение
NumberFormatException. Если оно произошло вывести сообщение "Произошла ошибка
при попытке ввода числа. Попробуйте еще раз." И повторить ввод числа.
В этой задаче и далее, если не указано дополнительно другого, то все поля класса должны
быть приватными, а методы публичными.
 */