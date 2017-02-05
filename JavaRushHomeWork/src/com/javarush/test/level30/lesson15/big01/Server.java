package com.javarush.test.level30.lesson15.big01;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Andy on 30.07.2016.
 */
public class Server
{
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<String, Connection>();
    public static void sendBroadcastMessage(Message message)
    {
        for (String clientName : connectionMap.keySet()) {
            try {
                connectionMap.get(clientName).send(message);

            }
            catch (IOException e)
            {
                ConsoleHelper.writeMessage("Ошибка отправки сообщения");
            }
        }
    }
    private static class Handler extends Thread
    {
        private Socket socket;

        public Handler(Socket socket)
        {
            this.socket = socket;
        }
        public void run(){
            ConsoleHelper.writeMessage("Установлено новое соединение с удаленным адресом: " + socket.getRemoteSocketAddress());
            Connection connection = null;
            String clientName = null;
            try {
                connection = new Connection(socket);
                clientName =serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, clientName));
                sendListOfUsers(connection, clientName);
                serverMainLoop(connection, clientName);
            } catch (IOException e) {
                handleHandlerException(e, connection);
            } catch (ClassNotFoundException e) {
                handleHandlerException(e, connection);
            }
            // disconnecting client
            if (clientName != null) {
                connectionMap.remove(clientName);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, clientName));
            }

            ConsoleHelper.writeMessage(String.format("Соединение с удаленным адресом (%s) закрыто.", socket.getRemoteSocketAddress()));
        }
        private void handleHandlerException(Exception e, Connection connection) {
            ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с удаленным адресом: " +
                    socket.getRemoteSocketAddress() + "%n" +
                    "Тип ошибки: " + e.getClass().getSimpleName() + "%n" +
                    "Текст ошибки: " + e.getMessage());
            try {
                if (connection != null)
                    connection.close();
                socket.close();
            } catch (IOException e_) { /* NOP */ }
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException
        {
            boolean accepted = false;
            String name = null;
            while (!accepted)
            {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message message = connection.receive();
                if (message.getType() == MessageType.USER_NAME)
                {
                    name = message.getData();
                    if (!name.isEmpty() && connectionMap.get(name) == null)
                    {
                        connectionMap.put(name, connection);
                        connection.send(new Message(MessageType.NAME_ACCEPTED));
                        accepted = true;
                    }
                }
            }
            return name;
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException
        {
            for (String clientName : connectionMap.keySet())
            {
                if (!clientName.equals(userName))
                    connection.send(new Message(MessageType.USER_ADDED, clientName));

            }
        }
        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException{
            while (!Thread.currentThread().isInterrupted()){
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT)
                {
                    String messageText = userName + ": " + message.getData();
                    sendBroadcastMessage(new Message(MessageType.TEXT, messageText));
                }
                ConsoleHelper.writeMessage(
                        String.format("Ошибка! Недопустимый тип сообщения (MessageType.%s) от клиента: %s",
                                message.getType().toString() ,userName)
                );
            }
        }
    }

        public static void main(String[] args)
        {
            ConsoleHelper.writeMessage("Введите порт сервера");
            ServerSocket serverSocket = null;
            try
            {
                int port = ConsoleHelper.readInt();
                serverSocket = new ServerSocket(port);
                ConsoleHelper.writeMessage("Сервер запущен!");
                while (true)
                {
                    Socket socket = serverSocket.accept();
                    Handler handler = new Handler(socket);
                    handler.start();
                }
            }
            catch (Exception e)
            {
                try
                {
                    serverSocket.close();
                }
                catch (Exception e1)
                {
                    ConsoleHelper.writeMessage("Ошибка сокета");
                }
            }
        }

    }

/*
11.1.	Выводить сообщение, что установлено новое соединение с удаленным
адресом, который можно получить с помощью метода getRemoteSocketAddress
11.2.	Создавать Connection, используя поле Socket
11.3.	Вызывать метод, реализующий рукопожатие с клиентом, сохраняя имя нового
клиента
11.4.	Рассылать всем участникам чата информацию об имени присоединившегося
участника (сообщение с типом USER_ADDED). Подумай, какой метод подойдет для
этого лучше всего.
11.5.	Сообщать новому участнику о существующих участниках
11.6.	Запускать главный цикл обработки сообщений сервером
11.7.	Обеспечить закрытие соединения при возникновении исключения
11.8.	Отловить все исключения типа IOException и ClassNotFoundException, вывести в
консоль информацию, что произошла ошибка при обмене данными с удаленным
адресом
11.9.	После того как все исключения обработаны, если п.11.3 отработал и возвратил
нам имя, мы должны удалить запись для этого имени из connectionMap и разослать
всем остальным участникам сообщение с типом USER_REMOVED и сохраненным
именем.
11.10.	Последнее, что нужно сделать в методе run() – вывести сообщение,
информирующее что соединение с удаленным адресом закрыто.
Наш сервер полностью готов. Попробуй его запустить.
 */