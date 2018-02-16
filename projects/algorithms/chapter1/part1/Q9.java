import java.util.Scanner;

class Q9 {
  public static void main(String[] args) {
    java.util.Scanner scanner = new Scanner(System.in);
    while (scanner.hasNextInt()) {
      int num = scanner.nextInt();
      System.out.println(intToBinaryString(num));
    }
    scanner.close();
  }

  public static String intToBinaryString(int num) {
    String result = "";
    while (num > 0) {
      result += (num % 2);
      num /= 2;
    }
    return new StringBuilder(result).reverse().toString();
  }
}