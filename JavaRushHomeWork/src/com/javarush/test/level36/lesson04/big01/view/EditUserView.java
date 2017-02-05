package com.javarush.test.level36.lesson04.big01.view;

import com.javarush.test.level36.lesson04.big01.bean.User;
import com.javarush.test.level36.lesson04.big01.controller.Controller;
import com.javarush.test.level36.lesson04.big01.model.ModelData;

import java.util.List;

/**
 * Created by Andy on 07.10.2016.
 */

public class EditUserView implements View {

    private Controller controller;


    public void fireEventUserDeleted(long id) {
        controller.onUserDelete(id);
    }

    public void fireEventUserChanged(String name, long id, int level) {
        controller.onUserChange(name, id, level);
    }

    @Override
    public void refresh(ModelData modelData) {
        System.out.println("User to be edited:");
        System.out.println("\t" + modelData.getActiveUser());
        System.out.println("===================================================");
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }
}



/*
Добавь ивент в EditUserView. Используй следующие сигнатуры публичных методов:
void fireEventUserDeleted(long id)
void onUserDelete(long id)
void deleteUserById(long id)
2. Аналогично UsersView создай EditUserView.
Логика метода refresh:
2.1. вывести в консоль "User to be edited:"
2.2. с новой строки вывести табуляцию и активного юзера
2.3. с новой строки вывести разделитель "==================================================="

3. Создай в контроллере поле EditUserView editUserView с сеттером.

Когда наши данные выводятся в консоль, то совсем не понятно, список каких юзеров - удаленных или нет - выводится.
Давай сделаем так, чтобы Вью отображала эту информацию. Все данные для отображения хранятся в Моделе. Поэтому:
4. создай в ModelData поле boolean displayDeletedUserList с геттером и сеттером.

5. Измени метод refresh в UsersView так, чтобы он отображал "All users:" либо "All deleted users:"
в зависимости от того, какие юзера находятся в списке. Добавь в необходимые методы модели изменение displayDeletedUserList.
 */