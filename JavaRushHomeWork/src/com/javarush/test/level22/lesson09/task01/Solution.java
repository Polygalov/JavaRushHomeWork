package com.javarush.test.level22.lesson09.task01;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример содержимого файла
рот тор торт о
о тот тот тот
Вывод:
рот тор
о о
тот тот
*/
public class Solution
{
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException
    {
        ArrayList<String> tmp = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();

        Scanner in = new Scanner(new File(file1));
        StringBuilder data = new StringBuilder();
        while (in.hasNext())
            data.append(in.nextLine()).append(" ");
        String[] words = data.toString().split(" ");
        for (int i = 0; i < words.length; i++)
        {
            if (words[i] == null || words[i].isEmpty())
                continue;

            StringBuilder sb = new StringBuilder(words[i]);
            sb.reverse();
            for (int j = 0; j < words.length; j++)
            {
                //System.out.println(words[j]+" test");
                if (words[j] == null || words[j].isEmpty())
                    continue;
                if (j==i)
                    continue;
                if (sb.toString().equals(words[j]))
                {
                    Pair pair = new Pair();
                    pair.first = words[i];
                    pair.second = words[j];
                    result.add(pair);
                    // remove matched words
                    words[i] = "";
                    words[j] = "";
                    break;
                }
            }
        }


    for( Pair con:result)
    {
        System.out.println(con);
    }

}
    public static class Pair {
        String first;
        String second;

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
