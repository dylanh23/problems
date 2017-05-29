import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by D on 5/13/2017.
 */
public class dynamicLCA {
  static boolean[][] edges;
  static int n;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    sc.nextLine();
    while (n != 0) {
      edges = new boolean[n][n];
      for (int i = 1; i < n; i++) {
        int a1 = sc.nextInt() - 1;
        int a2 = sc.nextInt() - 1;
        edges[a1][a2] = true;
        sc.nextLine();
      }
      int k = sc.nextInt();
      sc.nextLine();
      for (int i = 0; i < k; i++) {
        String s = sc.nextLine();
        if (s.charAt(0) == '?') {
          System.out.println(lca(Integer.valueOf(String.valueOf(s.charAt(2))) - 1, Integer.valueOf(String.valueOf(s.charAt(4))) - 1));
        } else if (s.charAt(0) == '!') {
          reRoot(Integer.valueOf(String.valueOf(s.charAt(2))) - 1);
        }
      }
      n = sc.nextInt();
      sc.nextLine();
    }
  }

  private static void reRoot(Integer integer) {
    int p = getParent(integer);
    while (p != -1) {
      int tempP = p;
      p = getParent(p);
      edges[integer][tempP] = true;
      edges[tempP][integer] = false;
      integer = tempP;
    }
  }

  private static int getParent(Integer integer) {
    for (int i = 0; i < n; i++) {
      if (edges[i][integer])
        return i;
    }
    return -1;
  }

  private static Integer lca(int c, int c1) {
    ArrayList<Integer> a1 = new ArrayList<>();
    a1.add(c);
    int p = getParent(c);
    while (p != -1) {
      a1.add(p);
      p = getParent(p);
    }
    ArrayList<Integer> a2 = new ArrayList<>();
    a2.add(c1);
    p = getParent(c1);
    while (p != -1) {
      a2.add(p);
      p = getParent(p);
    }
//    Collections.reverse(a1);
//    Collections.reverse(a2);
//    int lca = -1;
//    for (int i = 0; i < a1.size(); i++) {
//      if (a1.get(i) != a2.get(i)) {
//        return lca + 1;
//      }
//      lca = a1.get(i);
//    }
//    return -1;

    int lca = -1;
    int p1 = a1.size() - 1;
    int p2 = a2.size() - 1;
    while (a1.get(p1) == a2.get(p2)) {
      lca = a1.get(p1);
      p1 --;
      p2 --;
    }
    return lca + 1;
  }
}
