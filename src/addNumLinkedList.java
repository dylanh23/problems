import java.util.LinkedList;

/**
 * Created by D on 4/25/2017.
 */
public class addNumLinkedList {
  static Node first;
  static Node second;

  public static void main(String[] args) {
    first = new Node(5);
    first.nextNode = new Node(6);
    first.nextNode.nextNode = new Node(3);

    second = new Node(8);
    second.nextNode = new Node(4);
    second.nextNode.nextNode = new Node(2);

//    first = new Node(1);
//    first.nextNode = new Node(2);
//    first.nextNode.nextNode = new Node(3);
//
//    second = new Node(3);
//    second.nextNode = new Node(5);
//    second.nextNode.nextNode = new Node(6);

    System.out.println(addLL(first, second));
  }

  static class Node {
    int v;
    Node nextNode = null;

    Node(int v) {
      this.v = v;
    }
  }

  static int addLL(Node n1, Node n2) {
    if (n1.nextNode == null)
      return n1.v + n2.v;
    else {
      int r = addLL(n1.nextNode, n2.nextNode);
      int a = n1.v + n2.v;
      if (String.valueOf(r).charAt(0) == '-') {
        r *= -1;
        StringBuilder s = new StringBuilder(String.valueOf(r));
        a += Integer.valueOf(String.valueOf(s.charAt(0)));
        s.deleteCharAt(0);
        r = Integer.valueOf(s.toString());
      }
      if (a > 9) {
        return Integer.valueOf("-" + a + "" + r);
      } else {
        return Integer.valueOf(a + "" + r);
      }
    }
  }
}
