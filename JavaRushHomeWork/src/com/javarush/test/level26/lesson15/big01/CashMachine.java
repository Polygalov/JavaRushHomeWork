package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.command.CommandExecutor;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.Locale;

/**
 * Created by Andy on 26.06.2016.
 */
public class CashMachine
{
    public static final String RESOURCE_PATH = "com.javarush.test.level26.lesson15.big01.resources.";
    public static void main(String[] args)
    {
        Locale.setDefault(Locale.ENGLISH);
        try
        {
            CommandExecutor.execute(Operation.LOGIN);
            Operation operation;
            do
            {
                operation = ConsoleHelper.askOperation();
                CommandExecutor.execute(operation);
            }while (operation != Operation.EXIT);
        }catch (InterruptOperationException e){
            ConsoleHelper.writeMessage("Good Bye!");
        }
        ConsoleHelper.printExitMessage();
    }
}
/*
2. Добавим вызов метода getTotalAmount() в метод main.
Всё работает верно? Тогда движемся дальше.
Видно, что метод getTotalAmount() считает то, что нам необходимо для операции INFO.
Поэтому пришло время небольшого рефакторинга.
!!Читайте паттерн Command.
Однако, перед рефакторингом нужно еще разобраться в одном вопросе. Но об этом не сейчас.
 Заверните тело метода main в try-catch и обработайте исключение InterruptOperationException.
Попрощайтесь с пользователем в блоке catch используя ConsoleHelper.


 */