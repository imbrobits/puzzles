package codefights;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * misc.Solution for CodeFights weekly challenges
 * https://codefights.com/challenge/mMdsrajm7T9H87Noc/main
 *
 * TODO: check the list below
 * - Improve command solution by using adjacency matrices / list (avoid brute-force)
 * - Improve quick tests
 * - Clean up code
 * @author Nhan Nguyen.
 */
public class LabyrinthNavigation {

    public int labyrinthNavigation(String[] labyrinth, int[] start, int[] dest) {
        return new BFScout(labyrinth, start, dest).minimalSequence();
    }

    private static class BFScout {
        private static final int[] zero = {0, 0};
        private final int rowNum;
        private final int colNum;
        private final int rowDelta;
        private final int colDelta;
        private String[] matrix;
        private int[] start;
        private int[] dest;
        private Queue<String> bfsQueue = new LinkedList<>();

        private BFScout(String[] labyrinth, int[] start, int[] dest) {
            this.start = start;
            this.dest = dest;
            this.matrix = labyrinth;
            this.rowNum = matrix.length;
            this.colNum = matrix[0].length();
            this.rowDelta = dest[0] - start[0];
            this.colDelta = dest[1] - start[1];
        }


        private int minimalSequence() {
            bfsQueue.add("U");
            bfsQueue.add("L");
            bfsQueue.add("D");
            bfsQueue.add("R");
            while (!bfsQueue.isEmpty()) {
                String seq = bfsQueue.remove();
                if (testSeq(seq)) {
                    System.out.println(seq);
                    return seq.length();
                }
            }
            //timeout
            return -1;
        }

        private boolean testSeq(String seq) {
            Result rs = quickEval(seq);
            if (rs.isBlock()) {
                return false;
            }
            if (rs.isInvalid()) {
                generateSeq(seq);
                return false;
            }
            // run the cycle command once to check if it hit

            int[] pos = Arrays.copyOf(start, start.length);

            // run until hitting the boundaries or blocked cell
            int idx = 0;
            while ((0 <= pos[0] && pos[0] < rowNum) && (0 <= pos[1] && pos[1] < colNum)) {

                if (isBlocked(pos)) {
                    generateSeq(seq);
                    return false;
                }

                if (Arrays.equals(pos, dest)) {
                    return true;
                }

                move(String.valueOf(seq.charAt(idx)), pos);

                idx = (++idx == seq.length()) ? 0 : idx;
            }

            generateSeq(seq);
            return false;
        }

        private int[] move(String seq, int[] pos) {
            for (char i : seq.toCharArray()) {
                switch (i) {
                    case 'U':
                        pos[0]--;
                        break;
                    case 'D':
                        pos[0]++;
                        break;
                    case 'L':
                        pos[1]--;
                        break;
                    case 'R':
                        pos[1]++;
                        break;
                }
            }
            return pos;
        }

        private Result quickEval(String seq) {
            int[] pos = Arrays.copyOf(start, start.length);
            int[] cycle = cycleEval(seq);

            if (Math.abs(cycle[0]) >= matrix.length || Math.abs(cycle[1]) >= matrix[0].length()) {
                return Result.BLOCKED;
            }

            for (char c : seq.toCharArray()) {

                move(String.valueOf(c), pos);

                if (!((0 <= pos[0] && pos[0] < rowNum) && (0 <= pos[1] && pos[1] < colNum))) {
                    return Result.BLOCKED;
                }

                if (isBlocked(pos)) {
                    return Result.BLOCKED;
                }

                if (Arrays.equals(pos, dest)) {
                    return Result.OK;
                }
            }


            return !Arrays.equals(cycle, zero)
                    && !((rowDelta * cycle[0] <= 0) && (colDelta * cycle[1] <= 0)) ? Result.OK : Result.INVALID;
        }

        private boolean isBlocked(int[] location) {
            return matrix[location[0]].charAt(location[1]) == '*';
        }

        private int[] cycleEval(String seq) {
            int[] rs = {0, 0};
            return move(seq, rs);
        }

        private void generateSeq(String seq) {
            bfsQueue.add(seq.concat("U"));
            bfsQueue.add(seq.concat("L"));
            bfsQueue.add(seq.concat("R"));
            bfsQueue.add(seq.concat("D"));
        }

        private enum Result {
            OK,
            INVALID,
            BLOCKED;

            boolean isBlock() {
                return this == BLOCKED;
            }

            boolean isInvalid() {
                return this == INVALID;
            }
        }
    }
}
