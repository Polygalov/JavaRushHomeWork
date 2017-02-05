package com.javarush.test.level36.lesson08.task01;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.TreeSet;

/* Использование TreeSet
Первым параметром приходит имя файла: файл1.
файл1 содержит только буквы латинского алфавита, пробелы, знаки препинания, тире, символы перевода каретки.
Отсортировать буквы по алфавиту и вывести на экран первые 5 различных букв в одну строку без разделителей.
Если файл1 содержит менее 5 различных букв, то вывести их все.
Буквы различного регистра считаются одинаковыми.
Регистр выводимых букв не влияет на результат.
Закрыть потоки.

Пример 1 данных входного файла:
zBk yaz b-kN
Пример 1 вывода:
abkny

Пример 2 данных входного файла:
caAC
A, aB? bB
Пример 2 вывода:
abc

Подсказка: использовать TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {
//        if(args.length > 0)
//        {
//            FileInputStream in = new FileInputStream(args[0]);
//
//            in.close();
//        }
        String a = new String(Files.readAllBytes(Paths.get(args[0])));
      //  String a = "zBk yaz b-kN";
        //String a = "caAC\n" +
        //        "A, aB? bB";
        String aMod = a.toLowerCase();
        char[] passwordInCharArray =  aMod.toCharArray();

        TreeSet< Character > set = new TreeSet< Character >();
        for (int i = 0; i < passwordInCharArray.length; i++) {
            if (passwordInCharArray[i]>96&&passwordInCharArray[i]<123){
                set.add(new Character(passwordInCharArray[i]));
            }
        }
StringBuilder builder =new StringBuilder();
        for (Character n : set) {
            builder.append(n);


        }

String output = builder.toString();
        if (output.length()>5)
        {
            String outFin = output.substring(0, 5);
            System.out.print(outFin);
        }
        else
        {
            System.out.print(output);
        }

    }
}
