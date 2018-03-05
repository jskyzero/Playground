import java.util.Random;
import java.util.stream.IntStream;

/**
 * Q35
 */
public class Q35 {
  final static int SIDES = 6;

  public static void main(String[] args) {
    double[] table = new double[2 * SIDES + 1];
    double[] cmpTable = simulation();

    // in fact it will be more than 10 000, maybe
    for (int times = 1; !isOK(table, cmpTable, 0.01); times++) {
      addOne(getRandomSides(), getRandomSides(), table, times);
      System.out.printf("times = %d\n", times);
    }
  }

  public static int getRandomSides() {
    Random random = new Random();
    return ((int)(random.nextDouble() * 6) + 1);
  }

  public static void addOne(int a, int b, double[] table, double times) {
    for (int k = 2; k <= 2 * SIDES; k++) {
      table[k] *= (times - 1);
      if (k == a + b) 
        table[a + b] += 1.0;
      table[k] /= times;
    }
    System.out.printf("a = %-5d b = %-5d total = %-5f ", a, b, IntStream.range(0, table.length).mapToDouble(i -> table[i]).sum());
  }

  public static boolean isOK(double[] left, double[] right, double missValue) {
    return IntStream.range(0, Math.min(left.length, right.length))
                    .mapToDouble(i -> Math.abs(left[i] - right[i]))
                    .sum() <= missValue;
  }

  public static double[] simulation() {
    double[] dist = new double[2 * SIDES + 1];

    for (int i = 1; i <= SIDES; i++) {
      for (int j = 1; j <= SIDES; j++) {
        dist[i + j] += 1.0;
      }
    }

    for (int k = 2; k <= 2 * SIDES; k++) {
      dist[k] /= 36.0;
    }

    return dist;
  }
}