/**
 * Q17
 */
public class Q17 {
  public static void main(String[] args) {
    System.out.println(exR2(6));
  }

  public static String exR2(int n) {
    // so the 1st is the simplest case
    if (n <= 0) return "";
    String s = exR2(n - 3) + exR2(n - 2) + n;
    return s;
  }
}