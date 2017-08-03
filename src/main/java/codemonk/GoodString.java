package codemonk;
//https://www.hackerearth.com/practice/algorithms/string-algorithm/string-searching/practice-problems/algorithm/little-monk-and-good-string/

import java.util.Arrays;
import java.util.Scanner;

class GoodString {
    public static void main(String args[]) throws Exception {

        Scanner s = new Scanner(System.in);
        String input = s.next();
        System.out.println(Arrays.stream(input.replaceAll("[^aeiou]+", "#").split("#")).mapToInt(x -> x.length()).max().orElse(0));
    }
}
