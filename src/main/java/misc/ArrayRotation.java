package misc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Nhan Nguyen (nguyenbanhan@gmail.com)
 */
public class ArrayRotation {

  public static void main(String[] args) {
//    Scanner in = new Scanner(System.in);
//    int n = in.nextInt();
//    int k = in.nextInt();
//    int a[] = new int[n];
//    for (int a_i = 0; a_i < n; a_i++) {
//      a[a_i] = in.nextInt();
//    }
    int[] a = {1, 2, 3, 4, 5};
    int k = 4;
    solve(a, k);
  }

  private static List<Integer> toIntList(int[] intArray) {
    List<Integer> intList = new ArrayList<>();
    for (int index = 0; index < intArray.length; index++) {
      intList.add(intArray[index]);
    }
    return intList;
  }

  public static void solve(int[] arrays, int k) {
    int swaps = k % arrays.length;
    List<Integer> temp = toIntList(arrays);
    while (swaps != 0) {
      temp.add(temp.remove(0));
      swaps--;
    }
    printResult(toIntegerArray(temp));
  }

  public static void linkedListSolve(int[] arrays, int k) {
    int swaps = k % arrays.length;
    LinkedList<Integer> temp = toLinkedList(arrays);
  }

  private static LinkedList<Integer> toLinkedList(int[] intArray) {
    LinkedList<Integer> intList = new LinkedList<>();
    for (int index = 0; index < intArray.length; index++) {
      intList.add(intArray[index]);
    }
    return intList;
  }

  public static void printResult(Integer[] array) {
    StringBuilder rs = new StringBuilder();
    for (Integer i : array) {
      rs.append(i).append(" ");
    }
    System.out.println(rs.toString().trim());
  }

  public static Integer[] toIntegerArray(List<Integer> intList) {
    Integer[] integerArray = intList.toArray(new Integer[intList.size()]);
    return integerArray;
  }

}
