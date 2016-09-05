package misc;

import java.util.Stack;

/**
 * @author Nhan Nguyen.
 */
public class Duck {

    public static int countDuck(String input) {
        int count = 0;
        int[] freq = {0, 0, 0, 0, 0}; // store frequency of q, u, a, c, k
        Stack<Character> stack = new Stack<>();
        for (char i : input.toLowerCase().toCharArray()) {
            if (idxConverter(i) == -1) {
                return -1;
            }

            freq[idxConverter(i)] += 1;
            if (invalidInput(freq)) {
                return -1;
            }
            if (i == 'q') {
                stack.push(i);
            } else if (i == 'k') {
                stack.pop();
            }

            if (stack.size() > count) {
                count = stack.size();
            }
        }
        return count;
    }

    private static boolean invalidInput(int[] freq) {
        for (int i = 1; i < freq.length; i++) {
            if (freq[i - 1] < freq[i]) {
                return true;
            }
        }
        return false;
    }

    private static int idxConverter(char c) {
        switch(c) {
            case 'q': return 0;
            case 'u': return 1;
            case 'a': return 2;
            case 'c': return 3;
            case 'k': return 4;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(Duck.countDuck("quqacukqauackck"));
        System.out.println(Duck.countDuck("kcauq"));
        System.out.println(Duck.countDuck("quackquackquack"));
        System.out.println(Duck.countDuck("quqaquuacakcqckkuaquckqauckack"));
    }

}
