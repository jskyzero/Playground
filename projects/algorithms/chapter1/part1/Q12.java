/**
 * Q12
 */
public class Q12 {
  public static void main(String[] args) {
    TestCodes.test(() -> {
      int a[] = new int[10];
      for (int i = 0; i < 10; i++)
        a[i] = 9 - i;
      for (int i = 0; i < 10; i++)
        a[i] = a[a[i]];
      for (int i = 0; i < 10; i++)
        System.out.print(i);
      return 0;
    }, "0123456789");
  }
}