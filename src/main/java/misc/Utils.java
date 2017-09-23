package misc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nhan Nguyen (nguyenbanhan@gmail.com)
 */
public class Utils {
  public static Integer[] toIntegerArray(List<Integer> intList) {
    Integer[] integerArray = intList.toArray(new Integer[intList.size()]);
    return integerArray;
  }

  private static int[] toIntArray(List<Integer> intList) {
    int[] arr = new int[intList.size()];
    for (int i = 0; i < intList.size(); i++) {
      arr[i] = intList.get(i);
    }
    return arr;
  }

  private static List<Integer> toIntList(int[] intArray) {
    List<Integer> intList = new ArrayList<>();
    for (int index = 0; index < intArray.length; index++) {
      intList.add(intArray[index]);
    }
    return intList;
  }
}
