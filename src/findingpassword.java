//import java.util.ArrayList;
//import java.util.Scanner;
//
///**
// * Created by D on 3/9/2017.
// */
//public class findingpassword {
//  static ArrayList<Integer> nums = new ArrayList<>();
//  static int K;
//
//  public static void main(String[] args) {
//    Scanner sc = new Scanner(System.in);
//    int tc = sc.nextInt();
//    sc.nextLine();
//    for (int t = 0; t < tc; t++) {
//      int n = sc.nextInt();
//      K = sc.nextInt();
//      sc.nextLine();
//      StringBuilder s = new StringBuilder("");
//      for (int i = 0; i < K; i++) {
//        s.append(9);
//      }
//      states = new int[Integer.valueOf(s.toString()) + 1];
//      for (int i = 0; i < states.length; i++) {
//        states[i] = -1;
//      }
//      for (int i = 0; i < n; i++) {
//        nums.add(sc.nextInt());
//        sc.nextLine();
//      }
//      if (answer(0) == 0) {
//        System.out.println(-1);
//      } else {
//        System.out.println(answer(0));
//      }
//      nums.clear();
//    }
//  }
//
//  static int[] states;
//
//  public static int answer(int[] m) {
//    if (String.valueOf(n).length() <= K) {
//      if (states[n] != -1) {
//        return states[n];
//      } else {
//        if (String.valueOf(n).length() == K) {
//          if (n % 9 == 0) {
//            return n;
//          } else {
//            return 0;
//          }
//        }
//        int max = 0;
//        for (Integer r : nums) {
//          max = Math.max(answer(Integer.valueOf("" + n + r)), max);
//        }
//        states[n] = max;
//        return max;
//      }
//    } else {
//      return 0;
//    }
//  }
//}
