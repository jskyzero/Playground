/**
 * Q32
 */

import java.util.Arrays;
import java.util.Scanner;

public class Q32 {
  public static void main(String[] args) {
    // hist l r n 
    double l = 0, r = 0;
    int n = 0;

    Scanner scanner = new Scanner(System.in);
    n = scanner.nextInt();
    l = scanner.nextDouble();
    r = scanner.nextDouble();

    int[] hist = new int[n];
    Double space = (r - l) / n;

    while (scanner.hasNextDouble()) {
      double inputValue = scanner.nextDouble();
      int index = (int)((inputValue - l) / space);
      System.out.print(index);
      if (index < n) hist[index] ++;
    }

    scanner.close();

    for (int i = 0; i < n; i++) {
      System.out.printf("%-5f %-5f %-5d\n", l + space * i, l + space * i + space, hist[i]);
    }
  }
}