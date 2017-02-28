//import java.awt.*;
//import java.util.*;
//import java.util.regex.Matcher;
//
///**
// * Created by D on 2/7/2017.
// */
//public class hotdogs {
//  static int r, c;
//  static int distances[][];
//  static boolean visited[][];
//  static ArrayList<n> nodes;
//  static HashMap<Integer, ArrayList<n2>> map;
//
//  static class n {
//    int x, y, d;
//
//    n(int x, int y, int d) {
//      this.x = x;
//      this.y = y;
//      this.d = d;
//    }
//  }
//
//  static class n2 {
//    int x, y;
//
//    n2(int x, int y) {
//      this.x = x;
//      this.y = y;
//    }
//  }
//
//  public static void main(String[] args) {
//    Scanner sc = new Scanner(System.in);
//    Queue stands = new LinkedList();
//    int tc = sc.nextInt();
//    sc.nextLine();
//    for (int l = 0; l < tc; l++) {
//      int n = sc.nextInt();
//      c = sc.nextInt();
//      r = sc.nextInt();
//      sc.nextLine();
//      distances = new int[c][r];
//      visited = new boolean[c][r];
//      for (int i = 0; i < n; i++) {
//        int x = sc.nextInt();
//        int y = sc.nextInt();
//        sc.nextLine();
//        stands.add(new Point(x, y));
//        distances[x][y] = 0;
//        visited[x][y] = true;
//      }
//      bfs(stands);
////      nodes = new ArrayList<>();
////      for (int j = 0; j < c; j++) {
////        for (int k = 0; k < r; k++) {
////          nodes.add(new n(j, k, distances[j][k]));
////        }
////      }
////      Collections.sort(nodes, new Comparator<n>() {
////        @Override
////        public int compare(n o1, n o2) {
////          return lessThan(o1.d, o2.d);
////        }
////      });
////      int max = -1;
////      for (n node : nodes) {
////        if (node.d >= max) {
////          max = Math.max(max, Math.min(furthestAwayAboveOrEqual(node.x, node.y, node.d), node.d));
////        } else {
////          break;
////        }
////      }
////      System.out.println(max);
//
//      map = new HashMap<>();
//      for (int j = 0; j < c; j++) {
//        for (int k = 0; k < r; k++) {
//          if (map.get(distances[j][k]) == null) {
//            ArrayList<n2> a = new ArrayList<>();
//            a.add(new n2(j, k));
//            map.put(distances[j][k], a);
//          } else {
//            map.get(distances[j][k]).add(new n2(j, k));
//          }
//        }
//      }
//      int low = 0;
//      int high = 0;
//      while (high >= low) {
//        int middle = (low + high) / 2;
//        if (data[middle] == key) {
//
//        }
//        if (data[middle] < key) {
//          low = middle + 1;
//        }
//        if (data[middle] > key) {
//          high = middle - 1;
//        }
//      }
//    }
//  }
//
//  static int lessThan(int x, int y) {
//    if (x > y) return -1;
//    else if (x == y) return 0;
//    else return 1;
//  }
//
//
//  private static int furthestAwayAboveOrEqual(int j, int k, int d) {
//    int max = -1;
//    for (n node : nodes) {
//      if (node.d >= d) {
//        max = Math.max(Math.abs(j - node.x) + Math.abs(k - node.y), max);
//      } else {
//        break;
//      }
//    }
//    return max;
//  }
//
//  public static void bfs(Queue queue) {
//    while (!queue.isEmpty()) {
//      Point p = (Point) queue.remove();
//      if (p.getX() > 0) {
//        Point newP = new Point((int) p.getX() - 1, (int) p.getY());
//        if (!visited[(int) newP.getX()][(int) newP.getY()]) {
//          visited[(int) newP.getX()][(int) newP.getY()] = true;
//          distances[(int) newP.getX()][(int) newP.getY()] = distances[(int) p.getX()][(int) p.getY()] + 1;
//          queue.add(newP);
//        }
//      }
//      if (p.getX() < c - 1) {
//        Point newP = new Point((int) p.getX() + 1, (int) p.getY());
//        if (!visited[(int) newP.getX()][(int) newP.getY()]) {
//          visited[(int) newP.getX()][(int) newP.getY()] = true;
//          distances[(int) newP.getX()][(int) newP.getY()] = distances[(int) p.getX()][(int) p.getY()] + 1;
//          queue.add(newP);
//        }
//      }
//      if (p.getY() > 0) {
//        Point newP = new Point((int) p.getX(), (int) p.getY() - 1);
//        if (!visited[(int) newP.getX()][(int) newP.getY()]) {
//          visited[(int) newP.getX()][(int) newP.getY()] = true;
//          distances[(int) newP.getX()][(int) newP.getY()] = distances[(int) p.getX()][(int) p.getY()] + 1;
//          queue.add(newP);
//        }
//      }
//      if (p.getY() < r - 1) {
//        Point newP = new Point((int) p.getX(), (int) p.getY() + 1);
//        if (!visited[(int) newP.getX()][(int) newP.getY()]) {
//          visited[(int) newP.getX()][(int) newP.getY()] = true;
//          distances[(int) newP.getX()][(int) newP.getY()] = distances[(int) p.getX()][(int) p.getY()] + 1;
//          queue.add(newP);
//        }
//      }
//    }
//  }
//}
