package com.javarush.test.level30.lesson15.big01.client;

/**
 * Created by Andy on 01.08.2016.
 */
public class ClientGuiController extends Client
{
    private ClientGuiModel model = new ClientGuiModel();
    private  ClientGuiView view = new ClientGuiView(this);

    public class GuiSocketThread extends SocketThread{
        @Override
        protected void processIncomingMessage(String message)
        {
            model.setNewMessage(message);
            view.refreshMessages();
        }

        @Override
        protected void informAboutAddingNewUser(String userName)
        {
            model.addUser(userName);
            view.refreshUsers();
        }

        @Override
        protected void informAboutDeletingNewUser(String userName)
        {
            model.deleteUser(userName);
            view.refreshUsers();
        }

        @Override
        protected void notifyConnectionStatusChanged(boolean clientConnected)
        {
            view.notifyConnectionStatusChanged(clientConnected);
        }
    }

    @Override
    protected SocketThread getSocketThread()
    {
        return new GuiSocketThread();
    }

    @Override
    public void run()
    {
        getSocketThread().run();
    }

    @Override
    protected String getServerAddress()
    {
        return view.getServerAddress();
    }

    @Override
    protected int getServerPort()
    {
        return view.getServerPort();
    }

    @Override
    protected String getUserName()
    {
        return view.getUserName();
    }
    public ClientGuiModel getModel(){
        return model;
    }

    public static void main(String[] args)
    {
        new ClientGuiController().run();
    }
}

/*
Осталось написать компонент контроллер (Controller):
21.1.	Создай класс ClientGuiController унаследованный от Client.
21.2.	Создай и проинициализируй поле, отвечающее за модель ClientGuiModel
model.
21.3.	Создай и проинициализируй поле, отвечающее за представление ClientGuiView
view. Подумай, что нужно передать в конструктор при инициализации объекта.
21.4.	Добавь внутренний класс GuiSocketThread унаследованный от SocketThread.
Класс GuiSocketThread должен быть публичным. В нем переопредели следующие
методы:
21.4.1.	void processIncomingMessage(String message) – должен устанавливать новое
сообщение у модели и вызывать обновление вывода сообщений у
представления.
21.4.2.	void informAboutAddingNewUser(String userName) – должен добавлять нового
пользователя в модель и вызывать обновление вывода пользователей у
отображения.
21.4.3.	void informAboutDeletingNewUser(String userName) – должен удалять
пользователя из модели и вызывать обновление вывода пользователей у
отображения.
21.4.4.	void notifyConnectionStatusChanged(boolean clientConnected) – должен вызывать
аналогичный метод у представления.
21.5.	Переопредели методы в классе ClientGuiController:
21.5.1.	SocketThread getSocketThread() – должен создавать и возвращать объект типа
GuiSocketThread.
21.5.2.	void run() – должен получать объект SocketThread через метод getSocketThread()
и вызывать у него метод run(). Разберись, почему нет необходимости вызывать
метод run в отдельном потоке, как мы это делали для консольного клиента.
21.5.3.	getServerAddress(), getServerPort(),getUserName(). Они должны вызывать
одноименные методы из представления (view).
21.6.	Объяви метод ClientGuiModel getModel(), который должен возвращать модель.
21.7.	Объяви метод main(), который должен создавать новый объект
ClientGuiController и вызывать у него метод run().
Запусти клиента с графическим окном, нескольких консольных клиентов и убедись, что
все работает корректно.

 */