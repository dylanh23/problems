import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by D on 2/28/2017.
 */
public class ACMAKER {
  static char[] input;
  static char[] ac;
  static ArrayList<String> words = new ArrayList<>();

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    while (n != 0) {
      sc.nextLine();
      for (int i = 0; i < n; i++) {
        words.add(sc.nextLine());
      }
      while (true) {
        StringBuilder w = new StringBuilder(sc.nextLine());
        if (w.toString().equals("LAST CASE")) {
          break;
        }
        int i = 0;
        while (w.charAt(i) != ' ') {
          i++;
        }
        ac = new char[i];
        for (int f = 0; f < i; f++) {
          ac[f] = Character.toLowerCase(w.charAt(f));
        }
        input = new char[w.length() - i];
        int j = 0;
        for (int f = i; f < w.length(); f++, j++) {
          input[j] = w.charAt(f);
        }
        int a = dp(0, 0, 1);
        if (a == 0) {
          System.out.println(new String(ac).toUpperCase() + " is not a valid abbreviation");
        } else {
          System.out.println(new String(ac).toUpperCase() + " can be formed in " + a + " ways");
        }
      }
      n = sc.nextInt();
    }
  }

  //a is acronym index
  //j is phrase index
  //b is 1 for letter found already, 0 for still need letter in word
  static int dp(int a, int j, int b) {
    if (ac.length == a) {
      int i = j;
      if (j == input.length) {
        return 1;
      }
      while (input[i] != ' ') {
        i++;
        if (i == input.length) {
          return 1;
        }
      }
      return 0;
    } else if (j == input.length) {
      return 0;
    }
    if (input[j] == ' ') {
      if (b == 1) {
        int i = j + 1;
        j += 1;
        StringBuilder sb = new StringBuilder();
        while (i != input.length && input[i] != ' ') {
          sb.append(input[i]);
          i++;
        }
        if (words.contains(sb.toString())) {
          return dp(a, i + 1, 0);
        }
      } else {
        return 0;
      }
    }
    if (input[j] == ac[a]) {
      int d1 = dp(a + 1, j + 1, 1);
      int d2 = dp(a, j + 1, b);
      return d1 + d2;
    } else {
      return dp(a, j + 1, b);
    }
  }
}
