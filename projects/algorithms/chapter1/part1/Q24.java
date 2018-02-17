/**
 * Q24
 */
public class Q24 {
  public static void main(String[] args) {
    assert (args.length >= 2);
    int a = Integer.parseInt(args[0]);
    int b = Integer.parseInt(args[1]);
    System.out.printf("gcd(a,b)=%-5d\n", gcd(a,b));
  }

  public static int gcd(int a, int b) {
    System.out.printf("a=%-5d b = %-5d\n", a, b);
    if (b == 0) return a;
    else return gcd(b, a % b);
  }
}