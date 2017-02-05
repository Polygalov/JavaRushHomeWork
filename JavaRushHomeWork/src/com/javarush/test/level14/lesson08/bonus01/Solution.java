package com.javarush.test.level14.lesson08.bonus01;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception
        try
        {
            float i = 1 / 0;

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        //Add your code here
        try{
            int a[]=new int[10];
            //Array has only 10 elements
            a[11] = 9;
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            exceptions.add(e);
        }
        try{
            int num=Integer.parseInt ("XYZ") ;
            System.out.println(num);
        }catch(NumberFormatException e){
            exceptions.add(e);
        }
        try{
            String str="easysteps2buildwebsite";
            //System.out.println(str.length());;
            char c = str.charAt(0);
            c = str.charAt(40);
           // System.out.println(c);
        }catch(StringIndexOutOfBoundsException e){
            exceptions.add(e);
        }
        try{
            String str=null;
            System.out.println (str.length());
        }catch(NullPointerException e){
            exceptions.add(e);
        }
        Object szStr[] = new String[10];

        try
        {
            szStr[0] = new Character('*');
        }
        catch(Exception e)
        {
            exceptions.add(e);
        }
        Object ch = new Character('*');

        try
        {
            System.out.println((Byte)ch);
        }
        catch(Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            int[] nNegArray = new int[-5];
        }
        catch(Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            Date lowDate = sdf.parse("test");
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            InputStream stream = new FileInputStream("test");
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
    }
}
