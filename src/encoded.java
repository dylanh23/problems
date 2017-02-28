import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by D on 2/7/2017.
 */
public class encoded {
  static int n;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tc = sc.nextInt();
    sc.nextLine();
    for (int l = 0; l < tc; l++) {
      StringBuilder sb = new StringBuilder(sc.nextLine());
      n = (int) Math.sqrt(sb.length());
      char[][] input = new char[n][n];
      int c = 0;
      for (int y = 0; y < n; y++) {
        for (int x = 0; x < n; x++) {
          input[x][y] = sb.charAt(c);
          c++;
        }
      }
      StringBuilder answer = new StringBuilder();
      for (int x = n - 1; x >= 0; x--) {
        for (int y = 0; y < n; y++) {
          answer.append(input[x][y]);
        }
      }
      System.out.println(answer);
    }
  }
}
