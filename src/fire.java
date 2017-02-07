import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by D on 2/6/2017.
 */
public class fire {
  static Node[][] grid;
  static int[][] distances;
  static int[][] fire;
  private static int startX, startY;
  static int r, c;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tc = sc.nextInt();
    sc.nextLine();
    for (int l = 0; l < tc; l++) {
      c = sc.nextInt();
      r = sc.nextInt();

      grid = new Node[c][r];
      for (int y = 0; y < r; y++) {
        for (int x = 0; x < c; x++) {
          grid[x][y] = new Node(0, 0);
        }
      }
      sc.nextLine();
      startX = -1;
      startY = -1;
      distances = new int[c][r];
      fire = new int[c][r];
      String[][] input = new String[c][r];
      for (int y = 0; y < r; y++) {
        String[] i = sc.nextLine().split("");
        for (int x = 0; x < c; x++) {
          input[x][y] = i[x + 1];
        }
      }
      ArrayList<Point> fireSpots = new ArrayList<>();
      for (int y = 0; y < r; y++) {
        for (int x = 0; x < c; x++) {
          grid[x][y].childrenNodes.clear();
          if (open(input[x][y]) || input[x][y].equals("*")) {
            grid[x][y].x = x;
            grid[x][y].y = y;
            if (input[x][y].equals("@")) {
              startX = x;
              startY = y;
            }
            fire[x][y] = -1;
            if (x > 0 && open(input[x - 1][y])) {
              grid[x][y].childrenNodes.add(grid[x - 1][y]);
            }
            if (x < c - 1 && open(input[x + 1][y])) {
              grid[x][y].childrenNodes.add(grid[x + 1][y]);
            }
            if (y > 0 && open(input[x][y - 1])) {
              grid[x][y].childrenNodes.add(grid[x][y - 1]);
            }
            if (y < r - 1 && open(input[x][y + 1])) {
              grid[x][y].childrenNodes.add(grid[x][y + 1]);
            }
            if (input[x][y].equals("*")) {
              fireSpots.add(new Point(x, y));
            }
          }
        }
      }
      distances[startX][startY] = 0;
      for (Point p : fireSpots) {
        fire[p.x][p.y] = 0;
        fireBfs(grid[p.x][p.y]);
        for (int y = 0; y < r; y++) {
          for (int x = 0; x < c; x++) {
            grid[x][y].visited = false;
          }
        }
      }
      int answer = bfs(grid[startX][startY]);
      if (answer == -1) {
        System.out.println("IMPOSSIBLE");
      } else {
        System.out.println(answer);
      }
    }
  }

  private static void fireBfs(Node rootNode) {
    Queue queue = new LinkedList();
    queue.add(rootNode);
    rootNode.visited = true;
    while (!queue.isEmpty()) {
      Node node = (Node) queue.remove();
      for (Node n : node.childrenNodes) {
        if (!n.visited) {
          n.visited = true;
          queue.add(n);
          if (fire[n.x][n.y] == -1 || fire[node.x][node.y] + 1 < fire[n.x][n.y]) {
            fire[n.x][n.y] = fire[node.x][node.y] + 1;
          }
        }
      }
    }
  }

  private static boolean open(String s) {
    return s.equals("@") || s.equals(".");
  }

  static class Node {
    boolean visited = false;
    ArrayList<Node> childrenNodes = new ArrayList<>();
    int x, y;

    Node(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public static int bfs(Node rootNode) {
    Queue queue = new LinkedList();
    queue.add(rootNode);
    rootNode.visited = true;
    while (!queue.isEmpty()) {
      Node node = (Node) queue.remove();
      for (Node n : node.childrenNodes) {
        if (!n.visited) {
          if (n.x == 0 || n.x == c - 1 || n.y == 0 || n.y == r - 1) {
            return distances[node.x][node.y] + 2;
          }
          n.visited = true;
          distances[n.x][n.y] = distances[node.x][node.y] + 1;
          if (fire[n.x][n.y] > distances[node.x][node.y] + 1) {
            queue.add(n);
          }
        }
      }
    }
    return -1;
  }
}
