package com.javarush.test.level36.lesson04.big01.model;

import com.javarush.test.level36.lesson04.big01.bean.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andy on 03.10.2016.
 */
public class FakeModel implements Model
{
    private ModelData modelData = new ModelData();
    @Override
    public ModelData getModelData()
    {
        return modelData;
    }

    @Override
    public void loadUsers()
    {
        List<User> users1 =modelData.getUsers();
        users1.add(new User("A",1,1));
        users1.add(new User("B",2,2));
        modelData.setUsers(users1);


    }

    @Override
    public void loadDeletedUsers()
    {
       throw new UnsupportedOperationException();
    }

    @Override
    public void loadUserById(long userId)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteUserById(long id)
    {
        throw new UnsupportedOperationException();
    }
    @Override
    public void changeUserData(String name, long id, int level) {
        throw new UnsupportedOperationException();
    }
}
/*
3. В пакете model создай класс FakeModel, реализующий Model. Он нам понадобится на начальном этапе.
В нем создай поле ModelData modelData, которое инициализируй объектом.
4. В интерфейсе Model создай метод void loadUsers().
Реализуй его в FakeModel: инициализируй список юзеров в modelData любыми данными. Они не влияют на тестирование.
У меня такие данные:
User{name='A', id=1, level=1}
User{name='B', id=2, level=1}
Думаю, ты помнишь, что все методы интерфейса являются public-ами, поэтому модификатор указывать не нужно.
Программисты часто мОкают данные на начальном этапе. Получение реальных данных реализовывается на последних этапах.
Мокать - это подменять реальные объекты на хардкоженные, тестовые данные.
3. Добавь в интерфейс Model метод, который ты поместил в Модель, реализуй его в FakeModel: выброси UnsupportedOperationException
 */