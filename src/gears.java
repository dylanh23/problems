/**
 * Created by D on 4/4/2017.
 */
public class gears {
  static int[] a = {10, 80, 120, 140, 165};

  public static void main(String[] args) {
    int i = a.length - 1;
    int t = a[i];
    int n = -1;
    while (i > 1) {
      i--;
      t += a[i] * n;
      t += a[i] * n;
      n *= -1;
    }
    i--;
    t += a[i] * n;
    n *= -1;
    t *= n;
    t *= 2;
    System.out.println(t);
  }
}
