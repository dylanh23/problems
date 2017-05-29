import java.util.Arrays;

/**
 * Created by D on 4/24/2017.
 */
public class optimalStrategyForGame {
  static int[] A = {20, 30, 2, 2, 2, 10};

  public static void main(String[] args) {
    System.out.println(dp(0, A.length - 1, 1));
  }

  static int dp(int j, int k, int b) {
    if (j > k) {
      return 0;
    } else {
      if (b == 1) {
        if (dp(j + 1, k, 0) + A[j] > dp(j, k - 1, 0) + A[k]) {
          return dp(j + 1, k, 0) + A[j];
        } else {
          return dp(j, k - 1, 0) + A[k];
        }
      } else {
        if (dp(j + 1, k, 1) < dp(j, k - 1, 1)) {
          return dp(j + 1, k, 1);
        } else {
          return dp(j, k - 1, 1);
        }
      }
    }
  }
}
