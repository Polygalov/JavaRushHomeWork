package com.javarush.test.level14.lesson08.home09;

public abstract class Money
{
    private double amount = 1000;
    public Money(double amount)
    {
        this.amount =amount;
    }

    public  double getAmount()

    {
       // Money money = new Money();
        return amount;
    }

    public abstract String getCurrencyName();
}

