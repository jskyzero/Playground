import java.util.HashMap;

import com.sun.javafx.collections.MappingChange.Map;

/**
 * Q19
 */
public class Q19 {
  public static void main(String[] args) {
    for (int i = 0; i < 9; i++) {
      printTimeUseByF(i * 5);
    }
  }

  public static void printTimeUseByF(int n) {
    HashMap<Integer, Long> resultCache = new HashMap<Integer, Long>();
    long beginTime = System.nanoTime();
    long result = F(n);
    long endTime = System.nanoTime();
    long result2 = F2(n, resultCache);
    long endTime2 = System.nanoTime();
    System.out.printf("n = %-5d, fibonacci = %-10d", n, result);
    // divide by 1000000 to get milliseconds.
    System.out.printf("time = %-10f(s) ", (endTime - beginTime) / 1E9);
    System.out.printf("same = %-5b timeUse = %-10f\n", result == result2, (double)(endTime2 - endTime) / (endTime - beginTime));

  }

  public static long F(int N) {
    if (N == 0)
      return 0;
    if (N == 1)
      return 1;
    return F(N - 1) + F(N - 2);
  }

  public static long F2(int N, HashMap<Integer, Long> resultCache) {
    if (resultCache.containsKey(N))
      return resultCache.get(N);
    else {
      long result = 0;
      if (N == 0)
        result = 0;
      if (N == 1)
        result = 1;
      if (N != 0 && N != 1)
        result = F2(N - 1, resultCache) + F2(N - 2, resultCache);
      resultCache.put(N, result);
      return result;
    }
  }
}