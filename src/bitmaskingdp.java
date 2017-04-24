import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by D on 3/7/2017.
 */
public class bitmaskingdp {
  static ArrayList<Integer>[] hats;
  static int N;
  static int H;

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    sc.nextLine();
    int count = 0;
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    hats = new ArrayList[N];
    for (int i = 0; i < N; i++) {
      hats[i] = new ArrayList<>();
      String[] input = sc.nextLine().split(" ");
      for (int i1 = 0; i1 < input.length; i1++) {
        int n = Integer.valueOf(input[i1]);
        if (hashMap.get(n) == null) {
          hashMap.put(n, count);
          hats[i].add(count);
          count++;
        } else {
          hats[i].add(hashMap.get(n));
        }
      }
    }
    H = hashMap.size();
    System.out.println(answer(0, 0));

  }

  public static int answer(int bm, int h) {
    int a = 0;
    boolean allUsed = true;
    for (int i = 0; i < hats.length; i++) {
      if ((bm & (1 << i)) == 0) {
        allUsed = false;
        if (h < H) {
          for (int n : hats[i]) {
            if (n == h) {
              a += answer((bm | (1 << i)), h + 1);
              break;
            }
          }
        }
      }
    }
    if (h < H) {
      a += answer(bm, h + 1);
    }
    if (allUsed) {
      return 1;
    }
    return a;
  }
}
