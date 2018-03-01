/**
 * Q30
 */
public class Q30 {
  public static void main(String[] args) {
    int size = Integer.parseInt(args[0]);
    boolean [][] table = new boolean[size][size];

    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        table[i][j] = !(i != 0 && j!= 0 && gcd(i, j) != 1);
      }
    }

    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        System.out.printf("%5b ", table[i][j]);  
      }
      System.out.printf("\n");  
    }
  }

  public static int gcd(int a, int b) {
    return a % b == 0 ? b : gcd(b, a % b);
  }
}