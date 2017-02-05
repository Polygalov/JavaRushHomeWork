package com.javarush.test.level20.lesson10.home07;

import java.io.*;

/* Переопределение сериализации в потоке
Сериализация/десериализация Solution не работает.
Исправьте ошибки не меняя сигнатуры методов и класса.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать экземпляр класса Solution
2) записать в него данные  - writeObject
3) сериализовать класс Solution  - writeObject(ObjectOutputStream out)
4) десериализовать, получаем новый объект
5) записать в новый объект данные - writeObject
6) проверить, что в файле есть данные из п.2 и п.5
*/
public class Solution implements Serializable, AutoCloseable {
    transient private FileOutputStream stream;
    private String filename;

    public Solution(String fileName) throws FileNotFoundException {
        this.filename = fileName;
        this.stream = new FileOutputStream(fileName);
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        //out.close();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        //in.close();
        this.stream = new FileOutputStream(this.filename, true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main (String[] args) throws Exception
    {
        Solution solution1 = new Solution("D:\\1.txt");
        solution1.writeObject("Hi1");
        solution1.close();
        //SAVE
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\2.txt");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
        outputStream.writeObject(solution1);
        outputStream.flush();
        outputStream.close();
        //LOAD
        FileInputStream fileInputStream = new FileInputStream("D:\\2.txt");
        ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
        Solution solution2 = (Solution) inputStream.readObject();
        inputStream.close();
        solution2.writeObject("Hi2");
        solution2.writeObject("Hi3");
        solution2.close();
    }
}
