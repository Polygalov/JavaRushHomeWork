package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Andy on 03.02.2016.
 */
/*public class BelarusianHen extends Hen
{
    int getCountOfEggsPerMonth()
    {
        //int countR = 17;
        return 17;
    }

    String getDescription()
    {

        return super.getDescription() + " Моя страна - "+Country.BELARUS+". Я несу "+getCountOfEggsPerMonth()+" яиц в месяц.";
    }
}
*/
public class BelarusianHen extends Hen
{
    @Override
    public int getCountOfEggsPerMonth()
    {
        return 27;
    }
    public String getDescription() {

        return super.getDescription() + " Моя страна - "+ Country.BELARUS+". Я несу "+getCountOfEggsPerMonth() +" яиц в месяц.";

    }
}