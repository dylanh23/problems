import java.util.Scanner;

/**
 * Created by D on 1/9/2017.
 */
public class m {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tc = Integer.parseInt(sc.nextLine());
    for (int i = 0; i < tc; i++) {
      int size = Integer.parseInt(sc.nextLine());
      int[] arrayInt = new int[size];
      String input[] = sc.nextLine().split(" ");
      for (int j = 0; j < size; j++) {
        arrayInt[j] = Integer.parseInt(input[j]);
      }
      boolean chaotic = false;
      for (int j = 0; j < size; j++) {
        if (Math.abs(arrayInt[j] - (j + 1)) > 2) {
          System.out.println("Too chaotic");
          chaotic = true;
          break;
        }
      }
      if (!chaotic) {
        int swapCounter = 0;
        boolean done = false;
        while (!done) {
          done = true;
          for (int j = 0; j < size; j++) {
            if (arrayInt[j] != j + 1) {
              if (Math.abs(arrayInt[j] - (j + 2)) < Math.abs(arrayInt[j] - (j + 1))
                  && Math.abs(arrayInt[j + 1] - (j + 1)) < Math.abs(arrayInt[j + 1] - (j + 2))) {
                int temp = arrayInt[j];
                arrayInt[j] = arrayInt[j + 1];
                arrayInt[j + 1] = temp;
                done = false;
                swapCounter += 1;
                break;
              }
            }
          }

          if (done) {
            for (int j = 0; j < size; j++) {
              if (arrayInt[j] != j + 1) {
                if (arrayInt[j] == j + 3 && arrayInt[j + 2] == j + 1 && arrayInt[j + 1] == j + 2) {
                  arrayInt[j + 2] = j + 3;
                  arrayInt[j] = j + 1;
                  swapCounter += 3;
                  break;
                } else if (arrayInt[j] == j + 3 && arrayInt[j + 2] == j + 1 && arrayInt[j + 1] == j + 4 && arrayInt[j + 3] == j + 2) {
                  arrayInt[j] = j + 1;
                  arrayInt[j + 1] = j + 2;
                  arrayInt[j + 2] = j + 3;
                  arrayInt[j + 3] = j + 4;
                  swapCounter += 4;
                  done = false;
                  break;
                }
              }
            }
          }
        }
        System.out.println(swapCounter);
      }
    }
  }
}
