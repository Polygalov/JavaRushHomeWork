package com.javarush.test.level15.lesson12.home05;

/**
 * Created by Andy on 13.02.2016.
 */
public class SubSolution extends Solution
{
    SubSolution()
    {
    }

    SubSolution(int a)
    {
        super(a);
    }

    SubSolution(int a, int b)
    {
        super(a, b);
    }
    private SubSolution (String c){}
    private SubSolution (double a){}
    private SubSolution (double a, int b){}

    protected SubSolution(boolean c)
    {
        super(c);
    }

    protected SubSolution(byte a)
    {
        super(a);
    }

    protected SubSolution(byte a, int b)
    {
        super(a, b);
    }

    public SubSolution(short c)
    {
        super(c);
    }

    public SubSolution(long a)
    {
        super(a);
    }

    public SubSolution(long a, int b)
    {
        super(a, b);
    }
}
