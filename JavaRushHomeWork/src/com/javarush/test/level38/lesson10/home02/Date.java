package com.javarush.test.level38.lesson10.home02;

public @interface Date {
    int year();
    int month();
    int day();
    int hour();
    int minute();
    int second();
    //напиши свой код
}
/*
date = @Date(year = 2011, month = 5, day = 30, hour = 18, minute = 35, second = 18),
 */