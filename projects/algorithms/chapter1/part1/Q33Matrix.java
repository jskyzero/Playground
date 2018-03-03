
/**
 * Q33Matrix
 */

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Q33Matrix<T> {
  private int m, n;
  private ArrayList data;
  //  m * n

  public Q33Matrix(int m, int n) {
    this.m = m;
    this.n = n;

    data = new ArrayList<T>(size());
  }

  public T get(int m, int n) {
    return (T) data.get(m * colSize() + n);
  }

  public int rowSize() {
    return m;
  }

  public int colSize() {
    return n;
  }

  public int size() {
    return m * n;
  }

  public String toString() {
    try {
      ByteArrayOutputStream out = new ByteArrayOutputStream();
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          out.write(String.format("%s\n", "Hello World!").getBytes());
        }
      }
      return new String(out.toByteArray());
    } catch (IOException e) {
      return e.toString();
    }
  }
}