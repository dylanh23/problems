import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by D on 1/24/2017.
 */
class palindrome {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer toks = new StringTokenizer(reader.readLine());
    int t = Integer.parseInt(toks.nextToken());
    for (int i = 0; i < t; i++) {
      toks = new StringTokenizer(reader.readLine());
      String s = toks.nextToken();
//      for (int j = s.length() - 1; j >= 0; j--) {
//        dp(s, j);
//      }
      System.out.println(dp(s, 0));
    }
  }

  static HashMap<p, Integer> map = new HashMap<>();

  static class p {
    String s;
    int i;

    p(String s, int i) {
      this.s = s;
      this.i = i;
    }
  }

  static int dp(String s, int i) {
    p k = new p(s, i);
    if (map.get(k) != null) {
      return map.get(k);
    } else {
      int a = 0;
      if (s.length() > 0) {
        a = isPalindrome(s);
        if (a == -1) {
          if (i < s.length()) {
            StringBuilder sb = new StringBuilder(s);
            sb.deleteCharAt(i);
            a = Math.max(dp(sb.toString(), i), dp(s, i + 1));
          }
        }
      }
      map.put(k, a);
      return a;
    }
  }

  private static int isPalindrome(String s) {
    StringBuilder sb = new StringBuilder(s);
    if (sb.reverse().toString().equals(s)) {
      return sb.length();
    } else {
      return -1;
    }
  }
}
