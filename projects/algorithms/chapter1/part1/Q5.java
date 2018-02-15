import java.util.Scanner;

class Q5 {
  public static void main(String[] args) {
  
    Scanner in = new Scanner(System.in);
    System.out.println("input two double");

    while (true) {
      if (!in.hasNextDouble()) break;
      double x = in.nextDouble();

      if (!in.hasNextDouble()) break;
      double y = in.nextDouble();

      System.out.println((x > 0 && x < 1) && (y > 0 && y < 1) ? "true": "false");
      System.out.println("input two double");
    }

    in.close();
  }
}