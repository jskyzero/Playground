import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

/**
 * Q36
 */

 public class Q36 {
  public static void main(String[] args) {
    int m = Integer.parseInt(args[0]), n = Integer.parseInt(args[1]);
    int[][] table = new int[m][m];

    for (int i = 0; i < n; i++) {
      double[] array = IntStream.range(0, m).mapToDouble(x -> (double)x).toArray();
      shuffle(array);
      IntStream.range(0, m).forEach(x -> {
        table[x][(int)array[x]] += 1;
      });
    }

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < m; j++) {
        System.out.printf("%-5d ", table[i][j]);
      }
      System.out.println();
    }
  }

  public static void shuffle(double[] a) {
    int length = a.length;
    for (int i = 0; i < length; i++) {
      int swapIndex = ThreadLocalRandom.current().nextInt(0, length);
      swap(a, i, swapIndex);
    }
  }

  public static void swap(double[] array, int a, int b) {
    double temp = array[a];
    array[a] = array[b];
    array[b] = temp;
  }
}