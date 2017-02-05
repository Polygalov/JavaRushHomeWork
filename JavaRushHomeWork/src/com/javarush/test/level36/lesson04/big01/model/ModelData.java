package com.javarush.test.level36.lesson04.big01.model;

import com.javarush.test.level36.lesson04.big01.bean.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andy on 03.10.2016.
 */
public class ModelData
{
    private User activeUser;
    private boolean displayDeletedUserList;
    private List<User> users;

    public boolean isDisplayDeletedUserList()
    {
        return displayDeletedUserList;
    }

    public void setDisplayDeletedUserList(boolean displayDeletedUserList)
    {
        this.displayDeletedUserList = displayDeletedUserList;
    }

    public User getActiveUser()
    {
        return activeUser;
    }

    public void setActiveUser(User activeUser)
    {
        this.activeUser = activeUser;
    }



    public List<User> getUsers()
    {
        return users;
    }

    public void setUsers(List<User> users)
    {
        this.users = users;
    }

//    public void loadDeletedUsers() {
//        List<User> users = userService.getAllDeletedUsers();
//    }
}
/*
1. Создай пакет model, в котором создай класс ModelData.
ModelData - это объект, который будет хранить необходимые данные для отображения на клиенте.
Создай поле с геттером и сеттером List<User> users - это будет список юзеров для отображения.

1. Создай в ModelData поле User activeUser с геттером и сеттером (Alt+Insert -> Getter and Setter).

2. Аналогично UsersView создай EditUserView.
Логика метода refresh:
2.1. вывести в консоль "User to be edited:"
2.2. с новой строки вывести табуляцию и активного юзера
2.3. с новой строки вывести разделитель "==================================================="

3. Создай в контроллере поле EditUserView editUserView с сеттером.

Когда наши данные выводятся в консоль, то совсем не понятно, список каких юзеров - удаленных или нет - выводится.
Давай сделаем так, чтобы Вью отображала эту информацию. Все данные для отображения хранятся в Моделе. Поэтому:
4. создай в ModelData поле boolean displayDeletedUserList с геттером и сеттером.
 */