import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by D on 4/5/2017.
 */
public class stack {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.nextLine();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = sc.nextInt();
    }
    int c = n;
    PriorityQueue<Integer> sortedList = new PriorityQueue<>(10, Collections.reverseOrder());
    for (int i = 0; i < n; i++) {
      if (a[i] == c) {
        System.out.print(c + " ");
        c--;
        while (!sortedList.isEmpty() && sortedList.peek() == c) {
          sortedList.remove();
          System.out.print(c + " ");
          c--;
        }
        System.out.println();
      } else {
        sortedList.add(a[i]);
        System.out.println();
      }
    }
  }
}
