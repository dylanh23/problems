import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by D on 4/25/2017.
 */
public class biparite {
  static int G[][] = {
      {0, 1, 0, 1},
      {1, 0, 1, 0},
      {0, 1, 0, 1},
      {1, 0, 1, 0}
  };

  static int C[] = {0, 0, 0, 0};
//  static boolean V[] = {false, false, false, false};
  static boolean V[] = {false, false, false, false};

  static int N = 4;

  public static void main(String[] args) {
    for (int i = 0; i < N; i++) {
      if (!V[i]) {
        if (dfs2(-1, i)) {
          System.out.println(true);
        }
      }
    }

    for (int i = 0; i < N; i++) {
      if (!V[i]) {
        if (dfs2(1, i)) {
          System.out.println(true);
        }
      }
    }
  }

  static class Node {
    ArrayList<Node> children = new ArrayList<>();
    int c = 0;
  }

  public static boolean dfs(int c, Node root) {
    if (root.c == 0 || root.c == c) {
      root.c = c;
      for (Node child : root.children) {
        if (!dfs(c * -1, child)) {
          return false;
        }
      }
      return true;
    } else {
      return false;
    }
  }

  public static boolean dfs2(int c, int root) {
    if (C[root] == 0 || C[root] == c) {
      V[root] = true;
      C[root] = c;
      for (int i = 0; i < N; i++) {
        if (G[root][i] == 1 && !V[i]) {
          if (!dfs2(c * -1, i)) {
            return false;
          }
        }
      }
      return true;
    } else {
      return false;
    }
  }
}
