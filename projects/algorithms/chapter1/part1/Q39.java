import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

/**
 * Q39
 */
public class Q39 {
  static final int NOT_FOUND = -1;

  public static void main(String[] args) {
    int repeatTimes = Integer.parseInt(args[0]);

    stastics(new int[] {1000, 10000, 100000, 1000000}, repeatTimes, 100000, 999999);
  }

  public static void stastics(int[] arraySizeArray, int repeatTimes, int min, int max) {
    for (int i = 0; i < arraySizeArray.length; i ++) {
      int arraySize = arraySizeArray[i];
      int[] left = randomIntArray(arraySize, min, max),
            right = randomIntArray(arraySize, min, max);
      int sameNum = IntStream.range(0, repeatTimes)
                             .map(x -> findSame(left, right))
                             .sum();
      System.out.printf("size = %-7d avg same num = %-6d\n", arraySize, sameNum / repeatTimes);
    }
  }

  public static int findSame(int[] left, int[] right) {
    int size = Math.min(left.length, right.length);
    return IntStream.range(0, size)
                    .map(i -> NOT_FOUND != BinaySearch(right, 0, size - 1, left[i]) ? 1 : 0)
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
      return NOT_FOUND;
    int mid = (low + high) / 2;
    if (key == array[mid]) {
      return mid;
    } else if (key > array[mid]) {
      return BinaySearch(array, mid + 1, high, key);
    } else {
      return BinaySearch(array, low, mid - 1, key);
    }
  }
}