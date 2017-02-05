package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.Operation;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by Andy on 27.06.2016.
 */
public class CommandExecutor
{
    private static Map<Operation, Command> map = new HashMap<>();
    static {
        map.put(Operation.LOGIN, new LoginCommand());
        map.put (Operation.INFO, new InfoCommand() );
        map.put (Operation.DEPOSIT, new DepositCommand());
        map.put ( Operation.WITHDRAW, new WithdrawCommand());
        map.put ( Operation.EXIT, new ExitCommand());
    }
    private CommandExecutor()
    {
    }
    public static final void execute(Operation operation) throws InterruptOperationException
    {
    map.get(operation).execute();
    }

}
/*
4.1 Создадим метод public static final void execute(Operation operation), который будет дергать метод execute у нужной команды.
Реализуйте эту логику.
4.2. Расставьте правильно модификаторы доступа учитывая, что единственная точка входа - это метод execute.

Проверяем, чтоб структура соответствовала тестам на сервере.
Логику будем переносить в следующем таске.
 */