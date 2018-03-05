import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

/**
 * Q38
 */
public class Q38 {
  public static void main(String[] args) {
    // set array size
    final int size = 100000;
    // set initial value
    int[] array = IntStream.range(0, size).map(i -> ThreadLocalRandom.current().nextInt()).toArray();
    // sort
    Arrays.sort(array);
    runEach(array, 100000);
  }

  public static void runEach(int[] array, int eachSize) {
    int size = array.length;
    int[] keyIndexArray = IntStream.range(0, eachSize).map(i -> ThreadLocalRandom.current().nextInt(0, size)).toArray();

    Instant i0 = Instant.now();
    IntStream.range(0, eachSize).forEach(i -> {
      BinaySearch(array, 0, size, array[keyIndexArray[i]]);
    });
    Instant i1 = Instant.now();
    IntStream.range(0, eachSize).forEach(i -> {
      BruteForceSearch(array, 0, size, array[keyIndexArray[i]]);
    });
    Instant i2 = Instant.now();

    System.out.println("BinaySearch = " + Duration.between(i0, i1).toMillis() + " milliseconds");
    System.out.println("BruteForceSearch = " + Duration.between(i1, i2).toMillis() + " milliseconds");
    System.out.printf("percentage = %f\n", (double)Duration.between(i0, i1).toNanos() / Duration.between(i1, i2).toNanos());
  }

  public static int BinaySearch(int[] array, int low, int high, int key) {
    if (low > high)
      return -1;
    int mid = (low + high) / 2;
    if (key == array[mid]) {
      return mid;
    } else if (key > array[mid]) {
      return BinaySearch(array, mid + 1, high, key);
    } else {
      return BinaySearch(array, low, mid - 1, key);
    }
  }

  public static int BruteForceSearch(int[] array, int low, int high, int key) {
    for (int i = low; i <= high; i++) {
      if (array[i] == key)
        return i;
    }
    return -1;
  }
}