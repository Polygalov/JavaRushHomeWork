package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.*;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        while (!fileName.equals("exit"))
        {

            ReadThread tread = new ReadThread(fileName);
            tread.start();
            fileName = br.readLine();
        }
        br.close();

    }


    public static class ReadThread extends Thread {
        private String fileName;
        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут
        public void run()
        {
            List<Integer> integerList = new ArrayList<Integer>();
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            List<Integer> countList = new ArrayList<Integer>();


            FileInputStream inputStream = null;
            try
            {
                inputStream = new FileInputStream(fileName);
            }
            catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }

            int count = 0;
            int maxValue = 0;

            try
            {
                while(inputStream.available() > 0){
                    int data = inputStream.read();
                    integerList.add(data);
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

            for (Integer i : integerList){
                count = Collections.frequency(integerList, i);
                map.put(i, count);
            }

            for(Map.Entry<Integer, Integer> pair : map.entrySet()){
                Integer value = pair.getValue();
                countList.add(value);

            }

            maxValue = countList.get(0);
            for (int i = 1; i < countList.size(); i++)
            {
                if (maxValue < countList.get(i)){
                    maxValue = countList.get(i);
                }
            }


            for(Map.Entry<Integer, Integer> pair : map.entrySet()){
                Integer key = pair.getKey();

                if (pair.getValue().equals(maxValue)){
                    resultMap.put(this.fileName, key);
                }
            }


            try
            {
                inputStream.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
