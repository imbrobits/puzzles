package codemonk;

import java.util.Scanner;

/**
 * https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/monk-and-rotation-3/
 */
class MonkNRotation {
    private static StringBuilder builder= new StringBuilder();
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        for (int i = 0; i < N; i++) {
            int len = s.nextInt(); // skip length
            int rotations = s.nextInt();
            int[] input = new int[len];
            for (int j = 0; j < len; j++) {
                input[j] = s.nextInt();

            }
            printRotations(rotations, input);
            builder.append("\n");
        }
        System.out.println(builder.toString());
    }

    private static void printRotations(int rotations , int[] str) {
        rotations = rotations % str.length;
        int startIdx = str.length - rotations;
        if (startIdx == str.length) {
            startIdx = 0;
        }
        int i = 0;
        while (i < str.length) {
            builder.append(str[startIdx] + " ");
            startIdx++;
            i++;
            if (startIdx == str.length) {
                startIdx = 0;
            }
        }
    }
}
