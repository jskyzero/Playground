/**
 * Q14
 */

import java.util.Scanner;

public class Q14 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNextInt()) {
      int num = scanner.nextInt();
      System.out.println(lg(num));
    }
    scanner.close();
  }

  public static int lg(int num) {
    int result = 0;
    while ((1 << result) <= num)
      result++;
    return result - 1;
  }
}