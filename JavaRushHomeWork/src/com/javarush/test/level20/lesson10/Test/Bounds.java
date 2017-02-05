package com.javarush.test.level20.lesson10.Test;
import java.util.*;     // Scanner
import java.io.File;

// These are also referred to as Armonstrong numbers
public class Bounds
{
    static int power[][]  = new int[10][10];
    static boolean TIMER =  true;
    static boolean DEBUG = false;
    static int discard = 0;

    public static void main(String[] args) throws Exception
    {  String filename = args.length > 0 ? args[0]
            : "b.in";
        Scanner inp = new Scanner(new File(filename));
        int n = inp.nextInt();
        int row, col;
        long initNano = System.nanoTime();

        // power[digit][power] will replace Math.pow(digit, power)
        // EVERYTHING to the zeroeth power is one.
        for (row = 0; row <= 9; row++)
            power[row][0] = 1;

        // For every successive power/col, generate from previous
        for (col = 1; col <= 9; col++)
            for (row = 0; row <= 9; row++)
                power[row][col] = power[row][col-1] * row;

        // String generated as 1 followed by zeroes:  that means
        // the highest-order digit goes 1 through 9, while all the
        // others go 0 through 9.
        while (n > 0)     // n initialized from inp upon creation.
        {  String start = String.format("%d", (int) Math.pow(10, n-1));
            long begin = System.nanoTime();

            if (n == 1)
                System.out.println("0^1 = 0");
            if (!discover(start, 0, 0))
                System.out.printf ("No %d digit numbers found\n", n);
            if (TIMER)
                System.out.printf("%3.3f seconds.\n",
                        1E-9*(System.nanoTime()-begin));
            if (DEBUG)
            {  System.out.printf("Discarded %d potential strings\n",
                    discard);
                discard = 0;
            }
            System.out.println();
            n = inp.nextInt();  // Get the next value of n
        }
        System.err.printf("Time required:  %.3f seconds\n",
                (System.nanoTime()-initNano)*1E-9);
    }

    // Boolean to detect if NO Narcissistic numbers exist.
    static boolean discover(String base, int partial, int idx)
    {  int n = base.length(); // Number of digits, length of string

        if (n == idx)     // We have a full one
        {  int digit[] = new int[n], sum = 0, k;
/* disable:  done when idx ==  n-1
         // Parity check:  sum the digits.
         for (k = 0; k < n; k++)
         {  digit[k] = base.charAt(k) - '0';
            sum += digit[k];
         }
         // Check against lowest-order digit.
         if (sum%2 != digit[n-1]%2)
            return false;
*/
            // Complete sum is already in partial
            sum = partial;
            if (sum != Integer.valueOf(base))
                return false;
            // First entry, no leading plus
            System.out.printf("%c^%d", base.charAt(0), idx);
//       System.out.printf("%d^%d", digit[0], idx);
//       for (k = 1; k < n; k++)  // All others have leading pluses
//          System.out.printf(" + %d^%d", digit[k], n);
            for (k = 1; k < n; k++)  // All others have leading pluses
                System.out.printf(" + %c^%d", base.charAt(k), n);
            System.out.printf(" = %d\n", sum);
            return true;
        }
        else    // Still generating candidates
        {  String  front = base.substring(0, idx), // Fixed portion
                back  = base.substring(idx+1);  // Still to come
            char    digit = base.charAt(idx);       // Digit being cycled
            boolean rtn = false;     // Did ANY of them work?
            // Range as xyz000.. through xyz999..
            long lower = Integer.valueOf(base),
                    upper = lower + (int)Math.pow(10, n-idx)-1;
            // Lower possible value is partial for trailing zeros
            long highv = partial + (long)power[9][n]*(n-idx); // Trailing nines

            if (idx == n-1)     // Doing lowest-order digit
            {  // Check parity; if even, lowest-order digit determines.
                // Otherwise this cannot generate a solution.
                if (partial%2 == 1)   // Odd parity
                    return false;
            }

            // Bounds check:  [partial..highv] vs. [lower..upper]
            if (highv < lower || partial > upper)
            {  if (DEBUG)
                System.out.printf("Reject %s:  %d to %d vs. %d to %d\n",
                        base, partial, highv, lower, upper);
//             discard += (int) Math.pow(10, n-idx);
                return false;
            }

            for ( ; digit <= '9'; digit++ )
            {  String fwd = front + digit + back;
                int    pp1 = partial+power[digit-'0'][n];

                // Avoid short-circuit evaluation's disabling recursion
                rtn = discover(fwd, pp1, idx+1) || rtn;
            }
            return rtn;
        }
    }
}