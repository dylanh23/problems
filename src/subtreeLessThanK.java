import java.nio.channels.ScatteringByteChannel;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by D on 2/26/2017.
 */
public class subtreeLessThanK {
  static node[] nodes;
  static int K;

  static class node {
    ArrayList<node> children = new ArrayList<>();
    int t;

    public node(int t) {
      this.t = t;
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    K = sc.nextInt();
    nodes = new node[n];
    for (int i = 0; i < n; i++) {
      nodes[i] = new node(i);
    }
    for (int i = 0; i < n - 1; i++) {
      nodes[sc.nextInt() - 1].children.add(nodes[sc.nextInt() - 1]);
    }
    int a = 0;
    for (int i = 0; i < n; i++) {
      for (int k = 1; k <= K; k++) {
        a += dp(i, k);
      }
    }
    System.out.println(a);
  }

  static int f(int t, int k) {
    if (k > 0) {
      node r = nodes[t];
      int a = 1;
      for (node c : r.children) {
        a *= 1 + f(c.t, k - 1);
      }
      return a;
    } else {
      return 0;
    }
  }


  static int dp(int i, int j) {
    if (i >= 0) {
      int a = 0;
      for (int k = 0; k <= K; ) {
        a += dp(i - 1, j - k);
      }
      return a;
    } else {
      return 0;
    }
  }

}
