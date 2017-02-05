package com.javarush.test.level36.lesson04.big01.view;

import com.javarush.test.level36.lesson04.big01.bean.User;
import com.javarush.test.level36.lesson04.big01.controller.*;
import com.javarush.test.level36.lesson04.big01.controller.Controller;
import com.javarush.test.level36.lesson04.big01.model.ModelData;
import com.javarush.test.level36.lesson04.home01.*;

import java.util.List;

/**
 * Created by Andy on 04.10.2016.
 */
//будет отображать список юзеров в консоль
public class UsersView implements View {

    private Controller controller;


    public void fireEventShowAllUsers(){
        controller.onShowAllUsers();
    }

    public void fireEventShowDeletedUsers() {
        controller.onShowAllDeletedUsers();
    }

    public void fireEventOpenUserEditForm(long id) {
        controller.onOpenUserEditForm(id);
    }


    @Override
    public void refresh(ModelData modelData) {
        if (!modelData.isDisplayDeletedUserList()) {
            System.out.println("All users:");
        }
        if (modelData.isDisplayDeletedUserList()) {
            System.out.println("All deleted users:");
        }

        //Выведи в консоль всех юзеров, которые есть в modelData
        //Перед каждым юзером сделай отступ в виде табуляции
        for (int i = 0; i < modelData.getUsers().size(); i++) {
            System.out.println("\t" + modelData.getUsers().get(i));
        }
        //В конце выведи визуальный разделитель данных
        System.out.println("===================================================");
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }
}
/*
Чтобы понимать, в правильном ли направлении ты движешся, тебе надо видеть данные. Поэтому
1. В пакете view создай класс UsersView, реализующий View. Он будет отображать список юзеров в консоль.

2. В UsersView создай поле-контроллер, также создай ему сеттер.

3. Реализуй логику метода refresh:
3.1. Выведи в консоль фразу "All users:".
3.2. Выведи в консоль всех юзеров, которые есть в modelData.
 Перед каждым юзером сделай отступ в виде табуляции.
3.3. В конце выведи визуальный разделитель данных
===================================================

4. Уже интересно посмотреть, что же получилось.
Добавь в UsersView публичный метод void fireEventShowAllUsers(), который сэмулирует событие клиента.
Обратись к контроллеру и вызови его нужный метод для отображения всех пользователей.

5. Измени метод refresh в UsersView так, чтобы он отображал "All users:" либо "All deleted users:"
в зависимости от того, какие юзера находятся в списке. Добавь в необходимые методы модели изменение displayDeletedUserList.
 */