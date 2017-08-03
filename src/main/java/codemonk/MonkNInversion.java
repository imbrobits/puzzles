package serverchecker;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class MonkNInversion {
    private static List<Node> nodes;
    private static int[][] matrix;
    private static int dim;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int n = 0; n < testCases; n++) {
            dim = scanner.nextInt();
            int inversions = 0;
            nodes = new ArrayList<>();
            matrix = new int[dim + 1][dim + 1];
            // initialize array
            for (int i = 0; i < dim; ++i) {
                for (int j = 0; j < dim; ++j) {
                    int val = scanner.nextInt();
                    nodes.add(new Node(i + 1, j + 1, -val));
                }
            }
            // sort the list descending
            nodes.sort((node1, node2) -> node1.val - node2.val);
            // traverse nodes and query
            int i = 0;
            while (i < nodes.size()) {
                int curr = i;
                List<Node> pairs = new ArrayList<>();
                while (curr < nodes.size() && nodes.get(curr).val == nodes.get(i).val) {
                    pairs.add(new Node(nodes.get(curr).x, nodes.get(curr).y, nodes.get(curr).val));
                    inversions += getSum(nodes.get(curr).x, nodes.get(curr).y);
                    curr++;
                }
                for (int j = 0; j < pairs.size(); ++j) {
                    update(pairs.get(j).x, pairs.get(j).y, 1);
                }
                i=curr;
            }
            System.out.println(inversions);
        }
    }

    private static int getSum(int l, int r) {
        int ret = 0;
        for (int i = l; i > 0; i -= i & -i)
            for (int j = r; j > 0; j -= j & -j)
                ret += matrix[i][j];
        return ret;
    }

    private static void update(int x, int y, int val) {
        for (int i = x; i <= dim; i += i & -i)
            for (int j = y; j <= dim; j += j & -j)
                matrix[i][j] += val;
    }

    private static class Node {
        int x;
        int y;
        int val;

        Node(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
}