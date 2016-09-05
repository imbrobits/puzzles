package euler;

import java.util.Scanner;

/**
 * Find the difference between the sum of the squares of the first N natural numbers and the square of the sum.
 * @author Nhan Nguyen.
 */
public class P006 {
    public static void main( String[] args )
    {
        Scanner sc= new Scanner(System.in);
        long numberOfTestCase = sc.nextLong();
        for (long i = 0; i < numberOfTestCase; i++) {
            solve(sc.nextLong());
        }
    }

    public static void solve(long n) {
        System.out.println(squareOfSums(n) - sumOfSquares(n));
    }

    private static long sumOfSquares(long n) {
        return n*(n+1)*(2*n+1)/6;
    }

    private static long squareOfSums(long n) {
        long sum = n * (n+1) / 2;
        return sum * sum;
    }
}
