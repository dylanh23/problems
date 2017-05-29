import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by D on 5/15/2017.
 */
public class topoSorting {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.nextLine();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = sc.nextInt();
    }
    sc.nextLine();
    int j = sc.nextInt();
    sc.nextLine();
    boolean[][] edges = new boolean[n][n];
    for (int i = 0; i < j; i++) {
      int f = sc.nextInt() - 1;
      int s = sc.nextInt() - 1;
      edges[f][s] = true;
    }
    ArrayList<Integer> used = new ArrayList<>();
    int counter = 0;
    int max = Integer.MIN_VALUE;
    while (used.size() < n) {
      int lowestVal = Integer.MAX_VALUE;
      int next = -1;
      for (int i = 0; i < n; i++) {
        if (!used.contains(i)) {
          boolean zeroNDegree = true;
          for (int z = 0; z < n; z++) {
            if (edges[z][i]) {
              zeroNDegree = false;
              break;
            }
          }
          if (zeroNDegree) {
            if (a[i] < lowestVal) {
              lowestVal = a[i];
              next = i;
            }
          }
        }
      }
      counter++;
      if (counter - a[next] > max && counter - a[next] > 0) {
        max = counter - a[next];
      }
      used.add(next);
      for (int z = 0; z < n; z++) {
        edges[next][z] = false;
      }
    }
    System.out.println();
  }

}
