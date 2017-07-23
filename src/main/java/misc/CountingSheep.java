package misc;

public class CountingSheep {
    public static int lostSheeps(int[] fridayNightCounting, int[] saturdayNightCounting, int sheepsTotal) {
        int returned = 0;
        for (int i = 0; i < Math.max(fridayNightCounting.length, saturdayNightCounting.length); i++) {
            returned += i < fridayNightCounting.length ? fridayNightCounting[i] : 0;
            returned += i < saturdayNightCounting.length ? saturdayNightCounting[i] : 0;
        }
        return sheepsTotal - returned;
    }
}