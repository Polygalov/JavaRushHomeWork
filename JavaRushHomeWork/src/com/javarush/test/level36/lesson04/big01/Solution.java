package com.javarush.test.level36.lesson04.big01;

import com.javarush.test.level36.lesson04.big01.controller.Controller;


import com.javarush.test.level36.lesson04.big01.model.MainModel;
import com.javarush.test.level36.lesson04.big01.model.Model;

import com.javarush.test.level36.lesson04.big01.view.EditUserView;
import com.javarush.test.level36.lesson04.big01.view.UsersView;

public class Solution {
    public static void main(String[] args)
    {
        Model model = new MainModel();
        UsersView usersView = new UsersView();
        EditUserView editUserView = new EditUserView();

        Controller controller = new Controller();

        usersView.setController(controller);
        editUserView.setController(controller);

        controller.setModel(model);
        controller.setUsersView(usersView);
        controller.setEditUserView(editUserView);

        usersView.fireEventShowAllUsers();
        usersView.fireEventShowDeletedUsers();
        usersView.fireEventOpenUserEditForm(126);

        editUserView.fireEventUserDeleted(124);
        editUserView.fireEventUserChanged("IPetrov", 125, 15);
    }
}
/*
5. Класс Solution будет эмулятором пользователя. Открой класс Solution, стань на красный метод,
с помощью гарячих клавиш Идеи создай проперти(поле) для usersView.
Нужен только сеттер. Если у тебя создался геттер, то удали его.

6. Запусти main. Упс, ничего не вывело :(
Это получилось потому, что данные пришли с сервера, обновились в ModelData, но Вью ничего о них не знает.
Вью сама не умеет себя обновлять. Это делает Контроллер.
Пойди в контроллер и добавь обновление данных во Вью.
Напомню, данные хранятся в Моделе.

7. Запусти main. У меня теперь такой вывод:
All users:
	User{name='A', id=1, level=1}
	User{name='B', id=2, level=1}
===================================================
Ура, идем дальше.
2. Добавь в метод main открытие формы редактирования для пользователя с id=126
 */