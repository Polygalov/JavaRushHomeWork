package com.javarush.test.level15.lesson12.home01;




import java.io.IOException;

import java.util.Scanner;

/* Разные методы для разных типов
1. Считать с консоли данные, пока не введено слово "exit".
2. Для каждого значения, кроме "exit", вызвать метод print. Если значение:
2.1. содержит точку '.', то вызвать метод print для Double;
2.2. больше нуля, но меньше 128, то вызвать метод print для short;
2.3. больше либо равно 128, то вызвать метод print для Integer;
2.4. иначе, вызвать метод print для String.
*/

public class Solution {
    public static void main(String[] args) throws IOException
    {
        //напиште тут ваш код
        Scanner scanner=new Scanner(System.in);
        String v=scanner.nextLine();
        while (!v.equals("exit"))
        {

            //if(v.equals("exit"))  break;
            try
            {
                if(v.contains("."))
                {
                    print(Double.parseDouble(v));
                }


                else if(Integer.parseInt(v)>=128)
                {
                    print(Integer.parseInt(v));
                }

                else if(Short.parseShort(v)>0&&Short.parseShort(v)<128)
                {
                    print(Short.parseShort(v));
                }

                else print(v);
            }

            catch (NumberFormatException e)
            {
                print(v);
            }
            v=scanner.nextLine();

        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
