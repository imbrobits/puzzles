package euler;

import java.util.Scanner;

/**
 * 2520 is the smallest number that can be divided by each of the numbers from 11 to 1010 without any remainder.
 * What is the smallest positive number that is evenly divisible(divisible with no remainder) by all of the numbers from 1 to N?
 * @author Nhan Nguyen.
 */

public class P005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long numberOfTestCase = sc.nextLong();
        for (long i = 0; i < numberOfTestCase; i++) {
            solve(sc.nextLong());
        }
    }

    private static void solve(long n) {
        long[] largestPrimeFactors = new long[41];
        int i = 1;
        while (i <= n) {
            primeFactorize(i, largestPrimeFactors);
            i++;
        }
        System.out.println(productOfPrimePowers(largestPrimeFactors));
    }

    private static long productOfPrimePowers(long[] largestPrimeFactors) {
        long result = 1;
        for (int i = 1; i < largestPrimeFactors.length; i++) {
            if (largestPrimeFactors[i] != 0) {
                result *= Math.pow(i, largestPrimeFactors[i]);
            }
        }
        return result;
    }

    private static void primeFactorize(int k, long[] largestPrimeFactors) {
        long power = 0;
        for (int i = 2; i <= k; i++) {
            if (k % i == 0) {
                power++;
                k /= i;
                largestPrimeFactors[i] = Math.max(power, largestPrimeFactors[i]);
                i--;
            } else {
                power = 0;
            }
        }
    }
}
