import java.util.*;

/**
 * Created by D on 1/30/2017.
 */
class Main {
  static Node[][][] grid;
  static int[][][] distances;
  private static int startX, startY;

  public enum nodeData {
    y, b, g, r, X, open, wall
  }

  public static void main(String[] args) {
    int r, c;
    Scanner sc = new Scanner(System.in);
    r = sc.nextInt();
    c = sc.nextInt();
    while (r != 0) {
      grid = new Node[c][r][16];
      for (int i = 0; i <= 15; i++) {
        for (int y = 0; y < r; y++) {
          for (int x = 0; x < c; x++) {
            grid[x][y][i] = new Node(nodeData.y, 0, 0, 0);
          }
        }
      }
      sc.nextLine();
      startX = -1;
      startY = -1;
      distances = new int[c][r][16];
      String[][] input = new String[c][r];
      for (int y = 0; y < r; y++) {
        String[] i = sc.nextLine().split("");
        for (int x = 0; x < c; x++) {
          input[x][y] = i[x + 1];
        }
      }
      for (int i = 0; i <= 15; i++) {
        for (int y = 0; y < r; y++) {
          for (int x = 0; x < c; x++) {
            changeNode(input[x][y], i, x, y, grid[x][y][i]);
            grid[x][y][i].childrenNodes.clear();
            if (getNode(input[x][y], i)) {
              if (x > 0 && getNode(input[x - 1][y], i)) {
                grid[x][y][i].childrenNodes.add(grid[x - 1][y][i]);
              }
              if (x < c - 1 && getNode(input[x + 1][y], i)) {
                grid[x][y][i].childrenNodes.add(grid[x + 1][y][i]);
              }
              if (y > 0 && getNode(input[x][y - 1], i)) {
                grid[x][y][i].childrenNodes.add(grid[x][y - 1][i]);
              }
              if (y < r - 1 && getNode(input[x][y + 1], i)) {
                grid[x][y][i].childrenNodes.add(grid[x][y + 1][i]);
              }
            }
          }
        }
      }
      distances[startX][startY][0] = 0;
      int answer = bfs(grid[startX][startY][0]);
      if (answer == -1) {
        System.out.println("The poor student is trapped!");
      } else {
        System.out.println("Escape possible in " + answer + " steps.");
      }
      r = sc.nextInt();
      c = sc.nextInt();
    }
  }

  private static boolean getNodeJustOpen(String s, int i) {
    if (s.equals("*")
        || (s.equals("R") && ((i & 1) != 0)) || (s.equals("Y") && ((i & 8) != 0)) || (s.equals("B") && ((i & 2) != 0)) || (s.equals("G") && ((i & 4) != 0))
        || s.equals(".")
        || (s.equals("r") && ((i & 1) != 0)) || (s.equals("y") && ((i & 8) != 0)) || (s.equals("b") && ((i & 2) != 0)) || (s.equals("g") && ((i & 4) != 0))
        || s.equals("X")
        ) {
      return true;
    }
    return false;
  }

  private static boolean getNode(String s, int i) {
    if (s.equals("*")
        || (s.equals("R") && ((i & 1) != 0)) || (s.equals("Y") && ((i & 8) != 0)) || (s.equals("B") && ((i & 2) != 0)) || (s.equals("G") && ((i & 4) != 0))
        || s.equals(".")
        || s.equals("r") || s.equals("b") || s.equals("y") || s.equals("g")
        || s.equals("X")
        ) {
      return true;
    }
    return false;
  }

  static void changeNode(String s, int i, int xIndex, int yIndex, Node n) {
    nodeData nd = nodeData.wall;
    if (getNodeJustOpen(s, i)) {
      nd = nodeData.open;
      if (s.equals("*") && startX == -1) {
        startX = xIndex;
        startY = yIndex;
      } else if (s.equals("X")) {
        nd = nodeData.X;
      }
    } else if (s.equals("r")) {
      nd = nodeData.r;
    } else if (s.equals("g")) {
      nd = nodeData.g;
    } else if (s.equals("y")) {
      nd = nodeData.y;
    } else if (s.equals("b")) {
      nd = nodeData.b;
    }
    n.data = nd;
    n.x = xIndex;
    n.y = yIndex;
    n.S = i;
  }

  static class Node {
    nodeData data;
    boolean visited = false;
    ArrayList<Node> childrenNodes = new ArrayList<>();
    int S, x, y;

    Node(nodeData data, int x, int y, int S) {
      this.data = data;
      this.x = x;
      this.y = y;
      this.S = S;
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
          n.visited = true;
          distances[n.x][n.y][n.S] = distances[node.x][node.y][node.S] + 1;
          if (n.data == nodeData.r) {
            distances[n.x][n.y][n.S | 1] = distances[node.x][node.y][node.S] + 1;
            grid[n.x][n.y][n.S | 1].visited = true;
            queue.add(grid[n.x][n.y][n.S | 1]);
          } else if (n.data == nodeData.y) {
            distances[n.x][n.y][n.S | 8] = distances[node.x][node.y][node.S] + 1;
            grid[n.x][n.y][n.S | 8].visited = true;
            queue.add(grid[n.x][n.y][n.S | 8]);
          } else if (n.data == nodeData.b) {
            distances[n.x][n.y][n.S | 2] = distances[node.x][node.y][node.S] + 1;
            grid[n.x][n.y][n.S | 2].visited = true;
            queue.add(grid[n.x][n.y][n.S | 2]);
          } else if (n.data == nodeData.g) {
            distances[n.x][n.y][n.S | 4] = distances[node.x][node.y][node.S] + 1;
            grid[n.x][n.y][n.S | 4].visited = true;
            queue.add(grid[n.x][n.y][n.S | 4]);
          } else if (n.data == nodeData.X) {
            return distances[node.x][node.y][node.S] + 1;
          } else {
            queue.add(n);
          }
        }
      }
    }
    return -1;
  }
}
