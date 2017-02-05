package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();

        BufferedReader fin = new BufferedReader(new FileReader(file1));
        FileWriter fout = new FileWriter(file2);

        String str = "";
        while(fin.ready())
            str = fin.readLine() + " ";

        String arr[] = str.split(" ");
        for(String word : arr){
            try {
                int a = Integer.parseInt(word);
                fout.write(a + " ");
            }catch(NumberFormatException e){}
        }

        fin.close();
        fout.close();
    }
}