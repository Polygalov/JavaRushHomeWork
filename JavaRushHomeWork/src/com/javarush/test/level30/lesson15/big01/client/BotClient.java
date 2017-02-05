package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by Andy on 31.07.2016.
 */
public class BotClient extends Client
{
    private static volatile Set<String> botNames = new HashSet<>();

    @Override
    protected SocketThread getSocketThread()
    {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSentTextFromConsole()
    {
        return false;
    }

    @Override
    protected String getUserName()
    {
        String botName;
        if (botNames.size() >= 100) throw new RuntimeException("Число ботов превысило допустимый предел");
        do
        {
            botName = String.format("date_bot_%02d", new Random().nextInt(100));
        }
        while (botNames.contains(botName));
        botNames.add(botName);
        return botName;
    }

    public static void main(String[] args)
    {
        BotClient botClient = new BotClient();
        botClient.run();
    }

    public class BotSocketThread extends SocketThread
    {
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException
        {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message)
        {
            ConsoleHelper.writeMessage(message);
            String[] messageParts = message.split(": ");
            if (messageParts.length == 2)
            {
                String messageAuthor = messageParts[0];
                String messageText = messageParts[1].toLowerCase();
                String dateTimeformat = null;
                switch (messageText)
                {
                    case "дата":
                        dateTimeformat = "d.MM.YYYY";
                        break;
                    case "день":
                        dateTimeformat = "d";
                        break;
                    case "месяц":
                        dateTimeformat = "MMMM";
                        break;
                    case "год":
                        dateTimeformat = "YYYY";
                        break;
                    case "время":
                        dateTimeformat = "H:mm:ss";
                        break;
                    case "час":
                        dateTimeformat = "H";
                        break;
                    case "минуты":
                        dateTimeformat = "m";
                        break;
                    case "секунды":
                        dateTimeformat = "s";
                        break;
                }
                if (dateTimeformat != null)
                {
                    String reply = String.format("Информация для %s: %s",
                            messageAuthor,
                            new SimpleDateFormat(dateTimeformat).format(Calendar.getInstance().getTime())
                    );
                    sendTextMessage(reply);
                }
            }
        }

    }
}

/*
Сегодня будем реализовывать класс BotSocketThread, вернее переопределять некоторые
его методы, весь основной функционал он уже унаследовал от SocketThread.
19.1.	Переопредели метод clientMainLoop():
19.1.1.	С помощью метода sendTextMessage() отправь сообщение с текстом
"Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды."
19.1.2.	Вызови реализацию clientMainLoop() родительского класса.
19.2.	Переопредели метод processIncomingMessage(String message). Он должен
следующим образом обрабатывать входящие сообщения:
19.2.1.	Вывести в консоль текст полученного сообщения message.
19.2.2.	Получить из message имя отправителя и текст сообщения. Они разделены ": ".
19.2.3.	Отправить ответ в зависимости от текста принятого сообщения. Если текст
сообщения:
"дата" – отправить сообщение содержащее текущую дату в формате "d.MM.YYYY";
"день" – в формате"d";
"месяц" - "MMMM";
"год" - "YYYY";
"время" - "H:mm:ss";
"час" - "H";
"минуты" - "m";
"секунды" - "s".
Указанный выше формат используй для создания объекта SimpleDateFormat. Для
получения текущей даты необходимо использовать класс Calendar и метод
getTime().
Ответ должен содержать имя клиента, который прислал запрос и ожидает ответ,
например, если Боб отправил запрос "время", мы должны отправить ответ
"Информация для Боб: 12:30:47".
Наш бот готов. Запусти сервер, запусти бота, обычного клиента и убедись, что все работает правильно.
Помни, что message бывают разных типов и не всегда содержат ":"
 */