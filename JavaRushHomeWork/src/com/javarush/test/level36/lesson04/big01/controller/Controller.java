package com.javarush.test.level36.lesson04.big01.controller;

import com.javarush.test.level36.lesson04.big01.model.Model;
import com.javarush.test.level36.lesson04.big01.view.EditUserView;
import com.javarush.test.level36.lesson04.big01.view.UsersView;

/**
 * Created by Andy on 04.10.2016.
 */
public class Controller {

    private Model model;
    private UsersView usersView;
    private EditUserView editUserView;


    //methods;
    public void onShowAllUsers() {
        //обратиться к модели и инициировать загрузку юзеров
        model.loadUsers();
        //Вью сама не умеет себя обновлять. Это делает Контроллер. Пойди в контроллер и добавь обновление данных во Вью. Напомню, данные хранятся в Моделе
        usersView.refresh(model.getModelData());
    }

    public void onShowAllDeletedUsers() {
        model.loadDeletedUsers();
        usersView.refresh(model.getModelData());
    }

    public void onOpenUserEditForm(long userId) {
        model.loadUserById(userId);
        editUserView.refresh(model.getModelData());
    }

    public void onUserDelete(long id) {
        model.deleteUserById(id);
        usersView.refresh(model.getModelData());
    }

    public void onUserChange(String name, long id, int level){
        model.changeUserData(name, id, level);
        usersView.refresh(model.getModelData());
    }




    //setter
    public void setModel(Model model) {
        this.model = model;
    }

    public void setUsersView(UsersView usersView) {
        this.usersView = usersView;
    }

    public void setEditUserView(EditUserView editUserView) {
        this.editUserView = editUserView;
    }
}
/*
6. Запусти main. Упс, ничего не вывело :(
Это получилось потому, что данные пришли с сервера, обновились в ModelData, но Вью ничего о них не знает.
Вью сама не умеет себя обновлять. Это делает Контроллер.
Пойди в контроллер и добавь обновление данных во Вью.
Напомню, данные хранятся в Моделе.
1. Создай пакет controller, в котором создай класс Controller.
Этот класс будет получать запрос от клиента, оповещать Модель об этом, а Модель, в свою очередь, будет обновлять ModelData-у.

2. Добавь в контроллер поле Model model вместе с сеттером.

3. В контроллере создай публичный метод void onShowAllUsers(), который должен обратиться к моделе и инициировать загрузку юзеров.

4. Создай пакет view. В нем создай интерфейс View.

5. В интерфейс View добавь два метода void refresh(ModelData modelData) и void setController(Controller controller)

3. Создай в контроллере поле EditUserView editUserView с сеттером.

Когда наши данные выводятся в консоль, то совсем не понятно, список каких юзеров - удаленных или нет - выводится.
Давай сделаем так, чтобы Вью отображала эту информацию. Все данные для отображения хранятся в Моделе. Поэтому:
4. создай в ModelData поле boolean displayDeletedUserList с геттером и сеттером.

5. Измени метод refresh в UsersView так, чтобы он отображал "All users:" либо "All deleted users:"
в зависимости от того, какие юзера находятся в списке. Добавь в необходимые методы модели изменение displayDeletedUserList.
 */