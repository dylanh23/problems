import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by D on 1/16/2017.
 */
public class onepunchman {
  static int r, n;
  static int[] x;
  static int[] a = new int[100000];
  static int[] b = new int[100000];

  public static void main(String[] args) throws IOException {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer toks = new StringTokenizer(reader.readLine());
    int tc = Integer.parseInt(toks.nextToken());
    for (int i = 0; i < tc; i++) {
      toks = new StringTokenizer(reader.readLine());
      n = Integer.parseInt(toks.nextToken());
      r = Integer.parseInt(toks.nextToken());
      int k = Integer.parseInt(toks.nextToken());
      class w {
        int e;
        int u;

        w(int e, int u) {
          this.e = e;
          this.u = u;
        }
      }
      w[] v = new w[n];
      x = new int[n];
      for (int j = 0; j < n; j++) {
        toks = new StringTokenizer(reader.readLine());
        x[j] = Integer.parseInt(toks.nextToken());
        v[j] = new w(x[j], Integer.parseInt(toks.nextToken()));
      }


      Arrays.sort(v, new Comparator<w>() {
        @Override
        public int compare(w o1, w o2) {
          return Integer.compare(o1.e, o2.e);
        }
      });

      int total = 0;
      for (int j = 0; j < n; j++) {
        total += v[j].u;
        a[j] = total;
        x[j] = v[j].e;
      }

      for (int j = 0; j < n; j++) {
        for (int h = 0; h <= k; h++) {
          states[j][h] = -1;
        }
      }
      for (int j = 0; j < n; j++) {
        b[j] = -1;
      }
      for (int j = n - 1; j >= 0; j--) {
        for (int q = 0; q <= k; q++) {
          dp(j, q);
        }
      }
      System.out.println("Case " + (i + 1) + ": " + dp(0, k));
    }
  }

  static int[][] states = new int[100000][51];

  static int dp(int i, int k) {
    if (i == n) {
      return 0;
    } else {
      if (states[i][k] == -1) {
        int value;

        if (k > 0) {
          int low = i;
          int high = n - 1;
          int j;
          if (b[i] == -1) {
            int max = r * 2 + x[i];
            j = i;

            while (high >= low) {
              int middle = (low + high) / 2;
              if (x[middle] <= max) {
                low = middle + 1;
                j = middle;
              }
              if (x[middle] > max) {
                high = middle - 1;
              }
            }
            b[i] = j;
          } else {
            j = b[i];
          }
          int s;
          if (i > 0) {
            s = a[j] - a[i - 1];
          } else {
            s = a[j];
          }
          value = Math.max(dp(i + 1, k), dp(j + 1, k - 1) + s);
        } else {
          value = 0;
        }

        states[i][k] = value;
        return value;
      } else {
        return states[i][k];
      }
    }
  }

}

