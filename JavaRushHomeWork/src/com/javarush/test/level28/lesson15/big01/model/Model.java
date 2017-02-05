package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.view.View;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andy on 18.07.2016.
 */
public class Model
{
    private View view;
    private Provider[] providers;

    public Model(View view, Provider[] providers)
    {
        if (view == null || providers == null || providers.length == 0) {
            throw  new IllegalArgumentException("Illegal arguments");
        }
        this.view = view;
        this.providers = providers;
    }
    public void selectCity(String city){
        List<Vacancy> vacancies = new ArrayList<>();
        for (Provider provider : providers) {
            vacancies.addAll(provider.getJavaVacancies(city));
        }
        view.update(vacancies);
    }
    }

/*
В Model есть метод selectCity, в него передается название города, для которого выбираются вакансии.
Очевидно, что этот метод будет вызываться контроллером, т.к. он принимает решение, какую модель использовать.

1. Добавь в Controller новое поле Model model.

2. Удали метод scan() из Controller, его логика переместилась в модель.

3. Удали конструктор, toString и поле providers из контроллера.

4. Создай конструктор в Controller с аргументом Model.
На некорректные данные брось IllegalArgumentException

5. В Controller создай публичный метод void onCitySelect(String cityName), в котором вызови нужный метод модели.

6. Удали код из метода main. Этот код уже не валидный.
 */