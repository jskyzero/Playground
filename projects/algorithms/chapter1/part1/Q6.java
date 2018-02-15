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

  public static void testCodes(Supplier<Integer> func) {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream oldPS = System.out; // IMPORTANT: Save the old System.out!
    changeDefultOutStream(baos, oldPS);
    func.get();
    changeBackDefaultOutStream(oldPS);
    assertResultEqual(baos, "123");
  }

  public static void main(String[] argv) {
    testCodes(() -> {
      System.out.print("123");
      return 1;
    });
  }
}