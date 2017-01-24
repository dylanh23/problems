import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by D on 1/22/2017.
 */
public class cowdance {
  static int n;
  static int tmax;
  private static Queue<Integer> inital;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    tmax = sc.nextInt();
    sc.nextLine();
    inital = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      inital.add(sc.nextInt());
      sc.nextLine();
    }
    System.out.print(binarySearch());
  }


  public static int binarySearch() {
    int k = n;
    int low = 1;
    int high = n;

    while (high >= low) {
      int middle = (low + high) / 2;
      int v = check(middle);
      if (v <= tmax) {
        high = middle - 1;
        k = middle;
      }
      if (v > tmax) {
        low = middle + 1;
      }
    }
    return k;
  }

  private static int check(int i) {
    int[] stage = new int[i];
    Queue<Integer> q = new LinkedList<>();
    q.addAll(inital);

    int t = 0;
    boolean done = false;
    while (!done) {
      done = true;
      int smallest = Integer.MAX_VALUE;
      for (int j = 0; j < i; j++) {
        if (stage[j] < smallest && stage[j] != -1) {
          smallest = stage[j];
        }
      }
      t += smallest;
      for (int j = 0; j < i; j++) {
        if (stage[j] != -1) {
          if (stage[j] == smallest) {
            if (!q.isEmpty()) {
              stage[j] = q.remove();
              done = false;
            } else {
              stage[j] = -1;
            }
          } else {
            stage[j] -= smallest;
            done = false;
          }
        }
      }
    }
    return t - 1;
  }

}
