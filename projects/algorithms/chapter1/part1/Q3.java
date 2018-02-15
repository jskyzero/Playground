import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Q3 {
  public static void main(String[] args) {
    assert (args.length > 1);
    int result = Arrays.asList(args)
                       .stream()
                       .map(x -> {
                         return Integer.parseInt(x) == Integer.parseInt(args[0]);
                       })
                       .collect(Collectors.toList()).stream()
                       .map(x -> x ? 1 : 0)
                       .mapToInt(Integer::intValue)
                       .sum();
    System.out.print(args.length == result ? "equal": "not equal");
  }
}