/**
 * Q27
 */
import java.util.Map;

public class Q27 {
  public static void main(string[] args) {
    // binomial(100, 50, 0.25)
    // 调用次数 2 ^ 100 以上
  }

  public static double binomial(int N, int k, double p) {
    if (N == 0 && k == 0)
      return 1.0;
    if (N < 0 && k < 0)
      return 0.0;
    return (1.0 - p) * binomial(N - 1, k, p) + p * binomial(N - 1, k - 1, p);
  }

  class Index {
    int x, y;
    Index(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public static double binomial(int N, int k, double p, Map<Index, Double> cache) {
    if (N == 0 && k == 0)
      return 1.0;
    if (N < 0 && k < 0)
      return 0.0;
    double left = 0, right = 0;
    if (cache.containsKey(new Index(N - 1, k))) {
      left = cache.get(new Index(N - 1, k)).doubleValue();
    } else {
      left = binomial(index.x, index.y, p, cache);
      cache.put(new Index(N - 1, k), left);
    }
    if (cache.containsKey(new Index(N - 1, k - 1))) {
      right = cache.get(new Index(N - 1, k)).doubleValue();
    } else {
      right = binomial(index.x, index.y, p, cache);
      cache.put(new Index(N - 1, k - 1), right);
    }

    return (1.0 - p) * left + p * right;
  }
}

