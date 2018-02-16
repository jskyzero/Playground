/**
 * Q10
 */
public class Q10 {
  public static void main(String[] args) {
    try {
      int[] a;
      for (int i = 0; i < 10; i++) {
        a[i] = i * i;
      }
    } catch (Exception e) {
      System.out.print(e.toString());
    }
  }
}