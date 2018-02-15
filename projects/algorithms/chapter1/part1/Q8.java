/**
 * Q8
 */
public class Q8 {
  public static void main(String[] args) {
    TestCodes.test(() -> {
      System.out.print('b');
      System.out.print('b' + 'c');
      System.out.print((char)('a' + 4));
      return 0;
    }, "b197e");
  }
}