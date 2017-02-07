import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by D on 1/24/2017.
 */
class lecturescheduling {
  static int n;
  static int k, l;
  static int x[];
  private static o[][] states;

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer toks = new StringTokenizer(reader.readLine());
    n = Integer.parseInt(toks.nextToken());
    int tc = 1;
    while (n != 0) {
      toks = new StringTokenizer(reader.readLine());
      l = Integer.parseInt(toks.nextToken());
      k = Integer.parseInt(toks.nextToken());
      x = new int[n];
      for (int i = 0; i < n; i++) {
        toks = new StringTokenizer(reader.readLine());
        x[i] = Integer.parseInt(toks.nextToken());
      }
      states = new o[n + 1][l + 1];
      for (int i = 0; i < n + 1; i++) {
        for (int x = 0; x < l + 1; x++) {
          states[i][x] = new o(-1, 0);
        }
      }
      o answer = dp(0, l);
      System.out.println("Case " + tc + ":");
      System.out.println("Minimum number of lectures: " + (answer.l + 1));
      System.out.println("Total dissatisfaction index: " + answer.di);
      toks = new StringTokenizer(reader.readLine());
      n = Integer.parseInt(toks.nextToken());
      if (n != 0) {
        System.out.println();
        tc++;
      }
    }
  }

  static class o {
    int l;
    int di;

    o(int l, int di) {
      this.l = l;
      this.di = di;
    }
  }

  static o dp(int i, int c) {
    if (states[i][c].l != -1) {
      return new o(states[i][c].l, states[i][c].di);
    } else {
      o a;
      if (i == n) {
        int di = 0;
        if (c >= 1 && c <= 10) {
          di = -k;
        } else if (c > 10) {
          di = (int) Math.pow((c - 10), 2);
        }
        a = new o(0, di);
      } else {
        if (c == l) {
          a = dp(i + 1, c - x[i]);
        } else {
          a = dp(i, l);
          if (c >= 1 && c <= 10) {
            a.di -= k;
          } else if (c > 10) {
            a.di += Math.pow((c - 10), 2);
          }
          a.l += 1;

          if (c - x[i] >= 0) {
            o v = dp(i + 1, c - x[i]);
            if ((v.l < a.l) || (v.l == a.l && v.di < a.di)) {
              a = v;
            }
          }
        }
      }
      states[i][c] = new o(a.l, a.di);
      return a;
    }
  }
}
