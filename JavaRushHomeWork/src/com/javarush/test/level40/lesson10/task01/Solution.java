package com.javarush.test.level40.lesson10.task01;

/* Работа с датами
Реализуй метод printDate(String date).
Он должен в качестве параметра принимать дату (в одном из 3х форматов)
и выводить ее в консоль в соответсвии с примером:

1) Для "21.4.2014 15:56:45" вывод должен быть:
День: 21
День недели: 2
День месяца: 21
День года: 111
Неделя месяца: 4
Неделя года: 17
Месяц: 3
Год: 2014
Эра: 1
AM или PM: 1
Часы: 3
Часы дня: 15
Минуты: 56
Секунды: 45

2) Для "21.4.2014":
День: 21
День недели: 2
День месяца: 21
День года: 111
Неделя месяца: 4
Неделя года: 17
Месяц: 3
Год: 2014
Эра: 1

3) Для "17:33:40":
AM или PM: 1
Часы: 5
Часы дня: 17
Минуты: 33
Секунды: 40
*/

import org.joda.time.LocalDate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Solution {
    public static void main(String[] args) {
        printDate("21.4.2014 15:56:45");
        System.out.println();
        printDate("21.4.2014");
        System.out.println();
        printDate("17:33:40");
    }

    public static void printDate(String date)
    {
        String[] split1 = date.split(" ");
        if (split1.length > 1)
        {
            String[] splitDates = split1[0].split("\\.");
            String[] splitTimes = split1[1].split(":");
            GregorianCalendar calendar2 = new GregorianCalendar(Integer.parseInt(splitDates[2]), Integer.parseInt(splitDates[1])-1,  Integer.parseInt(splitDates[0]), Integer.parseInt(splitTimes[0]),  Integer.parseInt(splitTimes[1]),  Integer.parseInt(splitTimes[2]) );
            System.out.println("День: " + calendar2.get(Calendar.DAY_OF_MONTH));
            System.out.println("День недели: " + calendar2.get(Calendar.DAY_OF_WEEK));
            System.out.println("День месяца: " + calendar2.get(Calendar.DAY_OF_MONTH));
            System.out.println("День года: " + calendar2.get(Calendar.DAY_OF_YEAR));
            System.out.println("Неделя месяца: " + calendar2.get(Calendar.WEEK_OF_MONTH));
            System.out.println("Неделя года: " + calendar2.get(Calendar.WEEK_OF_YEAR));
            System.out.println("Месяц: " + calendar2.get(Calendar.MONTH));
            System.out.println("Год: " + calendar2.get(Calendar.YEAR));
            System.out.println("Эра: " + calendar2.get(Calendar.ERA));
            System.out.println("AM или PM: " + calendar2.get(Calendar.AM_PM));
            System.out.println("Часы: " + calendar2.get(Calendar.HOUR));
            System.out.println("Часы дня: " + calendar2.get(Calendar.HOUR_OF_DAY));
            System.out.println("Минуты: " + calendar2.get(Calendar.MINUTE));
            System.out.println("Секунды: " + calendar2.get(Calendar.SECOND));
        } else
        {
            String[] split2 = date.split("\\.");
            if (split2.length > 1){

                GregorianCalendar calendar1 = new GregorianCalendar(Integer.parseInt(split2[2]), Integer.parseInt(split2[1])-1,  Integer.parseInt(split2[0]) );
                System.out.println("День: " + calendar1.get(Calendar.DAY_OF_MONTH));
                System.out.println("День недели: " + calendar1.get(Calendar.DAY_OF_WEEK));
                System.out.println("День месяца: " + calendar1.get(Calendar.DAY_OF_MONTH));
                System.out.println("День года: " + calendar1.get(Calendar.DAY_OF_YEAR));
                System.out.println("Неделя месяца: " + calendar1.get(Calendar.WEEK_OF_MONTH));
                System.out.println("Неделя года: " + calendar1.get(Calendar.WEEK_OF_YEAR));
                System.out.println("Месяц: " + calendar1.get(Calendar.MONTH));
                System.out.println("Год: " + calendar1.get(Calendar.YEAR));
                System.out.println("Эра: " + calendar1.get(Calendar.ERA));
            }
            else
            {
                String[] split3 = date.split(":");
                //напишите тут ваш код
                GregorianCalendar calendar = new GregorianCalendar(0, 0, 0, Integer.parseInt(split3[0]),  Integer.parseInt(split3[1]),  Integer.parseInt(split3[2]));
                System.out.println("AM или PM: " + calendar.get(Calendar.AM_PM));
                System.out.println("Часы: " + calendar.get(Calendar.HOUR));
                System.out.println("Часы дня: " + calendar.get(Calendar.HOUR_OF_DAY));
                System.out.println("Минуты: " + calendar.get(Calendar.MINUTE));
                System.out.println("Секунды: " + calendar.get(Calendar.SECOND));
            }
        }
    }
    }

/*
        try
        {
            LocalDate dates = LocalDate.of(2014, Month.JUNE, 10);
            LocalDate dates = LocalDate.of("MMMM d, yy", Locale.ENGLISH).parse(date);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        System.out.println(dates.getDay);
//Tue Sep 17 00:00:00 EDT 2013
    }
}
*/
