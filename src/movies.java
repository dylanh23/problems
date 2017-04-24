import java.util.ArrayList;

/**
 * Created by D on 3/8/2017.
 */
public class movies {

  static int S, F;

  public static void main(String[] args) {
//    Scanner sc = new Scanner(System.in);
    Node a = new Node();
    Node b = new Node();
    Node c = new Node();
    Node e = new Node();
    Node d = new Node();
    Node f = new Node();
    Node g = new Node();
    a.children.add(b);
    a.children.add(c);
    b.children.add(d);
    b.children.add(e);
    b.children.add(f);
    b.children.add(g);
    S = 1;
    F = 3;
    System.out.println(answer(a, false)[0]);
  }

  static class Node {
    ArrayList<Node> children = new ArrayList<>();

    Node() {

    }
  }

  static int answer2(Node root, boolean paid) {
    int a = 0;
    for (Node c : root.children) {
      a += answer2(c, true);
    }
    a += F;
    int a2 = 0;
    for (Node c : root.children) {
      a2 += answer2(c, false);
    }
    if (!paid) {
      a2 += S;
    }
    return (Math.min(a, a2));
  }

  static int[] answer(Node root, boolean paid) {
    int[] a2 = new int[3];
    if (!paid) {
      a2[0] += S;
      a2[1]++;
    }
    if (root.children.isEmpty()) {
      return a2;
    } else {
      int[] a = new int[3];
      for (Node c : root.children) {
        a[0] += answer(c, true)[0];
        a[1] += answer(c, true)[1];
        a[2] += answer(c, true)[2];
      }
      a[0] += F;
      a[2]++;
      for (Node c : root.children) {
        a2[0] += answer(c, false)[0];
        a2[1] += answer(c, false)[1];
        a2[2] += answer(c, false)[2];
      }
      if (a2[0] < a[0]) {
        return a2;
      } else if (a2[0] > a[0]) {
        return a;
      } else {
        if (a[1] + a[2] < a2[1] + a2[2]) {
          return a;
        } else {
          return a2;
        }
      }
    }
  }
}
