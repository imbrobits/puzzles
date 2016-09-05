package euler;

import java.util.Scanner;

/**
 * Find the greatest product of K consecutive digits in the N digit number.
 * @author Nhan Nguyen.
 */

public class P008 {
    public static void main( String[] args )
    {
        Scanner sc= new Scanner(System.in);
        long numberOfTestCase = sc.nextLong();
        for (long i = 0; i < numberOfTestCase; i++) {
            sc.nextLong();
            int k = sc.nextInt();
            String input = sc.next();
            solve(input, k);
        }
    }

    private static void solve(String input, int k) {
        int max = 0;
        for (int i = 0; i < input.length() - k; i++) {
            if (max < segmentProduct(input, i, k)) {
                max = segmentProduct(input, i, k);
            }
        }
        System.out.println(max);
    }

    private static int segmentProduct(String input, int idx, int k) {
        int product = 1;
        for (int i = 0; i < k; i++) {
            product *= Integer.parseInt(String.valueOf(input.charAt(idx + i))) ;
        }
        return product;
    }
}
