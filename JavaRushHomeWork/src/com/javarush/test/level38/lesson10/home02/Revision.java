package com.javarush.test.level38.lesson10.home02;

import java.util.*;

public @interface Revision {

    int revision();
    Date date();
    Author[] authors() default {};
    String comment() default "";
//    int attack() default 0;
//    int defense();
    //напиши свой код
}
/*
  @Revision(
                revision = 6018,
                date = @Date(year = 2013, month = 1, day = 1, hour = 0, minute = 0, second = 1),
                authors = {@Author(value = "Серега", position = Position.MIDDLE)},
                comment = "Фикс багов"),
 */