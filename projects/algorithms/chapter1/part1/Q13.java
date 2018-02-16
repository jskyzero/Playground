/**
 * Q13
 */
public class Q13 {
  public static void main(String[] args) {
    int array[][] = {{1, 2}, {3, 4}, {5, 6}};
    // 1 2       1 3 5
    // 3 4  -T-> 2 4 6
    // 5 6

    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 3; j++) {
        System.out.printf("%5d", array[j][i]);
      }
      System.out.println();
    }
  }
}