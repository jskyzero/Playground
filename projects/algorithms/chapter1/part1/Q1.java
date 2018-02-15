/*
 * 1. double printf use '%f'
 * 2. boolean printf use '%b'
 */

class Q1 {
  public static void main(String[] argv) {
    int a = (0 + 15) / 2;
    double b = 2.0e-6 * 100000000.1;
    boolean c = true && false || true && true;

    System.out.printf("a = %d\n", a);
    System.out.printf("b= %f\n", b);
    System.out.printf("c = %b\n", c);
  }
}