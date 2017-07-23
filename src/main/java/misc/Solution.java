package misc;

//TODO SLOW SOLUTION
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        String s = in.next();
        int maxlen = 0;

        List<Character> chars = s.chars().collect(ArrayList::new,
                (x, y) -> x.add((char)y),
                (x, y) -> x.addAll(y));
        if (chars.size() < 2) {
            System.out.println(0);
            return;
        }
        for (int i = 0; i < chars.size(); i++) {
            for (int j = 0; j < chars.size(); j++) {
                if (i == j) {
                    continue;
                }
                String except = new StringBuilder().append(chars.get(i)).append(chars.get(j)).toString();
                String s1 = removeChars(s, except);
                if (valid(s1) && s1.length() > maxlen) {
                    maxlen = s1.length();
                }
            }
        }
        System.out.println(maxlen);
    }

    private static String removeChars(String input, String except) {
        return input.replaceAll("[^" + except.toString() + "]+", "");
    }

    private static boolean valid(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }
}
