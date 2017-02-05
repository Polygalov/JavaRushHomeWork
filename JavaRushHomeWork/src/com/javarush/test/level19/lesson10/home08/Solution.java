package com.javarush.test.level19.lesson10.home08;

/* Перевертыши
1 Считать с консоли имя файла.
2 Для каждой строки в файле:
2.1 переставить все символы в обратном порядке
2.2 вывести на экран
3 Закрыть потоки. Не использовать try-with-resources

Пример тела входного файла:
я - программист.
Амиго

Пример результата:
.тсиммаргорп - я
огимА
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();
        File f = new File(name);
        BufferedReader fin = new BufferedReader(new FileReader(f));

        String line;
        while ((line = fin.readLine()) != null)
            {
                StringBuilder input1 = new StringBuilder();
                input1.append(line);
                input1=input1.reverse();
                for (int i=0;i<input1.length();i++)
                {
                    System.out.print(input1.charAt(i));
                }
                System.out.println();

            }
        br.close();
        fin.close();
    }
}
