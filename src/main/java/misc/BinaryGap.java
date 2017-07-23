package misc;// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class BinaryGap {
    public static void main(String[] args) {
        BinaryGap s = new BinaryGap();
        //System.out.println(s.solution(2));
        System.out.println(s.solution(1041));
    }
    public int solution(int N) {
        int n = N;
        int maxGap = 0;
        int counter= -1;
        while (n/2 >0) {
            System.out.print(n%2);
            if(n%2 == 1 && counter == -1) {
                counter = 0;
                n= n/2;
                continue;
            }
            if (counter != -1 && n%2 == 0) {
                counter++;
            }
            if(n%2 == 1) {
                maxGap = maxGap > counter ? maxGap : counter;
                counter = 0;
            }
            n= n/2;
        }
        maxGap = maxGap > counter ? maxGap : counter;
        return maxGap;
    }
}