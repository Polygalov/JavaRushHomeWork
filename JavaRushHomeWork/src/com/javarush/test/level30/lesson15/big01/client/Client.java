package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.Connection;
import com.javarush.test.level30.lesson15.big01.ConsoleHelper;
import com.javarush.test.level30.lesson15.big01.Message;
import com.javarush.test.level30.lesson15.big01.MessageType;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by Andy on 31.07.2016.
 */
public class Client
{
    protected Connection connection;
    private volatile boolean clientConnected=false;
    public class SocketThread extends Thread{
        protected void processIncomingMessage(String message){
            ConsoleHelper.writeMessage(message);
        }
        protected void informAboutAddingNewUser(String userName){
            ConsoleHelper.writeMessage(userName + " присоединился к чату" );
        }
        protected void informAboutDeletingNewUser(String userName){
            ConsoleHelper.writeMessage(userName + " покинул чат" );
        }
        protected void notifyConnectionStatusChanged(boolean clientConnected){
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this) {
                Client.this.notify();
            }
        }
        protected void clientHandshake() throws IOException, ClassNotFoundException{
            boolean accepted = false;
            //16.1.1.
            while (!accepted) {
                Message message = connection.receive();
                switch (message.getType()) {
                    //16.1.2.
                    case NAME_REQUEST:
                        String clientName = getUserName();
                        connection.send(new Message(MessageType.USER_NAME, clientName));
                        break;
                    //16.1.3.
                    case NAME_ACCEPTED:
                        notifyConnectionStatusChanged(true);
                        return;
                    //16.1.4.
                    default:
                        throw new IOException("Unexpected MessageType");
                }
            }
        }
        protected void clientMainLoop() throws IOException, ClassNotFoundException{
            while (!Thread.currentThread().isInterrupted()) {
                Message message = connection.receive();
                switch (message.getType()) {
                    //16.1.2.
                    case TEXT:
                        processIncomingMessage(message.getData());
                        break;
                    //16.1.3.
                    case USER_ADDED:
                        informAboutAddingNewUser(message.getData());
                        break;
                    case USER_REMOVED:
                        informAboutDeletingNewUser(message.getData());
                        break;
                    //16.1.4.
                    default:
                        throw new IOException("Unexpected MessageType");
                }
            }
        }
        public void run(){
           String adress = getServerAddress();
           int port= getServerPort();
            try
            {
                Socket socket = new Socket(adress, port);

                Client.this.connection = new Connection(socket);
                clientHandshake();
            clientMainLoop();
            } catch (IOException e) {
                notifyConnectionStatusChanged(false);
            } catch (ClassNotFoundException e) {
                notifyConnectionStatusChanged(false);
            }
        }
    }
    public void run(){
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();
        synchronized (this) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                ConsoleHelper.writeMessage("Выход из программы по ошибке.");
                return;
            }
        }
        if (clientConnected)
            ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду 'exit'.");
        else
            ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");

        while (clientConnected) {
            String text = ConsoleHelper.readString();
            if (text.toLowerCase().equals("exit")) break;

            if (shouldSentTextFromConsole())
                sendTextMessage(text);
        }
    }

    public static void main(String[] args)
    {
        Client client = new Client();
        client.run();

    }

    protected String getServerAddress(){
        ConsoleHelper.writeMessage("Введите адрес сервера:");
        return ConsoleHelper.readString();
    }
    protected int getServerPort(){
        ConsoleHelper.writeMessage("Введите порт сервера:");
        return ConsoleHelper.readInt();
    }
    protected String getUserName(){
        ConsoleHelper.writeMessage("Введите имя пользователя:");
        return ConsoleHelper.readString();
    }
    protected boolean shouldSentTextFromConsole(){
        return true;
    }
    protected SocketThread getSocketThread(){
        return new SocketThread();
    }
    protected void sendTextMessage(String text){
        try {
            connection.send(new Message(MessageType.TEXT, text));
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Ошибка при отправке сообщения. Соединение будет закрыто.");
            clientConnected = false;
        }
    }
}

/*
Последний, но самый главный метод класса SocketThread – это метод void run(). Добавь
его. Его реализация с учетом уже созданных методов выглядит очень просто. Давай
напишем ее:
17.1.	Запроси адрес и порт сервера с помощью методов getServerAddress() и
getServerPort().
17.2.	Создай новый объект класса java.net.Socket, используя данные, полученные в
п.17.1.
17.3.	Создай объект класса Connection, используя сокет из п.17.2.
17.4.	Вызови метод, реализующий "рукопожатие" клиента с сервером
(clientHandshake()).
17.5.	Вызови метод, реализующий основной цикл обработки сообщений сервера.
17.6.	При возникновении исключений IOException или ClassNotFoundException
сообщи главному потоку о проблеме, используя notifyConnectionStatusChanged и false
в качестве параметра.
Клиент готов, можешь запустить сервер, несколько клиентов и проверить как все работает.
 */