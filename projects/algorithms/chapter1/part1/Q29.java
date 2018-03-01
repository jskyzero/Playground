import java.util.Arrays;

/**
 * Q29
 */
public class Q29 {
  public static void main(String[] args) {

    int[] array = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
    Arrays.sort(array);

    // System.out.print(rank(5, array, 0, 9));
    assert (rank(5, array, 0, 9) == 5);
  }


  // numbers value < key
  public static int rank(int key, int[] sortedArray, int low, int high) {
    if (low > high ) return 0;
    int mid = (low + high) / 2;
    // System.out.print(mid);
    if (key == sortedArray[mid]) {
      return rank(key, sortedArray, low, mid - 1);
    } else if (key > sortedArray[mid]) {
      return (mid - low + 1) + rank(key, sortedArray, mid + 1, high);
    } else {
      return rank(key, sortedArray, low, mid - 1);
    }
  }
}