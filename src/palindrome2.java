import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by D on 1/24/2017.
 */
class palindrome2 {

  static String s;

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer toks = new StringTokenizer(reader.readLine());
    int t = Integer.parseInt(toks.nextToken());
    for (int i = 0; i < t; i++) {
      toks = new StringTokenizer(reader.readLine());
      s = toks.nextToken();
      dp = new int[s.length() - 1][s.length()];
      for (int k = 0; k < s.length() - 1; k++) {
        for (int j = s.length() - 1; j > 0; j--) {
          dp[i][j] = -1;
        }
      }
//      for (int j = s.length() - 1; j >= 0; j--) {
//        dp(s, j);
//      }
      System.out.println(w(0, s.length() - 1));
    }
  }

//  static HashMap<p, Integer> map = new HashMap<>();

  static int[][] dp;

  static class p {
    String s;
    int i;

    p(String s, int i) {
      this.s = s;
      this.i = i;
    }
  }

  static int w(int i, int j) {
    if (j > i && (i < s.length() - 1 && j > 0)) {
      if (dp[i][j] != -1) {
        return dp[i][j];
      } else {
        int a = isPalindrome(i, j);
        if (a == -1) {
          StringBuilder sb = new StringBuilder(s);
          sb.deleteCharAt(i);
          a = Math.max(Math.max(w(i, j - 1), w(i + 1, j)), w(i + 1, j - 1));
        }
        dp[i][j] = a;
        return a;
      }
    }
    return 0;
  }

  private static int isPalindrome(int i, int j) {
    StringBuilder sb = new StringBuilder(s);
    if (sb.reverse().toString().equals(s)) {
      return sb.length();
    } else {
      return -1;
    }
  }
}
