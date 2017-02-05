package com.javarush.test.level33.lesson15.big01.tests;

import com.javarush.test.level33.lesson15.big01.Helper;
import com.javarush.test.level33.lesson15.big01.Shortener;
import com.javarush.test.level33.lesson15.big01.strategies.*;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Andy on 18.09.2016.
 */
public class FunctionalTest
{
    public void testStorage(Shortener shortener){
        //Создавать три строки. Текст 1 и 3 строк должен быть одинаковым
        String s1 = Helper.generateRandomString();
        String s2 = Helper.generateRandomString();
        String s3 = s1;

        //Получать и сохранять идентификаторы для всех трех строк с помощью shortener
        Long id1 = shortener.getId(s1);
        Long id2 = shortener.getId(s2);
        Long id3 = shortener.getId(s3);
        //Проверять, что идентификатор для 2 строки не равен идентификатору для 1 и 3 строк
        Assert.assertNotEquals(id2, id1);
        Assert.assertNotEquals(id2, id3);

        Assert.assertEquals(id1,id3);

        String sNew1 = shortener.getString(id1);
        String sNew2 = shortener.getString(id2);
        String sNew3 = shortener.getString(id3);

        Assert.assertEquals(s1, sNew1);
        Assert.assertEquals(s2, sNew2);
        Assert.assertEquals(s3, sNew3);
    }
    @Test
    public void testHashMapStorageStrategy(){
        HashMapStorageStrategy hashMapStorageStrategy = new HashMapStorageStrategy();
        Shortener shortener = new Shortener(hashMapStorageStrategy);
        testStorage(shortener);
    }
    @Test
    public void testOurHashMapStorageStrategy(){
        OurHashMapStorageStrategy ourHashMapStorageStrategy = new OurHashMapStorageStrategy();
        Shortener shortener = new Shortener(ourHashMapStorageStrategy);
        testStorage(shortener);
    }
    @Test
    public void testFileStorageStrategy(){
        FileStorageStrategy fileStorageStrategy = new FileStorageStrategy();
        Shortener shortener = new Shortener(fileStorageStrategy);
        testStorage(shortener);
    }
    @Test
    public void testHashBiMapStorageStrategy(){
        HashBiMapStorageStrategy hashBiMapStorageStrategy = new HashBiMapStorageStrategy();
        Shortener shortener = new Shortener(hashBiMapStorageStrategy);
        testStorage(shortener);
    }
    @Test
    public void testDualHashBidiMapStorageStrategy(){
        DualHashBidiMapStorageStrategy dualHashBidiMapStorageStrategy = new DualHashBidiMapStorageStrategy();
        Shortener shortener = new Shortener(dualHashBidiMapStorageStrategy);
        testStorage(shortener);
    }
    @Test
    public void testOurHashBiMapStorageStrategy(){
        OurHashBiMapStorageStrategy ourHashBiMapStorageStrategy = new OurHashBiMapStorageStrategy();
        Shortener shortener = new Shortener(ourHashBiMapStorageStrategy);
        testStorage(shortener);
    }
}
/*
14.3.	Добавь класс FunctionalTest в пакет tests. В этом классе мы проверим
функциональность наших стратегий.
14.4.	Добавь в класс FunctionalTest метод testStorage(Shortener shortener). Он
должен:
14.4.1.	Создавать три строки. Текст 1 и 3 строк должен быть одинаковым.
14.4.2.	Получать и сохранять идентификаторы для всех трех строк с помощью
shortener.
14.4.3.	Проверять, что идентификатор для 2 строки не равен идентификатору для 1
и 3 строк. Подсказка: метод Assert.assertNotEquals.
14.4.4.	Проверять, что идентификаторы для 1 и 3 строк равны. Подсказка: метод
Assert.assertEquals.
14.4.5.	Получать три строки по трем идентификаторам с помощью shortener.
14.4.6.	Проверять, что строки, полученные в предыдущем пункте, эквивалентны
оригинальным. Подсказка: метод Assert.assertEquals.
14.5.	Добавь в класс FunctionalTest тесты:
14.5.1.	testHashMapStorageStrategy()
14.5.2.	testOurHashMapStorageStrategy()
14.5.3.	testFileStorageStrategy()
14.5.4.	testHashBiMapStorageStrategy()
14.5.5.	testDualHashBidiMapStorageStrategy()
14.5.6.	testOurHashBiMapStorageStrategy()
Каждый тест должен иметь аннотацию @Test, создавать подходящую стратегию,
создавать объект класса Shortener на базе этой стратегии и вызывать метод
testStorage для него.
Запусти и проверь, что все тесты проходят.
 */