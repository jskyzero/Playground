
/**
 * Q21
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Q21 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    ArrayList arrayList = new ArrayList<Q21Score>();

    while (scanner.hasNext()) {
      String name = "";
      int totalScore = 0;
      int getScore = 0;

      if (scanner.hasNext())
        name = scanner.next();
      else
        continue;
      if (scanner.hasNextInt())
        totalScore = scanner.nextInt();
      else
        continue;
      if (scanner.hasNextInt())
        getScore = scanner.nextInt();
      else
        continue;
      Q21Score newScore = new Q21Score(name, totalScore, getScore);
      arrayList.add(newScore);
    }

    arrayList.stream().forEach(x -> System.out.println(((Q21Score) x).printScore()));

    scanner.close();
  }

}