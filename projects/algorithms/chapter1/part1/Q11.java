/**
 * Q11
 */

public class Q11 {
  public static void main(String[] args) {
    Boolean array[][] = {{true, true, false}, {false, false, true}};

    System.out.printf("%8s", "R\\L");
    for (int j = 0; j < 3; j++) {
      System.out.printf("%8d", j);
    }
    System.out.printf("\n");

    for (int i = 0; i < 2; i++) {
      System.out.printf("%8d", i);
      for (int j = 0; j < 3; j++) {
        System.out.printf("%8b", array[i][j]);
      }
      System.out.printf("\n");
    }

  }
}