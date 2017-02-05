package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;


/**
 * Created by Andy on 26.06.2016.
 */
public class ConsoleHelper
{
    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "common_en");
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message)
    {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException {
        String result = "";

        try {
            result = reader.readLine();
            if (result.equalsIgnoreCase(res.getString("operation.EXIT"))) {
                throw new InterruptOperationException();
            }
        }
        catch (IOException ignored) {
        }

        return result;
    }
    public static void printExitMessage()
    {
        ConsoleHelper.writeMessage(res.getString("the.end"));
    }

    public static String askCurrencyCode() throws InterruptOperationException
    {
        String read;
        writeMessage(res.getString("choose.currency.code"));
        while (true)
        {

            read = readString();
            if (read.length() == 3)
            {

                break;
            } else
            {
                writeMessage(res.getString("invalid.data"));
            }
        }
        return read.toUpperCase();
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException
    {
        String[] array;
        writeMessage(String.format(res.getString("choose.denomination.and.count.format"), currencyCode));
        while (true)
        {
            String s = readString();
            array = s.split(" ");
            int k;
            int l;
            try
            {
                k = Integer.parseInt(array[0]);
                l = Integer.parseInt(array[1]);
            }
            catch (Exception e)
            {
                writeMessage(res.getString("invalid.data"));;
                continue;
            }
            if (k <= 0 || l <= 0 || array.length > 2)
            {
                writeMessage(res.getString("invalid.data"));
                continue;
            }
            break;
        }
        return array;
    }

    public static Operation askOperation() throws InterruptOperationException
    {   Operation result = null;
        while (true){
            writeMessage(res.getString("choose.operation"));
            try {
                result = Operation.getAllowableOperationByOrdinal(Integer.parseInt(readString()));
                break;
            } catch (Exception e) {writeMessage(res.getString("invalid.data"));}}
        return result;
    }
}
/*
1. Создадим в ConsoleHelper два статических метода:
1.1 writeMessage(String message), который будет писать в консоль наше сообщение
1.2 String readString(), который будет считывать с консоли строку и возвращать ее.
Если возникнет какое-то исключение при работе с консолью, то перехватим его и не будем обрабатывать.
Кстати, создадим только один экземпляр BufferedReader-а

2. Создадим пакет exception, в который поместим два checked исключения:
2.1 InterruptOperationException будем кидать, когда нужно прервать текущую операцию и выйти из приложения
2.2 NotEnoughMoneyException будем кидать, когда не сможем выдать запрашиваемую сумму

2. Чтобы считать код валюты, добавим статический метод String askCurrencyCode() в ConsoleHelper.
Этот метод должен предлагать пользователю ввести код валюты, проверять, что код содержит 3 символа.
Если данные некорректны, то сообщить об этом пользователю и повторить.
Если данные валидны, то перевести код в верхний регистр и вернуть.

3. Чтобы считать номинал и количество банкнот, добавим статический метод String[] getValidTwoDigits(String currencyCode) в ConsoleHelper.
Этот метод должен предлагать пользователю ввести два целых положительных числа.
Первое число - номинал, второе - количество банкнот.
Никаких валидаторов на номинал нет. Т.е. 1200 - это нормальный номинал.
Если данные некорректны, то сообщить об этом пользователю и повторить.
Пример вводимых данных:
200 5
2. В классе ConsoleHelper реализуйте логику статического метода Operation askOperation()
Спросить у пользователя операцию.
Если пользователь вводит 1, то выбирается команда INFO, 2 - DEPOSIT, 3 - WITHDRAW, 4 - EXIT;
Используйте метод, описанный в п.1.
Обработай исключение - запроси данные об операции повторно.
 */