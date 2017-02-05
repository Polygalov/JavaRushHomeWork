package com.javarush.test.level37.lesson04.big01;

import com.javarush.test.level37.lesson04.big01.female.FemaleFactory;
import com.javarush.test.level37.lesson04.big01.male.MaleFactory;

/**
 * Created by Andy on 12.10.2016.
 */
public class FactoryProducer
{
    public static enum HumanFactoryType{
        MALE,
        FEMALE
    }
    public static AbstractFactory getFactory(HumanFactoryType humanFactoryType){
if (humanFactoryType.equals(HumanFactoryType.MALE))
{
    return new MaleFactory();
}
    else return new FemaleFactory();
}
    }

/*
3. В корне задачи создай класс FactoryProducer, в котором создай публичный статический энум HumanFactoryType
со значениями MALE, FEMALE.

4. В FactoryProducer создайт публичный статический метод getFactory с аргументом HumanFactoryType.
Этот метод должен возвращать одну из фабрик: для ключа MALE - MaleFactory, для FEMALE - FemaleFactory.

 */