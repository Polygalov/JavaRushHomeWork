package com.javarush.test.level17.lesson10.bonus02;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

            if (args[0].equals("-c")) {
                Person person;
                for (int i = 1; i<= ((args.length-1)/3); i++)
                {
                    if (args[(i*3)-1].equals("м"))
                    {
                        person = Person.createMale(args[(i*3)-2], dateFormat.parse(args[i*3]));
                    } else
                    {
                        person = Person.createFemale(args[(i*3)-2], dateFormat.parse(args[i*3]));
                    }
                    allPeople.add(person);
                    System.out.println(allPeople.indexOf(person));
                }
            } else if (args[0].equals("-u")) {
                for (int i = 1; i<= ((args.length-1)/4); i++)
                {
                    allPeople.get(Integer.parseInt(args[(i*4)-3])).setName(args[(i*4)-2]);
                    if (args[(i*4)-1].equals("м"))
                        allPeople.get(Integer.parseInt(args[(i*4)-3])).setSex(Sex.MALE);
                    else if (args[(i*4)-1].equals("ж"))
                        allPeople.get(Integer.parseInt(args[(i*4)-3])).setSex(Sex.FEMALE);
                    allPeople.get(Integer.parseInt(args[(i*4)-3])).setBirthDay(dateFormat.parse(args[i*4]));
                }
            } else if (args[0].equals("-d")) {
                for (int i = 1; i< args.length; i++){
                allPeople.get(Integer.parseInt(args[i])).setBirthDay(null);}
            } else if (args[0].equals("-i")) {
                dateFormat = new SimpleDateFormat("dd-MMM-YYYY", Locale.ENGLISH);
                for (int i = 1; i< args.length; i++)
                {
                    System.out.println(allPeople.get(Integer.parseInt(args[i])).getName() + " " +
                            (allPeople.get(Integer.parseInt(args[i])).getSex().equals(Sex.MALE) ? "м" : "ж") + " " +
                            dateFormat.format(allPeople.get(Integer.parseInt(args[i])).getBirthDay()));
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}