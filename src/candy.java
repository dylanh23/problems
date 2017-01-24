import java.util.Scanner;

/**
 * Created by D on 12/9/2016.
 */
public class candy {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int s = Integer.parseInt(sc.nextLine());
    A = new int[s];
    V = new int[s];
    for (int i = 0; i < s; i++)
      A[i] = Integer.parseInt(sc.nextLine());
    for (int i = 0; i < s; i++)
      V[i] = -1;
    getI(0);
  }

  static int[] A;
  static int[] V;

  static int getI(int i) {
    int v = A[i];
    int lv = 0, r = 0, l = 0, rv = 0;
    if (i - 1 > 0) {
      lv = A[i - 1];
      if (V[i - 1] != -1) {
        l = V[i - 1];
      } else {
        l = getI(i - 1);
      }
    }
    if (i + 1 < A.length) {
      rv = A[i + 1];
      if (V[i + 1] != -1) {
        r = V[i + 1];
      } else {
        r = getI(i + 1);
      }
    }

    if (v > lv && v < rv) {
      V[i] = (l > r) ? l + 1 : r + 1;
      return (l > r) ? l + 1 : r + 1;
    } else if (v > lv) {
      V[i] = l + 1;
      return l + 1;
    } else if (v > r) {
      V[i] = r + 1;
      return r + 1;
    }
    return 1;
  }
}
