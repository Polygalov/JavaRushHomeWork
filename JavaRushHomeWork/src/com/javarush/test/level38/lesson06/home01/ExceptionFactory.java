package com.javarush.test.level38.lesson06.home01;

/**
 * Created by Andy on 17.10.2016.
 */
public class ExceptionFactory
{
    public static Throwable getException(Enum message)
    {
        if (message != null)
        {
            String name = message.name().replace("_", " ").toLowerCase();
            String s1 = name.substring(0, 1).toUpperCase();
            String nameCapitalized = s1 + name.substring(1);
            if (message instanceof ExceptionApplicationMessage)
                return new Exception(nameCapitalized);
            if (message instanceof ExceptionDBMessage)
                return new RuntimeException(nameCapitalized);
            if (message instanceof ExceptionUserMessage)
                return new Error(nameCapitalized);


        }
                return new IllegalArgumentException();
        }
    }


/*


Создайте класс - фабрику исключений, который содержит один статический метод, возвращающий нужное исключение.
Этот метод должен принимать один параметр - энум.
Если передан энум:
* ExceptionApplicationMessage, верните исключение Exception
* ExceptionDBMessage, верните исключение RuntimeException
* ExceptionUserMessage, верните Error
иначе верните IllegalArgumentException без сообщения.

В качестве сообщения (message) для каждого возвращаемого объекта используйте элементы энума, в которых все знаки
подчеркивания замените на пробелы. Сообщение должно быть в нижнем регистре за исключением первого символа.
Например, сообщение для ExceptionApplicationMessage.SOCKET_IS_CLOSED - "Socket is closed".

Верните класс созданной фабрики в методе Solution.getFactoryClass.

Энумы не меняйте.
 */