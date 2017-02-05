package com.javarush.test.level38.lesson10.home02;

public @interface Author {

    String value() default "";
    Position position() default Position.OTHER;
    //напиши свой код
}
/*
 authors = {@Author(value = "Диана", position = Position.OTHER),
                        @Author("Игорь"),
                        @Author(value = "Витек", position = Position.SENIOR)})
 */