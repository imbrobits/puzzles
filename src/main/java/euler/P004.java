package euler;

/**
 * A palindromic number reads the same both ways. The smallest 6 digit palindrome made from the product of two 3-digit
 * numbers is 101101=143×707101101=143×707.
 * Find the largest palindrome made from the product of two 3-digit numbers which is less than N.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Nhan Nguyen.
 */
public class P004 {
    private static List<Long> palList;
    public static void main( String[] args )
    {
        Scanner sc=new Scanner(System.in);
        buildPalindromeList();
        long numberOfTestCase = sc.nextLong();
        for (long i = 0; i < numberOfTestCase; i++) {
            solve(sc.nextLong());
        }
    }

    private static void solve(long n) {
        long result = -99999;
        for (long num : palList) {
            if (num > n) {
                System.out.println(result);
                return;
            }
            result = num;
        }
    }

    private static void buildPalindromeList() {
        palList = new ArrayList<>();
        for (int i = 100; i <999; i++) {
            for (int j = 100; j <999; j++) {
                if (isPalindrome(i*j) && !palList.contains((long)i*j)) {
                    palList.add((long)i*j);
                }
            }
        }
        palList.sort(Long::compareTo);
    }

    private static boolean isPalindrome(long num) {
        return Long.toString(num).equals(
                new StringBuilder().append(Long.toString(num)).reverse().toString());
    }
}
