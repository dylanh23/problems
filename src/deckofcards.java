import sun.security.provider.certpath.Vertex;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by D on 1/23/2017.
 */
public class deckofcards {
  public static void main(String[] args) {
    class vertex {
      boolean visited = false;
      boolean gouverment;
      List<Integer> children = new ArrayList<>();
    }
    Scanner sc = new Scanner(System.in);
    HashMap<Integer, vertex> map = new HashMap<>();
    int n = sc.nextInt();
    for (int i = 1; i <= n; i++) {
      map.put(i, new vertex());
    }
    int m = sc.nextInt();
    int g = sc.nextInt();
    sc.nextLine();
    for (int i = 0; i < g; i++) {
      map.get(sc.nextInt()).gouverment = true;
    }
    sc.nextLine();
    for (int i = 0; i < m; i++) {
      int first = sc.nextInt();
      int second = sc.nextInt();
      sc.nextLine();
      map.get(first).children.add(second);
      map.get(second).children.add(first);
    }
    ArrayList<Integer> gouvermentBranchesCount = new ArrayList<>();
    int totalNonSpecial = 0;
    for (int i = 1; i <= n; i++) {
      vertex v = map.get(i);
      if (!v.visited) {
        boolean gouverment = false;
        int count = 1;
        Stack<vertex> stack = new Stack<>();
        stack.add(v);
        v.visited = true;
        if (v.gouverment) {
          gouverment = true;
        }
        while (!stack.isEmpty()) {
          vertex element = stack.pop();

          for (int j = 0; j < element.children.size(); j++) {
            vertex k = map.get(element.children.get(j));
            if (k != null && !k.visited) {
              stack.add(k);
              k.visited = true;
              if (k.gouverment) {
                gouverment = true;
              }
              count++;
            }
          }
        }
        if (gouverment) {
          gouvermentBranchesCount.add(count);
        } else {
          totalNonSpecial += count;
        }
      }
    }

//    for (int i = 1; i <= n; i++) {
//      vertex v = map.get(i);
//      if (!v.visited) {
//        int count = 1;
//        Stack<vertex> stack = new Stack<>();
//        stack.add(v);
//        v.visited = true;
//        while (!stack.isEmpty()) {
//          vertex element = stack.pop();
//
//          for (int j = 0; j < element.children.size(); j++) {
//            vertex k = map.get(element.children.get(j));
//            if (k != null && !k.visited) {
//              stack.add(k);
//              k.visited = true;
//              count++;
//            }
//          }
//        }
//        totalNonSpecial += count;
//      }
//    }
//    int max = 0;
//    int index = 0;
//    for (int i = 0; i < gouvermentBranchesCount.size(); i++) {
//      if (gouvermentBranchesCount.get(i) > max) {
//        max = gouvermentBranchesCount.get(i);
//        index = i;
//      }
//    }
//    gouvermentBranchesCount.remove(index);
//    int total = nChooseK(totalNonSpecial + max, 2);
//    for (int i = 0; i < gouvermentBranchesCount.size(); i++) {
//        total += nChooseK(gouvermentBranchesCount.get(i), 2);
//    }
    Collections.sort(gouvermentBranchesCount);
    Collections.reverse(gouvermentBranchesCount);
    int total = nChooseK(gouvermentBranchesCount.get(0) + totalNonSpecial, 2);
    for (int i = 1; i < gouvermentBranchesCount.size(); i++) {
      total += nChooseK(gouvermentBranchesCount.get(i), 2);
    }
    System.out.print(total - m);
  }

  static private int nChooseK(long n, long k) {
    if (k == 0) return 1;
    return (int) (nChooseK(n, k - 1) * (n - k + 1) / k);
  }


}
