import java.util.Random;

/**
 * Q31
 */
public class Q31 {
  public static void main(String[] args) {
    int n = Integer.parseInt(args[0]);
    double p = Double.parseDouble(args[1]);

    boolean [][] table = new boolean[n][n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        Random random = new Random();
        table[i][j] = random.nextDouble() < p;
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.printf("%5b ", table[i][j]);
      }
      System.out.print("\n");
    }
  }
}