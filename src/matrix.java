import java.util.Scanner;

/**
 * Created by D on 12/10/2016.
 */
public class matrix {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int m = sc.nextInt();
    int n = sc.nextInt();
    int rotation = sc.nextInt();
    int[][] A = new int[n][m];
    sc.nextLine();
    for (int y = 0; y <= m; y++) {
      String i[] = sc.nextLine().split(" ");
      for (int x = 0; x <= n; x++) {
        A[x][y] = Integer.parseInt(i[x]);
      }
    }

    int s = 0;
    int x = s;
    int y;
    int temp = A[s][s];
    for (
        int r = 0;
        r <= rotation; r++)

    {
      for (y = s + 1; y <= m; y++) {
        //down
        A[x][y - 1] = A[x][y];
      }
      for (x = s + 1; x <= n; x++) {
        //right
        A[x - 1][y] = A[x][y];
      }
      for (y = m - 1; y >= s; y--) {
        //up
        A[x][y + 1] = A[x][y];
      }
      for (x = n - 1; x > s; x--) {
        //left
        A[x + 1][y] = A[x][y];
      }
      A[s][s] = temp;
      s += 1;
      m -= 1;
      n -= 1;
    }
  }
}
