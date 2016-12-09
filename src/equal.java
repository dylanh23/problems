import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by D on 12/8/2016.
 */
public class equal {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tc = Integer.parseInt(sc.nextLine());
    for (int i = 0; i < tc; tc++) {
      int s = Integer.parseInt(sc.nextLine());
      String[] v = sc.nextLine().split(" ");
      o = new int[s];
      for (int k = 0; k < s; k++) {
        o[k] = Integer.parseInt(v[k]);
      }
      Arrays.sort(o);
      int mv = o[s - 1];
      while (true) {
        states = new HashMap<>();
        min = Integer.MAX_VALUE;
        int[] d = new int[s];
        for (int e = 0; e < s; e++) {
          d[e] = mv;
        }
        int t = takeAway(d, 0);
        if (t < Integer.MAX_VALUE) {
          System.out.print(t);
          break;
        }
        mv++;
//        if (mv - o[0] / 5 > min) {
//          break;
//        }
      }
//      System.out.print(min);
    }
  }

  static int[] o;
  static int min;

  static HashMap<Integer, ArrayList<state>> states;

  public static class state {
    int v;
    int[] d;

    state(int v, int[] d) {
      this.v = v;
      this.d = d;
    }
  }

  static int getState(int[] d, int s) {
    if (states.get(s) == null) {
      return -1;
    } else {
      ArrayList<state> ls = states.get(s);
      for (state l : ls) {
        if (l.d == d) {
          return l.v;
        }
      }
      return -1;
    }
  }

  static void saveState(int[] d, int s, int v) {
    state l = new state(v, d);
    if (states.get(s) == null) {
      ArrayList<state> ls = new ArrayList<>();
      ls.add(l);
      states.put(s, ls);
    } else {
      states.get(s).add(l);
    }
  }

  static int takeAway(int[] d, int s) {
    if (lessThen(d)) {
      return Integer.MAX_VALUE;
    } else if (same(d)) {
      return s;
    } else {
      int smallest = Integer.MAX_VALUE;
      s += 1;
      if (s > min) {
        return s;
      }
      for (int i = 0; i < d.length; i++) {
        int one = getState(remove(d, 1, i), s);
        if (one == -1) {
          one = takeAway(remove(d, 1, i), s);
          saveState(remove(d, 1, i), s, one);
        }
        int two = getState(remove(d, 2, i), s);
        if (two == -1) {
          two = takeAway(remove(d, 2, i), s);
          saveState(remove(d, 2, i), s, two);
        }
        int five = getState(remove(d, 5, i), s);
        if (five == -1) {
          five = takeAway(remove(d, 5, i), s);
          saveState(remove(d, 5, i), s, five);
        }
        int value = (one < two) ? one : two;
        value = (value < five) ? value : five;
        if (value < smallest) {
          smallest = value;
        }
      }
      return smallest;
    }
  }

  private static boolean lessThen(int[] d) {
    for (int i = 0; i < d.length; i++) {
      if (d[i] < o[i]) {
        return true;
      }
    }
    return false;
  }

  static boolean same(int[] d) {
    for (int i = 0; i < d.length; i++) {
      if (d[i] != o[i]) {
        return false;
      }
    }
    return true;
  }

  static int[] remove(int[] d, int a, int i) {
    int[] tempD = d.clone();
    for (int j = 0; j < tempD.length; j++) {
      if (j != i) {
        tempD[j] -= a;
      }
    }
    Arrays.sort(tempD);
    return tempD;
  }
}