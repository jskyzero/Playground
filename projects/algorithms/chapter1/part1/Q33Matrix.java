import java.util.stream.IntStream;

/**
 * Q33Matrix
 */

public class Q33Matrix {

  public static double dot(double[] x, double[] y) {
    return IntStream.range(0, Math.min(x.length, y.length)).mapToDouble(i -> x[i] * y[i]).sum();
  }

  public static double[][] mult(double[][] x, double[][] y) {
    int m = x.length, n = y[0].length;
    double[][] result = new double[m][n];

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        final int colIndex = j;
        double[] col = IntStream.range(0, y.length).mapToDouble(rowIndex -> y[rowIndex][colIndex]).toArray();
        result[i][j] = dot(x[i], col);
      }
    }

    return result;
  }

  public static double[][] transpose(double[][] a) {
    int m = a.length, n = a[0].length;
    double[][] result = new double[n][m];

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        result[j][i] = a[n - 1 - j][m - 1 - i];
      }
    }
    return result;
  }

  public static double[] mult(double[][] a, double[] x) {
    int m = a.length, n = Math.min(a[0].length, x.length);
    double[] result = new double[m];
    for (int i = 0; i < m; i++) {
      result[i] = dot(a[i], x);
    }
    return result;
  }

  public static double[] mult(double[] x, double[][] a) {
    int m = Math.min(a.length, x.length), n = a[0].length;
    double[] result = new double[n];
    for (int i = 0; i < n; i++) {
      final int colIndex = i;
      double[] col = IntStream.range(0, m).mapToDouble(rowIndex -> a[rowIndex][colIndex]).toArray();
      result[i] = dot(x, col);
    }
    return result;
  }

  public static void print(double[][] matrix) {
    int m = matrix.length, n = matrix[0].length;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        System.out.printf("%5f ", matrix[i][j]);
      }
      System.out.println();
    }
  }

  public static void print(double[] array) {
    IntStream.range(0, array.length).forEach(i -> System.out.printf("%5f%s", array[i], i + 1 == array.length ? "\n" : " "));
  }
}

// bellow is a test example, but in fact don't need to be such complex
// make things simple please

// 
// import java.io.ByteArrayOutputStream;
// import java.io.IOException;
// import java.util.ArrayList;

// public class Q33Matrix<T> {
//   private int m, n;
//   private ArrayList data;
//   //  m * n

//   public Q33Matrix(int m, int n) {
//     this.m = m;
//     this.n = n;

//     data = new ArrayList<T>(size());
//     System.out.print(size());
//     System.out.print(data.size());
//   }

//   public T get(int m, int n) {
//     return (T) data.get(index(m, n));
//   }

//   public int rowSize() {
//     return m;
//   }

//   public int colSize() {
//     return n;
//   }

//   public int size() {
//     return m * n;
//   }

//   private int index(int raw, int col) {
//     return raw * colSize() + col;
//   }

//   public String toString() {
//     try {
//       ByteArrayOutputStream out = new ByteArrayOutputStream();
//       for (int i = 0; i < m; i++) {
//         for (int j = 0; j < n; j++) {
//           out.write(String.format("%s\n", get(i, j).toString()).getBytes());
//         }
//         out.write("\n".getBytes());
//       }
//       return new String(out.toByteArray());
//     } catch (IOException e) {
//       return e.toString();
//     }
//   }
// }