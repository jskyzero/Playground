
class Q2 {
  public static void main(String[] args) {
    // double (maybe float)
    assert((1 + 2.236) / 2 == 1.608);
    // double (maybe float)
    assert((1 + 2 + 3 + 4.0) == 10.0);
    // boolean
    assert((4.1 > 4) == true);
    // String
    assert("123".equals(1 + 2 + "3"));
  }
}