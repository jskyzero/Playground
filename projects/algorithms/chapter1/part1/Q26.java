/**
 * Q26
 */
public class Q26 {
  public static void main(String[] args) {
    int a = 0, b = 1, c = 2, t = 0;

    if (a > b) {t = a; a = b; b = t;}
    if (a > c) {t = a; a = c; c = t;}
    if (b > c) {t = b; b = c; c = a;}

    // why can sort ?
    // a b c
    // a > b and a > c makes a is smallest
    // b > c  makes b is smaller than c
    // so a <= b <= c
    // this is like basic sort let smaller one be left.
  }
}