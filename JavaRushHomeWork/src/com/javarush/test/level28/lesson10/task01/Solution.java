package com.javarush.test.level28.lesson10.task01;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/* Осваиваем Callable
Реализуйте логику метода getTask, который должен возвращать объект Callable.
Объект Callable должен вычислять сумму всех чисел от 1 до переданного числа i включая его, и возвращать его в виде строки
Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<Future<String>> futures = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 1000; i <= 1010; i++) {
            futures.add(executor.submit(getTask(i)));
        }

        futures.add(executor.submit(getTask(10000000)));

        for(Future<String> future : futures) {
            System.out.println(future.get());
        }

        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);

/* output
500500
501501
502503
503506
504510
505515
506521
507528
508536
509545
510555
50000005000000
*/
    }

    public static Callable<String> getTask(final int i) {
        Callable<String> callable = new Callable<String>(){
            @Override
            public String call() throws Exception
            {long c=i;
                long b=(i+1);

                BigInteger d, e, f, m,l;
                d = BigInteger.valueOf(c);
                e = BigInteger.valueOf(b);
                l = BigInteger.valueOf(2);


                f = d.multiply(e);
                m = f.divide(l);
                return m.toString();
        }
        };
        return callable;
    }
}