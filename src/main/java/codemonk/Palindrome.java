package codemonk;/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;
*/

import java.util.Scanner;

class Palindrome {
    public static void main(String args[]) throws Exception {

        //Scanner
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();

        String[] input = new String[N];
        for (int i = 0; i < N; i++) {
            String line = s.next();
            input[i] = line;
        }
        for (int i = 0; i < N; i++) {

            if (isPalindrome(input[i].trim())) {
                System.out.println(String.format("%s %s", "YES", input[i].length() % 2 == 1 ? "ODD" : "EVEN"));
            } else {
                System.out.println("NO");
            }

        }
    }

    private static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        if (s.length() == 1) {
            return true;
        }
        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) != s.charAt(s.length() - 1 - j)) {
                return false;
            }
            if (j >= s.length() - 1 - j) {
                break;
            }
        }
        return true;
    }
}
