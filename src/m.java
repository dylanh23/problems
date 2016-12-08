import com.sun.deploy.util.ArrayUtil;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by D on 12/7/2016.
 */
public class m {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String input = sc.nextLine();
    int sum = Integer.parseInt(input.split(" ")[0]);
    int size = Integer.parseInt(input.split(" ")[1]);
    denominations = new int[size];
    String[] d = sc.nextLine().split(" ");
    for (int i = 0; i < size; i++) {
      denominations[i] = Integer.parseInt(d[i]);
    }
    stages = new HashMap<>();
    ArrayList<stage> s = new ArrayList<>();
//    s.add();
//    stages.put(0, s);
//    stage[0] = new stage(0, null);
//    for (int i = 1; i <= sum; i++) {
//      int j = 0;
//      for (int k = 0; k < size; k++) {
//        if (i - denominations[k] >= 0) {
//          j += n[i - denominations[k]];
//        }
//      }
//      n[i] = j;
//    }
//    System.out.print(n[sum]);

//    for (int i = 0; i < size; i++)
//    {
//      for (int j = i + 1; j < size; j++)
//      {
//        if (denominations[i] < denominations[j])
//        {
//          int temp = denominations[i];
//          denominations[i] = denominations[j];
//          denominations[j] = temp;
//        }
//      }
//    }
    Arrays.sort(denominations);
    System.out.print(combinations(sum, denominations));
  }

  static HashMap<Integer, ArrayList<stage>> stages;
  static int[] denominations;

  public static int combinations(int j, int[] denoms) {
    if (stages.get(j) != null) {
      ArrayList<stage> s = stages.get(j);
      for (stage l : s) {
        if (l.denoms == denoms) {
          return l.comb;
        }
      }
    }

    int i = 0;
    int denom;
    int[] newDenoms;
    int combo = 0;
    if (denoms.length > 1) {
      denom = denoms[denoms.length - 1];
      newDenoms = new int[denoms.length - 1];
      for (int k = denoms.length - 2; k >= 0; k--) {
        newDenoms[k] = denoms[k];
      }
      while (j - denom * i >= 0) {
        int result = combinations(j - denom * i, newDenoms);
        combo += result;
        stage p = new stage(result, newDenoms);
        if (stages.get(j - denom * i) != null) {
          stages.get(j - denom * i).add(p);
        } else {
          ArrayList<stage> s = new ArrayList<>();
          s.add(p);
          stages.put(j - denom * i, s);
        }
        i += 1;
      }
    } else {
      if (j % denoms[0] == 0) {
        combo = 1;
      }
    }
    return combo;
  }

  public static class stage {
    int comb;
    int[] denoms;

    stage(int comb, int[] denoms) {
      this.comb = comb;
      this.denoms = denoms;
    }
  }
}