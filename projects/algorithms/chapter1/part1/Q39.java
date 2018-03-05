import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

/**
 * Q39
 */
public class Q39 {
  static final int notFind = -1;
  public static void main(String[] args) {

  }

  public static int findSame(int[] left, int[] right) {
    int size = Math.min(left.length, right.length);
    return IntStream.range(0, size)
                    .map(i -> notFind)
                    .sum();
  }

  public static int[] randomIntArray(int size, int minValue, int maxValue) {
    return IntStream.range(0, size)
                    .map(i -> ThreadLocalRandom.current()
                    .nextInt(minValue, maxValue))
                    .toArray();
  }

  public static int BinaySearch(int[] array, int low, int high, int key) {
    if (low > high)
      return notFind;
    int mid = (low + high) / 2;
    if (key == array[mid]) {
      return mid;
    } else if (key > array[mid]) {
      return BinaySearch(array, mid + 1, high, key);
    } else {
      return BinaySearch(array, low, mid + 1, key);
    }
  }
}