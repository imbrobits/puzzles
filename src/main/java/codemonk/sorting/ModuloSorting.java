package codemonk.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

class ModuloSorting {
    public static void main(String args[] ) throws Exception {

        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int m = s.nextInt();
        List<Integer> input = new ArrayList<>();
        IntStream.range(0, N).forEach(x -> input.add(s.nextInt()));
        Collections.sort(input, (o1, o2) -> o1 % m - o2 % m);
        input.stream().forEach(x -> System.out.print(x + " "));
    }
}