import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Created by D on 3/9/2017.
 */
public class mixtures {
  static int[] a;
  static int[][] states;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (true) {
      int n = sc.nextInt();
      sc.nextLine();

      a = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = (sc.nextInt());
      }
      states = new int[n][n];
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          states[i][j] = -1;
        }
      }
      System.out.println(answer(0, n - 1));
      if (sc.hasNextLine()) {
        sc.nextLine();
      } else {
        break;
      }
    }
  }

//  static HashMap<List, Integer> map;
//
//  public static int answer(ArrayList<Integer> m) {
//    if (m.size() == 1) {
//      return 0;
//    } else {
//      if (map.get(m) != null) {
//        return map.get(m);
//      } else {
//        int min = Integer.MAX_VALUE;
//
//        for (int i = 0; i < m.size() - 1; i++) {
//          ArrayList<Integer> newM = (ArrayList) m.clone();
//          int a = newM.get(i);
//          int b = newM.get(i + 1);
//          newM.remove(i);
//          newM.remove(i);
//          newM.add(i, (a + b) % 100);
//          min = Math.min(min, answer(newM) + a * b);
//        }
//        map.put(m, min);
//        return min;
//      }
//    }
//  }

  public static int answer(int j, int k) {
    if (k == j) {
      return 0;
    } else if (states[j][k] != -1) {
      return states[j][k];
    } else {
      int min = Integer.MAX_VALUE;
//    else if (k - 1 == j) {
//      return a[k] * a[j];
//    }
      for (int i = j; i < k; i++) {
        int a1 = answer(j, i);
        int a2 = answer(i + 1, k);
        min = Math.min(a2 + a1 + total(j, i) * total(j + 1, k), min);
      }
      states[j][k] = min;
      return min;
    }
  }

  static int total(int j, int k) {
    int t = 0;
    for (int i = j; i <= k; i++) {
      t += a[i];
    }
    return t % 100;
  }
}
