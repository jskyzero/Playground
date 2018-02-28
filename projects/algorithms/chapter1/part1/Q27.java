/**
 * Q27
 */
import java.util.Map;

public class Q27 {
  public static void main(String[] args) {
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

  public static double binomial(int N, int k, double p, Map<Index, Double> cache) {
    if (N == 0 && k == 0)
      return 1.0;
    if (N < 0 && k < 0)
      return 0.0;
    double left = 0, right = 0;
    Index leftKey = new Index(N - 1, k);
    if (cache.containsKey(leftKey)) {
      left = cache.get(leftKey).doubleValue();
    } else {
      left = binomial(N - 1, k, p, cache);
      cache.put(leftKey, left);
    }
    Index rightKey = new Index(N - 1, k -1);
    if (cache.containsKey(rightKey)) {
      right = cache.get(rightKey).doubleValue();
    } else {
      right = binomial(N - 1, k - 1, p, cache);
      cache.put(rightKey, right);
    }

    return (1.0 - p) * left + p * right;
  }
}

class Index {
  int x, y;
  Index(int x, int y) {
    this.x = x;
    this.y = y;
  }
}
