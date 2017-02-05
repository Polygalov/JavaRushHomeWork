package com.javarush.test.level29.lesson15.big01.user;

public class UserHelper {
    private User userAnya = new User("Аня", "Смирнова", 10);
    private User userRoma = new User("Рома", "Виноградов", 30);

   // private boolean isManAnya = false;
   // private boolean isManRoma = true;


    public void printUsers() {
        userAnya.printInfo();
        userRoma.printInfo();
    }





    public int calculateAvarageAge() {

        User userUra = new User("Юра", "Карп", 28);


        return (userAnya.getAge() + userRoma.getAge() + userUra.getAge()) / 3;
    }

    public double calculateRate(double base, int age, boolean hasWork, boolean hasHouse) {
        double result=base;
        result += age / 100;
        result *= hasWork ? 1.1 : 0.9;
        result *= hasHouse ? 1.1 : 0.9;
        return result;
    }

    public String getBoosName(User user) {

        return user.getBoss();
    }

}
/*
13.1.	Извлечение метода. Добавь метод printInfo(), который будет выводить имя и фамилию
в консоль так же, как это делается в методе printUsers(). Замени повторяющийся код
метода printUsers() его вызовом.
13.2.	Встраивание метода. Избавься от метода ageLessThan16().
13.3.	Перемещение метода. Перемести методы printInfo() и printAdditionalInfo() в класс User.
13.4.	Расщепление переменной. Переменная age в методе calculateAvarageAge()
используется для разных промежуточных значений. Перепиши метод без использования
этой переменной.
13.5.	Удаление присваиваний параметрам. Перепиши метод calculateRate(), чтобы он не
пытался менять входные параметры, а просто возвращал рассчитанное значение.
 */