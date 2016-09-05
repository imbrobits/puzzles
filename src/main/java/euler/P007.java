package euler;

import java.util.Scanner;

/**
 * Find the n-th prime number
 * @author Nhan Nguyen.
 */
public class P007 {
    public static void main( String[] args )
    {
        Scanner sc= new Scanner(System.in);
        long numberOfTestCase = sc.nextLong();
        for (long i = 0; i < numberOfTestCase; i++) {
            solve(sc.nextLong());
        }
    }

    private static void solve(long n) {
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
