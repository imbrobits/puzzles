import codefights.LabyrinthNavigation;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Nhan Nguyen.
 */
public class LabyrinthNavigationTest {

    @Test
    public void testCase1() {
        String[] labyrinth = {".......",
                "...*.*.",
                "*....*.",
                ".......",
                ".**...."};
        int[] start = {4, 6};
        int[] dest = {0, 0};
        Assert.assertEquals(3, new LabyrinthNavigation().labyrinthNavigation(labyrinth, start, dest));
    }

    @Test
    public void testCase2() {
        String[] labyrinth = {"..",
                ".*",
                "..",
                ".*",
                "..",
                ".*",
                "..",
                ".*",
                ".."};
        int[] start = {8, 1};
        int[] end = {0, 1};
        Assert.assertEquals(4, new LabyrinthNavigation().labyrinthNavigation(labyrinth, start, end));
    }

    @Test
    public void testCase3() {
        String[] labyrinth = {"...**...*",
                "....*....",
                ".......*.",
                ".*.*...*.",
                ".***.*...",
                ".....*...",
                ".***.*.*.",
                ".*.*.***.",
                "........."};
        int[] start = {6, 8};
        int[] end = {2, 0};
        Assert.assertEquals(5, new LabyrinthNavigation().labyrinthNavigation(labyrinth, start, end));
    }

    @Test
    public void testCase4() {
        String[] labyrinth = {".*.",
                ".*.",
                "..."};
        int[] start = {0, 2};
        int[] end = {0, 0};
        Assert.assertEquals(6, new LabyrinthNavigation().labyrinthNavigation(labyrinth, start, end));
    }

    @Test
    public void testCase5() {
        String[] labyrinth = {".................................................."};
        int[] start = {0, 0};
        int[] end = {0, 49};
        Assert.assertEquals(1, new LabyrinthNavigation().labyrinthNavigation(labyrinth, start, end));
    }

    @Test
    public void testCase6() {
        String[] labyrinth = {"...................",
                "***.*..*.*..*.*..*."};
        int[] start = {1, 18};
        int[] end = {0, 0};
        Assert.assertEquals(7, new LabyrinthNavigation().labyrinthNavigation(labyrinth, start, end));
    }

    @Test
    public void testCase7() {
        String[] labyrinth = {"...",
                ".*.",
                ".**",
                "..."};
        int[] start = {1, 2};
        int[] end = {3, 2};
        Assert.assertEquals(8, new LabyrinthNavigation().labyrinthNavigation(labyrinth, start, end));
    }

    @Test
    public void testCase8() {
        String[] labyrinth = {"*",
                ".",
                ".",
                ".",
                ".",
                "*",
                ".",
                ".",
                "*",
                ".",
                ".",
                ".",
                ".",
                ".",
                ".",
                ".",
                ".",
                ".",
                ".",
                ".",
                ".",
                ".",
                ".",
                ".",
                ".",
                ".",
                ".",
                ".",
                ".",
                ".",
                ".",
                ".",
                ".",
                ".",
                ".",
                ".",
                ".",
                ".",
                ".",
                ".",
                ".",
                ".",
                ".",
                "*",
                ".",
                ".",
                "*",
                "*",
                "*",
                "*"};
        int[] start = {42, 0};
        int[] end = {16, 0};
        Assert.assertEquals(1, new LabyrinthNavigation().labyrinthNavigation(labyrinth, start, end));
    }

    @Test
    public void testCase9() {
        String[] labyrinth = {"......*",
                ".*.....",
                ".**...*",
                "......."};
        int[] start = {0, 0};
        int[] end = {3, 6};
        Assert.assertEquals(5, new LabyrinthNavigation().labyrinthNavigation(labyrinth, start, end));
    }

    @Test
    public void testCase10() {
        String[] labyrinth = {"...........................",
                "...........................",
                "...........................",
                "...........................",
                "...........................",
                "...........................",
                "..........................."};
        int[] start = {5, 24};
        int[] end = {1, 0};
        Assert.assertEquals(6, new LabyrinthNavigation().labyrinthNavigation(labyrinth, start, end));
    }

    @Test
    public void testCase11() {
        String[] labyrinth = {".........**....",
                ".*...*...*.**..",
                ".**............",
                "......*...*...."};
        int[] start = {1, 3};
        int[] end = {3, 14};
        Assert.assertEquals(8, new LabyrinthNavigation().labyrinthNavigation(labyrinth, start, end));
    }

    @Test
    public void testCase12() {
        String[] labyrinth = {"......*",
                ".*.....",
                ".**...*",
                "......."};
        int[] start = {0, 5};
        int[] end = {3, 6};
        Assert.assertEquals(4, new LabyrinthNavigation().labyrinthNavigation(labyrinth, start, end));
    }

    @Test
    public void testCase13() {
        String[] labyrinth = {"...........*...",
                ".*.*.*.*.*.*...",
                ".*.*.*.*.*.*...",
                ".*.*.*.*.*.*...",
                ".***.*.*.*.*...",
                ".*.*.*.*.*.*...",
                ".*.*.*.*.*.*...",
                "..............."};
        int[] start = {7, 0};
        int[] end = {6, 14};
        Assert.assertEquals(4, new LabyrinthNavigation().labyrinthNavigation(labyrinth, start, end));
    }

    @Test
    public void testCase14() {
        String[] labyrinth = {"...........*...",
                ".*.*.*.*.*.*...",
                ".*.*.*.*.*.*...",
                ".*.*.*.*.*.*...",
                ".*.*.*.*.*.*...",
                ".*.*.*.*.*.*...",
                ".*.*.*.*.*.*...",
                "...............",
                ".*.*.*.*.*.*...",
                ".*............."};
        int[] start = {9, 0};
        int[] end = {9, 14};
        Assert.assertEquals(6, new LabyrinthNavigation().labyrinthNavigation(labyrinth, start, end));
    }

    @Test
    public void testCase15() {
        String[] labyrinth = {"...............",
                ".*************.",
                ".*...........*.",
                ".*...........*.",
                ".*...........*.",
                ".*...........*.",
                ".*...........*.",
                ".*...........*.",
                ".*************.",
                "..............."};
        int[] start = {2, 2};
        int[] end = {6, 11};
        Assert.assertEquals(3, new LabyrinthNavigation().labyrinthNavigation(labyrinth, start, end));
    }

}
