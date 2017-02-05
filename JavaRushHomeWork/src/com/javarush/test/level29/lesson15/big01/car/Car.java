package com.javarush.test.level29.lesson15.big01.car;

import java.util.Date;

public abstract class Car
{
    static public final int TRUCK = 0;
    static public final int SEDAN = 1;
    static public final int CABRIOLET = 2;
    double fuel;
    public double summerFuelConsumption;
    public double winterFuelConsumption;
    public double winterWarmingUp;
    private int type;
    private boolean driverAvailable;
    private int numberOfPassengers;

    protected Car(int type, int numberOfPassengers)
    {
        this.type = type;
        this.numberOfPassengers = numberOfPassengers;
    }

    public static Car create(int type, int numberOfPassengers)
    {
        switch (type)
        {
            case CABRIOLET:
                return new Cabriolet(numberOfPassengers);
            case SEDAN:
                return new Sedan(numberOfPassengers);
            case TRUCK:
                return new Truck(numberOfPassengers);
            default:
                return null;
        }
    }

    public void fill(double numberOfLiters) throws Exception
    {
        if (numberOfLiters < 0)
        {
            throw new Exception();
        }
        fuel += numberOfLiters;
    }

    private boolean canPassengersBeTransferred()
    {
        return (isDriverAvailable() && fuel > 0);
    }

    public boolean isSummer(Date date, Date summerStart, Date summerEnd)
    {
        return !(date.before(summerStart) || date.after(summerEnd));
    }

    public double getWinterConsumption(int length)
    {
        return length * winterFuelConsumption + winterWarmingUp;
    }

    public double getSummerConsumption(int length)
    {
        return length * summerFuelConsumption;
    }

    public double getTripConsumption(Date date, int length, Date SummerStart, Date SummerEnd)
    {
        double consumption;
        if (!isSummer(date, SummerStart, SummerEnd))
        {
            consumption = getWinterConsumption(length);
        } else
        {
            consumption = getSummerConsumption(length);
        }
        return consumption;
    }

    public int getNumberOfPassengersCanBeTransferred()
    {
        if (!canPassengersBeTransferred())
        {
            return 0;
        }
        return numberOfPassengers;
    }

    public boolean isDriverAvailable()
    {
        return driverAvailable;
    }

    public void setDriverAvailable(boolean driverAvailable)
    {
        this.driverAvailable = driverAvailable;
    }

    public void startMoving()
    {
        if (numberOfPassengers > 0)
        {
            fastenPassengersBelts();
        }
        fastenDriverBelt();
    }

    public void fastenPassengersBelts()
    {
    }

    public void fastenDriverBelt()
    {
    }

    abstract public int getMaxSpeed();
}
/*
12.1.	Объединение условных операторов.
12.1.1.	Добавь внутренний метод, сообщающий, могут ли быть перевезены пассажиры
boolean canPassengersBeTransferred() в класс Car. Метод должен возвращать true, если
водитель доступен isDriverAvailable и есть топливо fuel.
12.1.2.	Перепиши метод getNumberOfPassengersCanBeTransferred(), объединив условные
операторы (используй метод canPassengersBeTransferred()).
12.2.	Объединение дублирующихся фрагментов в условных операторах. Перепиши метод
startMoving(), чтобы в нем не было повторяющихся вызовов функций.
12.3.	Замена магического числа символьной константой. Замени магические числа в методе
getMaxSpeed() на константные переменные метода: MAX_TRUCK_SPEED,
MAX_SEDAN_SPEED и MAX_CABRIOLET_SPEED.
12.4.	Замена условного оператора полиморфизмом.
12.4.1.	Переопредели метод getMaxSpeed() в подклассах, избавившись от условного
оператора.
12.4.2.	Метод getMaxSpeed() в классе Car сделай абстрактным.
 */