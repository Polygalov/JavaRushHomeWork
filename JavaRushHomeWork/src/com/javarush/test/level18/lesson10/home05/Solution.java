package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> numbers = new ArrayList<Integer>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName1));
        String str;
        String[] strMass;
        double tmp;

        while ((str = fileReader.readLine()) != null) {
            strMass = str.split(" ");
            for (String strMas : strMass)
            {
                tmp = Math.round(Double.parseDouble(strMas));
                numbers.add((int)tmp);
            }
        }
        fileReader.close();

        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName2));
        String num = "";
        for (int a : numbers)
            num = num+a+" ";
        fileWriter.write(num);
        fileWriter.close();
    }
}
  /*

import com.sun.deploy.util.StringUtils;

import java.io.BufferedReader;
import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = br.readLine();
        String filename2 = br.readLine();
        File f = new File(filename1);
        BufferedReader fin = new BufferedReader(new FileReader(f));
        String line;

        while ((line = fin.readLine()) != null)
        {
            String aCats[] = line.split(" ");
            int[] round = new int[aCats.length];
            for (int i = 0; i < aCats.length; i++)
            {
                round[i] = (int) Math.round(Double.valueOf(aCats[i]));
                System.out.println(round[i]);
            }

            StringBuilder builder = new StringBuilder();

            for(long i : round){
                builder.append(i);
                builder.append(" ");
            }

            String res = builder.toString();

            // String source = "Кот Пушок и Кот Василий рыбку в озере ловили";
            char buffer[]= new char[res.length()];
            res.getChars(0, res.length(), buffer, 0) ;
            FileWriter fl= new FileWriter(filename2);
            fl.write(buffer);
            fl.close();

            br.close();


        }
    }
}
*/
