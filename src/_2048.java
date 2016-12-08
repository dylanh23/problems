import java.util.*;

public class _2048 {
    //732
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] grid = new int[4][4];
        for (int y = 0; y < 4; y++) {
            String[] input = sc.nextLine().split(" ");
            for (int x = 0; x < 4; x++) {
                grid[x][y] = Integer.parseInt(input[x]);
            }
        }
        int direction = sc.nextInt();
        if (direction == 0) {
            for (int y = 0; y < 4; y++) {
                for (int x = 0; x < 3; x++) {
                    if (grid[x][y] != 0) {
                        outerloop:
                        while (true) {
                            for (int x2 = x + 1; x2 < 4; x2++) {
                                if (grid[x2][y] != 0) {
                                    if (grid[x2][y] == grid[x][y]) {
                                        grid[x][y] *= 2;
                                        grid[x2][y] = 0;
                                        break;
                                    } else {
                                        for (int x3 = x + 1; x3 < x2; x3++) {
                                            if (grid[x3][y] == 0) {
                                                grid[x3][y] = grid[x2][y];
                                                grid[x2][y] = 0;
                                            }
                                        }
                                        break outerloop;
                                    }
                                } else if (x2 == 3) {
                                    break outerloop;
                                }
                            }

                        }
                    }
                }
            }
        } else if (direction == 1) {

        } else if (direction == 2) {
        } else {
        }
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
               System.out.print(grid[x][y] + " ");
            }
            System.out.println();
        }
    }
}