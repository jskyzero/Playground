/**
 * Q22
 */

import java.util.Arrays;
import java.util.Scanner;


public class Q22 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    if (scanner.hasNextInt()) {
      int arraySize = scanner.nextInt();
      int[] array = new int[arraySize];
      for (int i = 0; i < arraySize && scanner.hasNextInt(); i++)
        array[i] = scanner.nextInt();
      Arrays.sort(array);
      if (scanner.hasNextInt()) {
        int key = scanner.nextInt();
        System.out.printf("key: %-10d index: %-10d\n", key, rank(key, array));
      }
    }
    scanner.close();
  }

  public static int rank(int key, int[] a) {
    return rank(key, a, 0, a.length - 1, 0);
  }

  public static int rank(int key, int[] a, int lo, int hi, int deepth) {
    if (lo > hi) return -1;
    System.out.printf("low: %-5d high:%-5d deepth:%-5d\n", lo, hi, deepth);
    int mid = lo + (hi - lo) / 2;
    if (key < a[mid]) return rank(key, a, lo, mid - 1, deepth + 1);
    else if (key > a[mid]) return rank(key, a, mid + 1, hi, deepth + 1);
    else return mid;
  }
}