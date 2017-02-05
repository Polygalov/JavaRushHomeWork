package com.javarush.test.level36.lesson04.big01.model;

/**
 * Created by Andy on 03.10.2016.
 */
public interface Model
{
    ModelData getModelData();
    void loadUsers();
    void loadDeletedUsers();
    void loadUserById(long userId);
    void deleteUserById(long id);
    void changeUserData(String name, long id, int level);
}
/*
2. Используя любую модель должна быть возможность получить все необходимые данные для отображения. Поэтому
в пакете model создай интерфейс Model, который должен содержать метод ModelData getModelData().
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