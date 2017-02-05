package com.javarush.test.level30.lesson02.home01;

import java.math.BigInteger;

/* Конвертер систем счислений
Реализуйте логику метода convertNumberToOtherNumerationSystem, который должен переводить число number.getDigit()
из одной системы счисления(numerationSystem) в другую (expectedNumerationSystem)
бросьте NumberFormatException, если переданное число некорректно, например, число "120" с системой счисления 2
Валидация для - number.getDigit() - целое не отрицательное
Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        Number number = new Number(NumerationSystemType._10, "6");
        Number result = convertNumberToOtherNumerationSystem(number, NumerationSystemType._2);
        System.out.println(result);    //expected 110
    }

    public static Number convertNumberToOtherNumerationSystem(Number number, NumerationSystem expectedNumerationSystem) {
        BigInteger a = new BigInteger(number.getDigit(), number.getNumerationSystem().getNumerationSystemIntValue());
        return new Number(expectedNumerationSystem, a.toString(expectedNumerationSystem.getNumerationSystemIntValue()));
    }
}
/*
Среди многочисленных возможностей, которые предоставляет разработчикам класс BigInteger, это достаточно простой перевод целых чисел из одной системы счисления в другую.

Для этого необходимо особым образом воспользоваться конструктором этого класса в сочетании с перегрузкой его метода toString, которая возвращает строковое представление числа в соответствующей системе счисления.

Допустим, имеется объект BigInteger, в котором хранится число 8. После вызова метода toString с параметром 2 будет возвращено строковое представление этого числа в двоичной системе счисления.

1
2
BigInteger a= new BigInteger("8");
String s=a.toString(2);
В переменной s будет строка “1000”, что соответствует 8 в двоичной системе. Таким образом, было получено число в виде строки, но для работы с числом необходимо, чтобы оно было в виде числа.

Поэтому создадим второй объект BigInteger, который будет хранить число уже в двоичной системе.

1
BigInteger b= new BigInteger(s);
В итоге получается фрагмент из 3х строк кода:

1
2
3
BigInteger a= new BigInteger("8");
String s=a.toString(2);
BigInteger b= new BigInteger(s);
Он весьма наглядно иллюстрирует суть алгоритма, но, в тоже время является довольно громоздким. Попробуем его упростить.

Первое, от чего можно в нём отказаться, это промежуточная строковая переменная s. После отказа от неё алгоритм сводится уже к двум строкам:

1
2
BigInteger a= new BigInteger("8");
BigInteger b= new BigInteger(a.toString(2));
Java также позволяет создать объект с исходными данными непосредственно в параметре конструктора объекта для хранения результата. Поэтому, в конечном итоге, весь алгоритм перевода систем счисления может быть представлен всего на всего одной единственной строкой кода.

1
BigInteger b =new BigInteger(new BigInteger("8").toString(2));
Таким образом, с помощью класса BigInteger можно просто и удобно переводить числа из одной системы счисления в другую.



Стрелец Coder - Сайт профессионального программиста http://streletzcoder.cf/perevod-sistem-schisleniya-s-pomoshhyu-klassa-biginteger-ili-kak-perevesti-chislo-v-druguyu-sistemu-schisleniya-s-pomoshhyu-odnoy-sroki-koda/
 */