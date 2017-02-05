package com.javarush.test.level22.lesson13.task02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/* Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
*/
public class Solution {

    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
        Charset utf8 = Charset.forName("UTF-8");
        Charset windows1251 = Charset.forName("Windows-1251");
        FileOutputStream outputStream = new FileOutputStream(args[1]);

        FileInputStream inputStream = new FileInputStream(args[0]);
        byte[]buffer = new byte[inputStream.available()];
        inputStream.read(buffer);
        String s = new String(buffer,utf8);
        buffer = s.getBytes(windows1251);
        outputStream.write(buffer);
       /*
        while (inputStream.available() > 0) //пока есть еще непрочитанные байты
        {
            int data = inputStream.read(); // прочитать очередной байт в переменную data
            outputStream.write(data); // и записать его во второй поток
        }
        */
        inputStream.close();
        outputStream.close();

    }
}
