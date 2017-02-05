package com.javarush.test.level40.lesson10.task02;

/* Работа с Joda Time
Выполни задание, используя библиотеку Joda Time версии 2.9.1
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

import org.joda.time.DateTime;


public class Solution {
    public static void main(String[] args) {
        printDate("21.4.2014 15:56:45");
        System.out.println();
        printDate("21.4.2014");
        System.out.println();
        printDate("17:33:40");
    }

    public static void printDate(String date) {
        //напишите тут ваш код
        String[] split1 = date.split(" ");
        if (split1.length > 1)
        {
            String[] splitDates = split1[0].split("\\.");
            String[] splitTimes = split1[1].split(":");
            DateTime dt = new DateTime(Integer.parseInt(splitDates[2]), Integer.parseInt(splitDates[1]),  Integer.parseInt(splitDates[0]), Integer.parseInt(splitTimes[0]),  Integer.parseInt(splitTimes[1]),  Integer.parseInt(splitTimes[2]));
          //  GregorianCalendar calendar2 = new GregorianCalendar(Integer.parseInt(splitDates[2]), Integer.parseInt(splitDates[1])-1,  Integer.parseInt(splitDates[0]), Integer.parseInt(splitTimes[0]),  Integer.parseInt(splitTimes[1]),  Integer.parseInt(splitTimes[2]) );
            System.out.println("День: " + dt.getDayOfMonth());
            System.out.println("День недели: " + (dt.getDayOfWeek()% 7 + 1));
            System.out.println("День месяца: " + dt.getDayOfMonth());
            System.out.println("День года: " + dt.getDayOfYear());
            DateTime minYearDate = dt.dayOfYear().withMinimumValue();
            DateTime minMonthDate = dt.dayOfMonth().withMinimumValue();
            int weekDis = (minYearDate.getWeekyear() == dt.getYear()) ? 0 : 1;
            int weekOfYear = dt.getWeekOfWeekyear() + weekDis;
            if (weekOfYear >= 53)
                weekOfYear = 1;
            int weekOfMonth = dt.getWeekOfWeekyear() - minMonthDate.getWeekOfWeekyear() + 1;
            if (minMonthDate.getWeekOfWeekyear() >= dt.getWeekOfWeekyear())
                weekOfMonth = dt.minusDays(7).getWeekOfWeekyear() - minMonthDate.getWeekOfWeekyear() + 2;
            if (dt.getMonthOfYear() == 1)
                weekOfMonth = weekOfYear;
            System.out.println("Неделя месяца: " + weekOfMonth);
            System.out.println("Неделя года: " + weekOfYear);
            System.out.println("Месяц: " + (dt.getMonthOfYear()-1));
            System.out.println("Год: " + dt.getYear());
            System.out.println("Эра: " + dt.getEra());
            System.out.println("AM или PM: " + (dt.getHourOfDay()  >= 12 ? 1 : 0));
            System.out.println("Часы: " + (dt.getHourOfDay()% 12));
            System.out.println("Часы дня: " + dt.getHourOfDay());
           System.out.println("Минуты: " + dt.getMinuteOfHour());
            System.out.println("Секунды: " + dt.getSecondOfMinute());
        } else
        {
            String[] split2 = date.split("\\.");
            if (split2.length > 1){
                DateTime dt = new DateTime(Integer.parseInt(split2[2]), Integer.parseInt(split2[1]),  Integer.parseInt(split2[0]),0,0,0);
               // GregorianCalendar calendar1 = new GregorianCalendar(Integer.parseInt(split2[2]), Integer.parseInt(split2[1])-1,  Integer.parseInt(split2[0]) );
                System.out.println("День: " + dt.getDayOfMonth());
                System.out.println("День недели: " +(dt.getDayOfWeek()% 7 + 1));
                System.out.println("День месяца: " + dt.getDayOfMonth());
                System.out.println("День года: " + dt.getDayOfYear());
                DateTime minYearDate = dt.dayOfYear().withMinimumValue();
                DateTime minMonthDate = dt.dayOfMonth().withMinimumValue();
                int weekDis = (minYearDate.getWeekyear() == dt.getYear()) ? 0 : 1;
                int weekOfYear = dt.getWeekOfWeekyear() + weekDis;
                if (weekOfYear >= 53)
                    weekOfYear = 1;
                int weekOfMonth = dt.getWeekOfWeekyear() - minMonthDate.getWeekOfWeekyear() + 1;
                if (minMonthDate.getWeekOfWeekyear() >= dt.getWeekOfWeekyear())
                    weekOfMonth = dt.minusDays(7).getWeekOfWeekyear() - minMonthDate.getWeekOfWeekyear() + 2;
                if (dt.getMonthOfYear() == 1)
                    weekOfMonth = weekOfYear;
                System.out.println("Неделя месяца: " + weekOfMonth);
                System.out.println("Неделя года: " + weekOfYear);
                System.out.println("Месяц: " + (dt.getMonthOfYear()-1));
                System.out.println("Год: " + dt.getYear());
                System.out.println("Эра: " + dt.getEra());
            }
            else
            {
                String[] split3 = date.split(":");
                //напишите тут ваш код
                DateTime dt = new DateTime(0, 1, 1, Integer.parseInt(split3[0]),  Integer.parseInt(split3[1]),  Integer.parseInt(split3[2]));
               // GregorianCalendar calendar = new GregorianCalendar(0, 0, 0, Integer.parseInt(split3[0]),  Integer.parseInt(split3[1]),  Integer.parseInt(split3[2]));
                System.out.println("AM или PM: " + (dt.getHourOfDay()  >= 12 ? 1 : 0));
                System.out.println("Часы: " + (dt.getHourOfDay()% 12));
                System.out.println("Часы дня: " + dt.getHourOfDay());
                System.out.println("Минуты: " + dt.getMinuteOfHour());
                System.out.println("Секунды: " + dt.getSecondOfMinute());
            }
        }
    }
}

