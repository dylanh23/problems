import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by D on 3/14/2017.
 */
public class histogram {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    while (n != 0) {
      sc.nextLine();
      A = new int[n];
      for (int i = 0; i < n; i++) {
        A[i] = sc.nextInt();
      }
      System.out.println((answer(0, 0)[0] + n) + " " + answer(0, 0)[1]);
      sc.nextLine();
      n = sc.nextInt();
    }
  }

  static int A[];

  public static int[] answer(int b, int l) {
    int max = 0;
    int count = 0;
    boolean none = true;
    for (int i = 0; i < A.length; i++) {
      if ((b & (1 << i)) == 0) {
        none = false;
        int[] a = answer((b | (1 << i)), A[i]);
        a[0] += +Math.abs(l - A[i]) + 1;
        if (a[0] > max) {
          max = a[0];
          count = a[1];
        } else if (a[0] == max) {
          count += a[1];
        }
      }
    }
    if (none) {
      int[] n = new int[2];
      n[0] = l;
      n[1] = 1;
      return n;
    } else {
      int[] n = new int[2];
      n[0] = max;
      n[1] = count;
      return n;
    }
  }

//  public static int[] answer1(int b, int l) {
//    int max = 0;
//    boolean none = true;
////    ArrayList<Integer> maxes
//    for (int i = 0; i < A.length; i++) {
//      if ((b & (1 << i)) == 0) {
//        none = false;
////        if ()
//        max = Math.max(answer1((b | (1 << i)), A[i]) + Math.abs(l - A[i]) + 1, max);
//      }
//    }
//    if (none) {
//      return l;
//    }
//    return max;
//  }
}
