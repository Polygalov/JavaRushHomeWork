package com.javarush.test.level19.lesson03.task02;

/* Адаптер
Используйте класс AdapterFileOutputStream, чтобы адаптировать FileOutputStream к новому интерфейсу AmigoStringWriter
*/

import java.io.*;

public class AdapterFileOutputStream implements AmigoStringWriter {
    private FileOutputStream list;
    AdapterFileOutputStream(FileOutputStream list)
    {
        this.list = list;
    }

    @Override
    public void flush() throws IOException
    {
        this.list.flush();
    }

    @Override
    public void writeString(String s) throws IOException
    {
        this.list.write(s.getBytes());
    }

    @Override
    public void close() throws IOException
    {
        this.list.close();
    }
}

