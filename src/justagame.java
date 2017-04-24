import java.util.Scanner;

/**
 * Created by D on 3/8/2017.
 */
public class justagame {
  static int A, B;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (sc.hasNextInt()) {
      A = sc.nextInt();
      B = sc.nextInt();
      if (A == -1) {
        break;
      }
      states = new int[A + 1][B + 1];
      for (int a = 0; a <= A; a++) {
        for (int b = 0; b <= B; b++) {
          states[a][b] = -1;
        }
      }
      int a = answer(0, 0);
      if (a == A + B) {
        System.out.println(A + "+" + B + "=" + a);
      } else {
        System.out.println(A + "+" + B + "!=" + a);
      }
      sc.nextLine();
    }
  }

  static int[][] states;

  static int answer(int a, int b) {
    if (states[a][b] != -1) {
      return states[a][b];
    } else {
      if (a == A && b == B) {
        return 1;
      }
      int r = 0;
      if (a < A) {
        r += answer(a + 1, b);
      }
      if (b < B) {
        r += answer(a, b + 1);
      }
      states[a][b] = r;
      return r;
    }
  }
}
