package com.javarush.test.level09.lesson08.task04;

import java.io.IOException;
import java.nio.file.FileSystemException;
import java.rmi.RemoteException;

/* Перехват checked исключений
В методе processExceptions обработайте все checked исключения.
Нужно вывести на экран каждое возникшее checked исключение.
Можно использовать только один блок try..
*/

public class Solution {
    public static void main(String[] args) {

        processExceptions(new Solution());


    }

    public static void processExceptions(Solution obj) {
        try
       {
            obj.method1();
            obj.method2();
            obj.method3();
        }
        //п.2 создаем catch под первый возникший Exception
        catch (IOException e){
            System.out.println(e);
        }

        //п.3 создаем catch под второй возникший Exception
        catch (NoSuchFieldException e){
            System.out.println(e);
        }
    }

    public void method1() throws IOException {
        throw new IOException();
    }

    public void method2() throws NoSuchFieldException {
        throw new NoSuchFieldException();
    }

    public void method3() throws RemoteException {
        throw new RemoteException();
    }
}
