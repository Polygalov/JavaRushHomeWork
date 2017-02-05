package com.javarush.test.level29.lesson15.big01.human;

import java.util.ArrayList;
import java.util.List;

public class StudentsDataBase {
    public static List<Student> students = new ArrayList<>();

    public static void addInfoAboutStudent(Student student) {

        students.add(student);
        printInfoAboutStudent(student);

    }

    public static void printInfoAboutStudent(Student student) {
        System.out.println("Имя: " + student.getName() + " Возраст: " + student.getAge());
    }

    public static void removeStudent(int index) {
        if (index>=0 && index<students.size())
        students.remove(index);
    }

    public static void findDimaOrSasha() {
       // boolean found = false;
        for (int i = 0; i < students.size(); i++) {
           // if (!found) {
                if (students.get(i).getName().equals("Dima")) {
                    System.out.println("Студент Dima есть в базе.");
                    break;
                }

                if (students.get(i).getName().equals("Sasha")) {
                    System.out.println("Студент Sasha есть в базе.");
                    break;
                }

        }
    }
}
/*
8.3.	Замена исключения проверкой условия. Перепиши метод removeStudent(int index), чтобы
он удалял студента из списка студентов только, если он там есть. Метод не должен кидать
исключение.
8.4.	Удаление управляющего флага. Перепиши метод findDimaOrSasha(), сохранив логику его
работы. В методе не должны использоваться флаги типа found, воспользуйся оператором
break.
 */