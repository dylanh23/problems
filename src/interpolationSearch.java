import java.util.Scanner;

/**
 * Created by D on 4/24/2017.
 */
public class interpolationSearch {
  static int[] arr = {10, 12, 13, 16, 18, 19, 20, 21, 22, 23,
      24, 33, 35, 42, 47};

  public static void main(String[] args) {
    System.out.println(search(18));
  }

  static int search(int x) {
    int lo = 0;
    int hi = arr.length - 1;
    while (lo <= hi && x >= arr[lo] && x <= arr[hi]) {
      int pos = (int) (lo + (((double) (hi - lo) / (arr[hi] - arr[lo])) * (x - arr[lo])));
      if (arr[pos] == x) {
        return pos;
      } else if (arr[pos] > x) {
        hi = pos - 1;
      } else {
        lo = pos + 1;
      }
    }
    return -1;
  }
}
