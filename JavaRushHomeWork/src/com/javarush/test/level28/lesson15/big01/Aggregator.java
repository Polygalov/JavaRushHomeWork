package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.model.HHStrategy;
import com.javarush.test.level28.lesson15.big01.model.Model;
import com.javarush.test.level28.lesson15.big01.model.MoikrugStrategy;
import com.javarush.test.level28.lesson15.big01.model.Provider;
import com.javarush.test.level28.lesson15.big01.view.HtmlView;



/**
 * Created by Andy on 16.07.2016.
 */
public class Aggregator
{
    public static void main(String[] args)
    {
        HtmlView view = new HtmlView();
        Provider providerHH = new Provider(new HHStrategy());
        Provider providerLinkedIn = new Provider(new MoikrugStrategy());
        Model model = new Model(view, new Provider[] {providerHH, providerLinkedIn});
        view.setController(new Controller(model));
        view.userCitySelectEmulationMethod();

    }
}
/*
5. В методе main создай провайдер, а потом создай контроллер с этим провайдером.

6. В методе main выведи в консоль созданный экземпляр Controller-а.
 Provider provider = new Provider(new HHStrategy());
        Controller controller = new Controller(provider);
        //System.out.println(controller);
        try {
            controller.scan();
        }catch (Exception ex){}

        3. Для запуска нужно еще обновить метод main в Aggregator.
3.1. Создай вью, модель, контроллер.
3.2. Засэть во вью контроллер.
3.3. Вызови у вью метод  userCitySelectEmulationMethod.

4. Запускай приложение! Подожди несколько секунд, чтобы выгреблись данные.
Работает? Отлично, что работает!

 */