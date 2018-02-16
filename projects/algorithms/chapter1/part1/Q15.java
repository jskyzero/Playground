
/**
 * Q15
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Q15 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int intputArraySize = 0, outputArraySize = 0;
    if (scanner.hasNextInt())
      outputArraySize = scanner.nextInt();
    if (scanner.hasNextInt())
      intputArraySize = scanner.nextInt();
    int[] inputArray = new int[intputArraySize];
    for (int i = 0; i < inputArray.length && scanner.hasNextInt(); i++)
      inputArray[i] = scanner.nextInt();

    int[] outputArray = histogram(inputArray, intputArraySize, outputArraySize);
    for (int i = 0; i < outputArray.length; i++)
      System.out.printf("index: %d times: %d\n", i, outputArray[i]);

    scanner.close();
  }

  public static int[] histogram(int[] inputArray, int intputArraySize, int outputArraySize) {
    int[] outputArray = new int[outputArraySize];
    Arrays.stream(inputArray)
          .forEach((x) -> {
            if (x >=0 && x < outputArray.length)
              outputArray[(int)x] += 1;
          });
    return outputArray;
  }
}