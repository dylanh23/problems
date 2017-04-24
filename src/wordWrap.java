/**
 * Created by D on 3/14/2017.
 */
public class wordWrap {

  public static void main(String[] args) {
    int n = 4;
    length = new int[n];
    length[0] = 3;
    length[1] = 2;
    length[2] = 2;
    length[3] = 5;

    answer(n - 1, -1);
  }


  static int[] length;

  //min amount of spaces to the power of 3 for each line for words from 0 to j
  public static int answer(int j, int m) {
    int min = Integer.MAX_VALUE;
    if (j == 0) {
      if (length[j] < m) {
        min = m - length[j];
      }
    } else {
      for (int i = 0; i < j; i++) {
        int c = cost(i + 1, j);
        if (c <= m) {
          min = Math.min(answer(i, m) + (int) Math.pow(m - c, 3), min);
        } else if (m == -1) {
          min = Math.min(answer(i, c), min);
        }
      }
    }
    return min;
  }

  //min amount of spaces to the power of 3 for each line for words from 0 to j
//  public static int answer(int j) {
//    int min = Integer.MAX_VALUE;
//    for (int i = 0; i < j; i++) {
//      int c = cost(i + 1, j);
//        min = Math.min(answer(i) + (int) Math.pow(m - c, 3), min);
//    }
//  }

  private static int cost(int k, int j) {
    int t = 0;
    for (int i = k; i <= j; i++) {
      t += length[i] + 1;
    }
    if (t > 0) {
      t--;
    }
    return t;
  }
}
