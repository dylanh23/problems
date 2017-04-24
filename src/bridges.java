import com.sun.deploy.util.SyncAccess;

import java.util.HashMap;

/**
 * Created by D on 3/14/2017.
 */
public class bridges {

  public static void main(String[] args) {
    A = new int[8];
    A[0] = 8;
    A[1] = 1;
    A[2] = 4;
    A[3] = 3;
    A[4] = 5;
    A[5] = 2;
    A[6] = 6;
    A[7] = 7;
    places.put(1, 0);
    places.put(2, 1);
    places.put(3, 2);
    places.put(4, 3);
    places.put(5, 4);
    places.put(6, 5);
    places.put(7, 6);
    places.put(8, 7);


    System.out.println(dp(-1, 0));
  }

  static int[] A;
  static HashMap<Integer, Integer> places = new HashMap<>();

  public static int dp(int m, int n) {
    int a;
    if (n == A.length) {
      return 0;
    } else {
      if (places.get(A[n]) > m) {
        a = Math.max(dp(places.get(A[n]), n + 1) + 1, dp(m, n + 1));
      } else {
        a = dp(m, n + 1);
      }
      return a;
    }
  }
}
