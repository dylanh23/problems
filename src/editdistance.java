import java.util.Scanner;

/**
 * Created by D on 3/10/2017.
 */
public class editdistance {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tc = sc.nextInt();
    sc.nextLine();
    for (int i = 0; i < tc; i++) {
      first = new StringBuilder(sc.next());
      sc.nextLine();
      second = new StringBuilder(sc.next());
      sc.nextLine();
      states = new int[first.length()][second.length()];
      for (int j = 0; j < first.length(); j++) {
        for (int k = 0; k < second.length(); k++) {
          states[j][k] = -1;
        }
      }
      System.out.println(answer(first.length() - 1, second.length() - 1));
    }
//    System.out.println(answer(0, 0, -1));
  }

  static StringBuilder first;
  static StringBuilder second;
  static int[][] states;

  public static int answer(int j, int k) {
    if (j == -1 && k == -1) {
      return 0;
    } else if (j == -1) {
      return k + 1;
    } else if (k == -1) {
      return j + 1;
    } else if (states[j][k] != -1) {
      return states[j][k];
    } else {
      int m;
      if (first.charAt(j) == second.charAt(k)) {
        m = answer(j - 1, k - 1);
      } else {
        int delete, insert, replace;
        delete = answer(j, k - 1) + 1;
        insert = answer(j - 1, k) + 1;
        replace = answer(j - 1, k - 1) + 1;
        m = Math.min(delete, Math.min(insert, replace));
      }
      states[j][k] = m;
      return m;
    }
  }

}

//  public static int answer2(int j, int k) {
//    if (first.charAt(j) == second.charAt(k)) {
//      answer(j + 1, k + 1);
//    }
//
//    int m = Math.min(answer(j + 1, k), Math.min(answer(j + 1, k + 1), answer(j, k + 1)));
//    return m;
//  }

