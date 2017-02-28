import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by D on 2/6/2017.
 */
public class goodCoalition {
  static double[][] states;
  static int[] a;
  static int[] d;
  static int n;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tc = sc.nextInt();
    sc.nextLine();
    for (int i = 0; i < tc; i++) {
      n = sc.nextInt();
      sc.nextLine();
      a = new int[n];
      d = new int[n];
      for (int j = 0; j < n; j++) {
        a[j] = sc.nextInt();
        d[j] = sc.nextInt();
        sc.nextLine();
      }
      states = new double[n][151];
      for (int j = 0; j < n; j++) {
        for (int c = 0; c < 151; c++) {
          states[j][c] = -1;
        }
      }
      System.out.println(dp(0, 0) * 100);
    }
  }

  static double dp(int i, int c) {
    if (states[i][c] != -1) {
      return states[i][c];
    } else {
      double answer = 0;
      if (c > 75) {
        answer = 1;
      } else if (i != n) {
        if (i == n - 1) {
          if (c + a[i] > 75) {
            answer = (double) Math.round(d[i] * 0.01 * 1000000d) / 1000000d;
          }
        } else {
          answer = Math.max((double) Math.round(dp(i + 1, c + a[i]) * (d[i] * 0.01) * 1000000d) / 1000000d, dp(i + 1, c));
        }
      }
      states[i][c] = answer;
      return answer;
    }
  }
}
