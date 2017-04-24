import java.util.Scanner;

/**
 * Created by D on 3/8/2017.
 */
public class baby {

  static int[][] matrix;
  static int N;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    sc.nextLine();
    states = new int[(int) Math.pow(2, (16 + 1))];
    while (N != 0) {
      matrix = new int[N][N];
      int[] first = new int[N];
      for (int i = 0; i < N; i++) {
        first[i] = sc.nextInt();
      }
      sc.nextLine();
      int[] second = new int[N];
      for (int i = 0; i < N; i++) {
        second[i] = sc.nextInt();
      }
      for (int i = 0; i < N; i++) {
        for (int k = 0; k < N; k++) {
          matrix[i][k] = Math.abs(first[i] - second[k]) + Math.abs(i - k);
        }
      }
      for (int i = 0; i < (int) Math.pow(2, (16 + 1)); i++) {
        states[i] = -1;
      }
      System.out.println(answer(0));
      sc.nextLine();
      N = sc.nextInt();
    }
  }

  static int[] states;

//  public static int[] answer(int bm, int n) {
//    int min[] = new int[N + 1];
//    if (n == N) {
//      return min;
//    }
//    min[0] = Integer.MAX_VALUE;
//    for (int i = 0; i < N; i++) {
//      if ((bm & (1 << i)) == 0) {
//        if (answer((bm | (1 << i)), n + 1)[0] + matrix[n][i] < min[0]) {
//          min = answer((bm | (1 << i)), n + 1);
//          min[0] += matrix[n][i];
//          min[n + 1] = matrix[n][i];
//        }
//      }
//    }
//    return min;
//  }

  public static int answer(int bm) {
    int min = 0;
    int n = NumberOfSetBits(bm);
    if (n == N) {
      return min;
    }
    if (states[bm] != -1) {
      return states[bm];
    } else {
      min = Integer.MAX_VALUE;
      for (int i = 0; i < N; i++) {
        if ((bm & (1 << i)) == 0) {
          if (answer((bm | (1 << i))) + matrix[n][i] < min) {
            min = answer((bm | (1 << i))) + matrix[n][i];
          }
        }
      }
      states[bm] = min;
      return min;
    }
  }

  static int NumberOfSetBits(int i) {
    i = i - ((i >> 1) & 0x55555555);
    i = (i & 0x33333333) + ((i >> 2) & 0x33333333);
    return (((i + (i >> 4)) & 0x0F0F0F0F) * 0x01010101) >> 24;
  }
}

