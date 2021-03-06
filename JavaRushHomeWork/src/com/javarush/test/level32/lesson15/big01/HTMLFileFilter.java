package com.javarush.test.level32.lesson15.big01;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * Created by Andy on 10.09.2016.
 */
public class HTMLFileFilter extends FileFilter
{
    @Override
    public boolean accept(File file)
    {
        if (file.isDirectory()){
            return true;
             }
        else if (!file.isDirectory()){
            String fileName = file.getName().toLowerCase();
            return fileName.endsWith(".html") || fileName.endsWith(".htm");

        }
        return false;
    }

    @Override
    public String getDescription()
    {
        return "HTML и HTM файлы";
    }
}
/*
Для открытия или сохранения файла мы будем использовать JFileChooser из библиотеки swing.
Объекты этого типа поддерживают фильтры, унаследованные от FileFilter. Сейчас мы напишем
свой фильт:
21.1.	Создай публичный класс HTMLFileFilter унаследованный от FileFilter.
21.2.	Мы хотим, чтобы окно выбора файла отображало только html/htm файлы или папки.
Переопредели метод accept(File file), чтобы он возвращал true, если переданный файл
директория или содержит в конце имени ".html" или ".htm" без учета регистра.
21.3.	Чтобы в окне выбора файла в описании доступных типов файлов отображался текст
"HTML и HTM файлы" переопредели соответствующим образом метод getDescription().
 */