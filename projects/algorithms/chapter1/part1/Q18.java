/**
 * Q18
 */
public class Q18 {
  public static void main(String[] args) {
    // (4, 12) + 2 -> (8, 6) + 2 -> (16, 3) + 2 -> (32, 1) + 18 -> (64, 0) + 50
    assert (mystery(2, 25) == 50);
    // (6, 5) + 3 -> (12, 2) + 9 -> (24, 1) + 9 -> (48, 0) + 33
    assert (mystery(3, 11) == 33);

    // WTF the number is too big to calculate by hand.
    // (4, 12) * 2 -> (16, 6) * 2 -> (256, 3) * 2 -> (65536, 1) * 512 -> (4294967296, 0) * 33554432 
    assert (mystery2(2, 25) == 33554432);
    // (9, 5) * 3 -> (81, 2) * 27 -> (6561, 1) * 27 -> (43046721, 0) * 177147
    assert (mystery2(3, 11) == 177147);
  }

  public static int mystery(int a, int b) {
    if (b == 0) return 0;
    if (b % 2 == 0) return mystery(a + a, b / 2);
    return mystery(a + a, b / 2) + a;
  }

  public static int mystery2(int a, int b) {
    if (b == 0) return 1;
    if (b % 2 == 0) return mystery2(a * a, b / 2);
    return mystery2(a * a, b / 2) * a;
  }
}