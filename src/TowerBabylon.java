import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by D on 3/9/2017.
 */
public class TowerBabylon {
  static class Block {
    int x, y, z;

    Block(int x, int y, int z) {
      this.x = x;
      this.y = y;
      this.z = z;
    }
  }

  static ArrayList<Block> blocks = new ArrayList<>();

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    while (n != 0) {
      sc.nextLine();
      int max = 0;
      for (int i = 0; i < n; i++) {
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        sc.nextLine();
        blocks.add(new Block(x, y, z));
        blocks.add(new Block(z, x, y));
        blocks.add(new Block(y, z, x));
        max = Math.max(Math.max(Math.max(x, y), z), max);
      }
      states = new int[max + 2][max + 2];
      for (int j = 0; j <= max + 1; j++) {
        for (int k = 0; k <= max + 1; k++) {
          states[j][k] = -1;
        }
      }
      System.out.println(answer(max + 1, max + 1));
      blocks.clear();
      n = sc.nextInt();
    }
  }

  static int[][] states;

  static int answer(int x, int z) {
    if (states[x][z] != -1) {
      return states[x][z];
    } else {
      int a = 0;
      for (Block b : blocks) {
        if ((b.x < x && b.z < z) || (b.z < x && b.x < z)) {
          if (answer(b.x, b.z) + b.y > a) {
            a = answer(b.x, b.z) + b.y;
          }
        }
      }
      states[x][z] = a;
      return a;
    }
  }
}
