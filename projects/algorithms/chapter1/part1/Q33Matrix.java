/**
 * Q33Matrix
 */

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
    return (T)data.get(m * colSize() + n);
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
    return "123";
  }
}