import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.function.Supplier;

class Q6 {
  public static void changeDefultOutStream(ByteArrayOutputStream baos, PrintStream oldPS) {
    // Create a stream to hold the output
    PrintStream newPS = new PrintStream(baos);
    // Tell Java to use your special stream
    System.setOut(newPS);
  }

  public static void assertResultEqual(ByteArrayOutputStream baos, String result) {
    assert (baos.toString().equals(result));
  }

  public static void changeBackDefaultOutStream(PrintStream oldPS) {
    System.out.flush();
    System.setOut(oldPS);
  }

  public static void testCodes(Supplier<Integer> func, String result) {
    // IMPORTANT: Save the old System.out!
    PrintStream oldPS = System.out;
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    changeDefultOutStream(baos, oldPS);
    func.get();
    changeBackDefaultOutStream(oldPS);
    assertResultEqual(baos, result);
  }

  public static void main(String[] argv) {
    testCodes(() -> {
      int f = 0;
      int g = 1;
      for (int i = 0; i <= 8; i++) {
        System.out.print(f);
        f = f + g;
        g = f - g;
      }
      return 0;
    }, "01123581321");
    // f: 0 1 1 2 3 5 8 13 21 
    // g: 1 0 1 1 2 3 5 8  13
  }
}