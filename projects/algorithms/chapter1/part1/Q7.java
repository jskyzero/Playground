/**
 * Q7
 */

public class Q7 {
  public static void main(String[] args) {
    // a
    TestCodes.test(() -> {
      double t = 9.0;
      while (Math.abs(t - 9.0/t) > .001) {
        t = (9.0/t + t) / 2.0;
      }
      System.out.printf("%.5f", t);
      return 0;
    }, "3.00009");

    // b
    TestCodes.test(() -> {
      int sum = 0;
      for (int i = 0; i < 1000; i++) {
        for (int j = 0; j < i; j++) {
          sum++;
        }
      }
      System.out.print(sum);
      return 0;
    }, "499500");

    // c
    TestCodes.test(() -> {
      int sum = 0;
      for (int i = 1; i < 1000; i*=2) {
        for (int j =0; j < 1000; j++ ) {
          sum++;
        }
      }
      System.out.print(sum);
      return 0;
    }, "10000");
  }
}