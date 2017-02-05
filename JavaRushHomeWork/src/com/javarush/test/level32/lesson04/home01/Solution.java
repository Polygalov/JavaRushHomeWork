package com.javarush.test.level32.lesson04.home01;


import java.io.*;

/* Читаем из потока
Реализуйте логику метода getAllDataFromInputStream. Он должен вернуть StringWriter, содержащий все данные из переданного потока.
Возвращаемый объект ни при каких условиях не должен быть null.
Метод main не участвует в тестировании.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("testFile.log"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException
    {
        //StringWriter sw = new StringWriter();
        if (is == null)
        {
            return new StringWriter();
        } else
        {
            Reader r = new InputStreamReader(is);
            StringWriter sw = new StringWriter();
            char[] buffer = new char[1024];
            for (int n; (n = r.read(buffer)) != -1; )
                sw.write(buffer, 0, n);

            return sw;
        }
    }
}
