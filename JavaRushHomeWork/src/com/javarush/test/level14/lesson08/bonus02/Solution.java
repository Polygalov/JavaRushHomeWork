package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/


import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int nod = 1;
        for (int i=2; i<=a; i++) {
            if ((a % i == 0) && (b % i == 0))
            {
                nod = i;
            }
        }
        System.out.println(nod);
    }
}
/*
public class Solution
{
    public static void main(String[] args) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1=br.readLine();
        String s2=br.readLine();
        int a = Integer.parseInt(s1);
        int b = Integer.parseInt(s2);
        int c = maxDiv(a,b);
        System.out.println(c);

    }

    public static int maxDiv(int w, int q)
    {
        int c = 0;

        int i = 1;
        while (i <= q && i <= w)
        {
            if ((q%i)==0 && (w%i)==0)
            {
                c = i;
                i++;
            }
            else
                i++;
        }
        return c;

    }
}
*/
       /* BufferedReader reader = new BufferedReader(new InputStreamReader(System.in) );
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        List<Integer> list = new ArrayList<Integer>();
        for (int i=1; i<=a; i++)
        {
            int key =a/i;
            if (a%i==0){
                list.add(key);

            }

        }

        List<Integer> list2 = new ArrayList<Integer>();
        for (int i=1; i<=b; i++)
        {
            int key =b/i;
            if (b%i==0){
                list2.add(key);

            }

        }
        List<Integer> list3 = new ArrayList<Integer>();
        for (int i=0; i<list.size(); i++){
            for (int j=0; j<list2.size(); j++){
                if (list.get(i)==list2.get(j)){
                    list3.add(list.get(i));
                }
            }
        }
        Collections.sort(list3);
        System.out.println(list3.get((list3.size())-1));
    }
}
*/