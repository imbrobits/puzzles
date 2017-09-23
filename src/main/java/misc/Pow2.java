package misc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Nhan Nguyen (nguyenbanhan@gmail.com)
 */
public class Pow2 {

  /*
 * Complete the function below.
 */

  public static void main(String [] args) {
    int[] aa = {1, 46, 1};
    int k = 47;
    numberOfPairs(aa, 47);
  }

  static int numberOfPairs(int[] a, long k) {
    List<Pair> rs = new ArrayList<>(); // TODO replace with set
    for (int i = 0; i < a.length; i++) {
      for (int j = i + 1; j < a.length; j++) {
        Pair p = new Pair(a[i], a[j]);
        int sum = a[i] + a[j];
        System.out.println(sum);
        if (sum == k && !rs.contains(p)) {
          rs.add(p);
        }
      }
    }
    System.out.println(rs.size());
    return rs.size();
  }

  private static class Pair {

    Pair(int firstVal, int secondVal) {
      this.firstVal = firstVal;
      this.secondVal = secondVal;
    }
    int firstVal;
    int secondVal;

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }

      Pair pair = (Pair) o;

      return (firstVal == pair.secondVal && secondVal == pair.firstVal)
          || (firstVal == pair.firstVal && secondVal == pair.secondVal);

    }

    @Override
    public int hashCode() {
      int result = firstVal;
      result = 31 * result + secondVal;
      return result;
    }
  }
}
