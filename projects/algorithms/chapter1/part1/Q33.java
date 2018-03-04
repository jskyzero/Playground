/**
 * Q33
 */
public class Q33 {
  public static void main(String[] args) {
    double[][] A = {{1, 2}, {3, 4}, {5, 6}};
    double[][] B = {{7,8}, {9, 10}};

    double[] a = {1, 2, 3};
    double[] b = {4, 5};

    System.out.printf("a * b = %5f\n", Q33Matrix.dot(a, b));
    System.out.printf("A * B = \n");
    Q33Matrix.print(Q33Matrix.mult(A, B));
    System.out.printf("A * a = \n");
    Q33Matrix.print(Q33Matrix.mult(A, a));
    System.out.printf("a * A = \n");
    Q33Matrix.print(Q33Matrix.mult(a, A));

  }
}