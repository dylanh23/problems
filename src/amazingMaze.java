import java.awt.*;
import java.util.*;

/**
 * Created by D on 1/31/2017.
 */
public class amazingMaze {

  static Node[][][] grid;

  static int[][][][][] distances;


  public static void main(String[] args) {
    int m, n;
    Scanner sc = new Scanner(System.in);
    m = sc.nextInt();
    n = sc.nextInt();
    while (n != 0) {
      grid = new Node[n][m][4];
      for (int i = 0; i < 4; i++) {
        for (int y = 0; y < m; y++) {
          for (int x = 0; x < n; x++) {
            grid[x][y][i] = new Node();
          }
        }
      }
      sc.nextLine();
      String[][] input = new String[n][m];
      for (int y = 0; y < m; y++) {
        String[] i = sc.nextLine().split("");
        for (int x = 0; x < n; x++) {
          input[x][y] = i[x + 1];
        }
      }

      int k = sc.nextInt();
      Point[] treasureChests = new Point[k];
      sc.nextLine();
      distances = new int[n][m][k + 1][4][4];
//      for (int t = 0; t < 4; t++) {
//        for (int i = 0; i < k; i++) {
//          for (int y = 0; y < m; y++) {
//            for (int x = 0; x < n; x++) {
//              distances[x][y][i][t] = -1;
//            }
//          }
//        }
//      }

      for (int i = 0; i < k; i++) {
        int y = sc.nextInt() - 1;
        int x = sc.nextInt() - 1;
        treasureChests[i] = new Point(x, y);
        sc.nextLine();
      }

      for (int i = 0; i < 4; i++) {
        for (int y = 0; y < m; y++) {
          for (int x = 0; x < n; x++) {
            grid[x][y][i].x = x;
            grid[x][y][i].y = y;
            grid[x][y][i].t = i;

            for (Point p : treasureChests) {
              if (p.x == x && p.y == y) {
                grid[x][y][i].treaure = true;
              }
            }

            grid[x][y][i].childrenNodes.clear();
            int d = (getNum(input[x][y]) + i) % 4;
            if (x > 0 && d == 3) {
              grid[x][y][i].childrenNodes.add(grid[x - 1][y][(i + 1) % 4]);
            } else if (x < n - 1 && d == 1) {
              grid[x][y][i].childrenNodes.add(grid[x + 1][y][(i + 1) % 4]);
            } else if (y > 0 && d == 0) {
              grid[x][y][i].childrenNodes.add(grid[x][y - 1][(i + 1) % 4]);
            } else if (y < m - 1 && d == 2) {
              grid[x][y][i].childrenNodes.add(grid[x][y + 1][(i + 1) % 4]);
            }
            grid[x][y][i].childrenNodes.add(grid[x][y][(i + 1) % 4]);
          }
        }
      }

      for (int i = 0; i < k; i++) {
        for (int r = 0; r < 4; r++) {
          distances[treasureChests[i].x][treasureChests[i].y][i][r][r] = 0;
          bfs(grid[treasureChests[i].x][treasureChests[i].y][r], i, r);
          for (int j = 0; j < 4; j++) {
            for (int y = 0; y < m; y++) {
              for (int x = 0; x < n; x++) {
                grid[x][y][j].visited = false;
              }
            }
          }
        }
      }

      distances[0][0][k][0][0] = 0;
      bfs(grid[0][0][0], k, 0);


      int kFactorial = 1;
      int temp = k;
      while (temp > 1) {
        kFactorial *= temp;
        temp--;
      }
      permOfK = new Point[kFactorial][k];
      i = 0;
      calcPerm(treasureChests, 0);

      int minResult = Integer.MAX_VALUE;
      for (int i = 0; i < kFactorial; i++) {
        int result = 0;

        int min = Integer.MAX_VALUE;
        int oldStart = 0;
        for (int j = 0; j < 4; j++) {
          if (distances[permOfK[i][0].x][permOfK[i][0].y][k][j][0] < min) {
            min = distances[permOfK[i][0].x][permOfK[i][0].y][k][j][0];
            oldStart = j;
          }
        }
        result += min;
        int newStart = 0;
        //might make sense to reach it at a different t to make next move faster
        for (int l = 1; l < k - 1; l++) {
          min = Integer.MAX_VALUE;
          for (int j = 0; j < 4; j++) {
            if (distances[permOfK[i][l + 1].x][permOfK[i][l + 1].y][l][j][oldStart] < min) {
              min = distances[permOfK[i][l + 1].x][permOfK[i][l + 1].y][l][j][oldStart];
              newStart = j;
            }
          }
          oldStart = newStart;
          result += min;
        }
        min = Integer.MAX_VALUE;
        for (int j = 0; j < 4; j++) {
          if (distances[n - 1][m - 1][k - 1][j][oldStart] < min) {
            min = distances[n - 1][m - 1][k - 1][j][oldStart];
          }
        }
        result += min;
        if (result < minResult) {
          minResult = result;
        }
      }
      System.out.println(minResult);
      m = sc.nextInt();
      n = sc.nextInt();
    }
  }

  static Point[][] permOfK;
  static int i;

  static void calcPerm(Point[] inputs, int currentFocus) {
    if (currentFocus == inputs.length - 1) {
      for (int j = 0; j < inputs.length; j++) {
        permOfK[i][j] = inputs[j];
      }
      i++;
      return;
    }
    calcPerm(inputs, currentFocus + 1);
    for (int i = currentFocus + 1; i < inputs.length; i++) {
      Point temp = inputs[currentFocus];
      inputs[currentFocus] = inputs[i];
      inputs[i] = temp;
      calcPerm(inputs, currentFocus + 1);
    }
  }


  private static int getNum(String s) {
    if (s.equals("N")) {
      return 0;
    } else if (s.equals("E")) {
      return 1;
    } else if (s.equals("S")) {
      return 2;
    } else {
      return 3;
    }
  }

  static class Node {
    boolean treaure;
    boolean visited = false;
    ArrayList<Node> childrenNodes = new ArrayList<>();
    int t = 0;
    int x = 0;
    int y = 0;

//    Node(boolean treaure, int x, int y, int t) {
//      this.treaure = treaure;
//      this.x = x;
//      this.y = y;
//      this.t = t;
//    }
  }

  public static void bfs(Node rootNode, int i, int j) {
    Queue queue = new LinkedList();
    queue.add(rootNode);
    rootNode.visited = true;
    while (!queue.isEmpty()) {
      Node node = (Node) queue.remove();
      for (Node n : node.childrenNodes) {
        if (!n.visited) {
          n.visited = true;
//          if (distances[n.x][n.y][i][newT] == -1) {
          distances[n.x][n.y][i][n.t][j] = distances[node.x][node.y][i][node.t][j] + 1;
//          }
          queue.add(n);
        }
      }
    }
  }
}
