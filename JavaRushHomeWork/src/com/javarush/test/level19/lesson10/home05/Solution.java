package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        ArrayList<String> fileList = new ArrayList<String>();
        String str;

        while ((str = fileReader.readLine()) != null)
            fileList.add(str);

        fileReader.close();
        String source="";
        for (String aFileList : fileList)
        {
            String[] stringArray = aFileList.split(" ");
            for (int i = 0; i < stringArray.length; i++)
            {

                Pattern p = Pattern.compile("[0-9]+");
                Matcher m = p.matcher(stringArray[i]);
                if (m.find())
                {
                    source += stringArray[i]+" ";

                }


            }
        }
            char buffer[]= new char[source.length()];
            source.getChars(0, source.length(), buffer, 0) ;
            FileWriter fl= new FileWriter(args[1]);
            fl.write(buffer);
            fl.close();

    }
}
