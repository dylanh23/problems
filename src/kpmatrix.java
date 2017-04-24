import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Created by D on 3/9/2017.
 */
public class kpmatrix {

  static int A, B;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Y = sc.nextInt();
    X = sc.nextInt();
    sc.nextLine();
    matrix = new int[X][Y];
    for (int y = 0; y < Y; y++) {
      for (int x = 0; x < X; x++) {
        matrix[x][y] = sc.nextInt();
      }
      sc.nextLine();
    }
    A = sc.nextInt();
    B = sc.nextInt();
    int count = 0;
    for (int x = 0; x < X; x++) {
      for (int y = 0; y < Y; y++) {
        int m = matrix[x][y];
        for (int j = x; j < X; j++) {
          if (j != x)
            m += matrix[j][y];
          for (int k = y; k < Y; k++) {
            if (y != 0)
              m += matrix[j][y];
            System.out.println(m);
            count++;
          }
        }
      }
    }
    System.out.println(count);
//    System.out.println(answer(0, 0, -1));
  }

  static int[][] matrix;
  static int X, Y;

  public static int answer(int x, int y, int t, int d) {
    int a = 0;
    if (x == X || y == Y) {
      return 0;
    }
    if (t == -1) {
      if (d == 1 || d == -1) {
        a += answer(x, y + 1, -1, 1);
      }
      if (d == 0 || d == -1) {
        a += answer(x + 1, y, -1, 0);
      }
      if (d == -1) {
        a += answer(x, y + 1, -1, -1);
      }
      t = 0;
    }
    t += matrix[x][y];
//    a += answer(x + 1, y, t);
//    a += answer(x, y + 1, t);
//    a += answer(x + 1, y + 1, t);
    if (t >= A && t <= B) {
      a++;
    }
    return a;
  }
}
