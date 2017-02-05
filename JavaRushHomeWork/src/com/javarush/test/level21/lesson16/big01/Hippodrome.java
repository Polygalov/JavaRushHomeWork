package com.javarush.test.level21.lesson16.big01;




import java.util.ArrayList;

/**
 * Created by Andy on 22.05.2016.
 */
public class Hippodrome
{
    ArrayList<Horse> horses = new ArrayList<Horse>();

    public ArrayList<Horse> getHorses()
    {
        return horses;
    }
    public static Hippodrome game;
    public static void main(String[] args) throws InterruptedException
    {
       game = new Hippodrome();
        Horse one = new Horse("Лиза", 3, 0);
        Horse two = new Horse("Гнедая", 3, 0);
        Horse three = new Horse("Хромая", 3, 0);
        game.getHorses().add(one);
        game.getHorses().add(two);
        game.getHorses().add(three);
        game.run();
        game.printWinner();
    }
    public void  run() throws InterruptedException
    {
    for (int i=0; i<100; i++){
        move();
        print();
        Thread.sleep(200);
}
    }
    public void move(){
        for (Horse text: horses)
        {
           text.move();
        }
    }
    public void print(){
        for (Horse text: horses)
        {
            text.print();
        }
        System.out.println();
        System.out.println();
    }
    public Horse getWinner() {
        Horse winner = horses.get(0);
        for (Horse horse : horses)
        {
            if (horse.getDistance() > winner.getDistance())
                winner = horse;
        }
        return winner;
    }

    public void printWinner() {
        System.out.println("Winner is "+getWinner().getName()+"!");
    }
}

/*
В классе Hippodrome сделаем два метода:
public Horse getWinner() и public void printWinner()

Метод getWinner должен возвращать лошадь пробежавшую самую большую дистанцию.
Метод printWinner выводит на экран имя победителя в виде:
Winner is <NAME>!
Пример:
Winner is Lucky!
 */