/**
 * Q20
 */
import java.util.Scanner;
import java.lang.Math;

public class Q20 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    while (scanner.hasNext())
      System.out.println(myLog(scanner.nextInt()));

    scanner.close();
  }

  public static double myLog(int n) {
    assert (n > 0);
    if (n == 1) return 0;
    return myLog(n - 1) + Math.log((double)n);
  }
}