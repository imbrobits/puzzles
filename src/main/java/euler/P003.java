package euler;

/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of a given number N?
 */

import java.util.Scanner;

/**
 * @author Nhan Nguyen.
 */

public class P003 {
    public static void main( String[] args )
    {
        Scanner sc=new Scanner(System.in);
        long numberOfTestCase = sc.nextLong();
        for (long i = 0; i < numberOfTestCase; i++) {
            System.out.println(solve(sc.nextLong()));
        }
    }

    public static long solve(long number) {
        long i;

        while (number % 2 == 0) {
            number /= 2;
        }

        if (number == 1) {
            return 2;
        }

        for (i = 3; i*i <= number; i+=2) {

            if (number % i == 0) {
                number /= i;
                i -= 2;
            }
        }

        if (number > 2) {
            return number;
        }
        return i;
    }

}

