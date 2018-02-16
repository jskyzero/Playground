/**
 * Q16
 */

public class Q16 {
  public static void main(String[] args) {
    // System.out.println(exR1(6));
    assert (exR1(6).equals("0001300100246"));
    // 3  4  "6"
    // 0 1 "3"  1 2 "4"  "6"
    // "0" -2 -1 "1" "3"  -2 -1 "1" -1 0 "2" "4" "6"
    // "0" "0" "0" "1" "3" "0" "0" "1" "0" "0" "2" "4" "6"
  }

  public static String exR1(int n) {
    // I change the return n <= 0 value to "0" insteated of ""
    if (n <= 0) return "0";
    return exR1(n - 3) + exR1(n - 2) + n;
  }
}