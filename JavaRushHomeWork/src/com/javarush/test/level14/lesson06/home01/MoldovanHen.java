package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Andy on 03.02.2016.
 */
public class MoldovanHen extends Hen
{
    @Override
    public int getCountOfEggsPerMonth()
    {
        return 31;
    }
    public String getDescription() {
        return super.getDescription() + " Моя страна - "+ Country.MOLDOVA+ ". Я несу " + getCountOfEggsPerMonth() +" яиц в месяц.";
    }
}