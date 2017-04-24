import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by D on 4/24/2017.
 */
public class maximumPathBinaryTree {

  public static void main(String[] args) {
    Node root = new Node(10);
    root.l = new Node(2);
    root.r = new Node(10);
    root.l.l = new Node(20);
    root.l.r = new Node(1);
    root.r.r = new Node(-25);
    root.r.r.l = new Node(3);
    root.r.r.r = new Node(4);
    answer(root);
    System.out.println(bfs(root));
  }

  static class Node {
    Node l, r;
    int v;
    Node(int v) {
      this.v = v;
    }
  }

  static HashMap<Node, Integer> map = new HashMap<>();

   static int answer(Node node) {
     if (node == null) {
      return 0;
     } else if (map.get(node) != null) {
       return map.get(node);
     } else {
       int l = answer(node.l);
       int r = answer(node.r);
       int a = Math.max(l, r) + node.v;
       map.put(node, a);
       return a;
     }
   }

  static int bfs(Node node) {
    Queue<Node> queue = new LinkedList<>();
    queue.add(node);
    int max = Integer.MIN_VALUE;
    while (!queue.isEmpty()) {
      Node n = queue.remove();
      int a = n.v;
      if (n.l != null) {
        a += map.get(n.l);
        queue.add(n.l);
      }
      if (n.r != null) {
        a += map.get(n.r);
        queue.add(n.r);
      }
      if (a > max) {
        max = a;
      }
    }
    return max;
  }

}
