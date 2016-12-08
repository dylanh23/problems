import java.awt.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class knight2ndsolution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt(sc.nextLine());
        String[] start = sc.nextLine().replaceAll("[^\\d.]", "").split("");
        String[] end = sc.nextLine().replaceAll("[^\\d.]", "").split("");
        Point startingP = new Point(Integer.parseInt(start[0]), Integer.parseInt(start[1]));
        Point endingP = new Point(Integer.parseInt(end[0]), Integer.parseInt(end[1]));
        int amountOfMoves = Integer.parseInt(sc.nextLine());
        long[][][] spots = new long[size][size][amountOfMoves + 1];
        for (int n = 0; n <= amountOfMoves; n++)
            for (int i = 0; i < size; i++)
                for (int j = 0; j < size; j++) {
                    if (n == 0) {
                        if (i == endingP.x && j == endingP.y) {
                            spots[i][j][n] = 1;
                        } else {
                            spots[i][j][n] = 0;
                        }
                    } else {
                        spots[i][j][n] = getSumOfSuroundingCombinations(spots, n - 1, i, j, size);
                    }
                }
        System.out.print(spots[startingP.x][startingP.y][amountOfMoves]);
    }

    private static long getSumOfSuroundingCombinations(long[][][] spots, int n, int oi, int oj, int size) {
        long possibleCombinations = 0;

        for (int i = oi - 1; i <= oi + 1; i++)
            for (int j = oj - 1; j <= oj + 1; j++)
                if (j >= 0 && j < size && i >= 0 && i < size && !(j == oj && i == oi))
                    possibleCombinations += spots[i][j][n];
        int j = oj - 2;
        int i = oi - 1;
        if (j >= 0 && j < size && i >= 0 && i < size)
            possibleCombinations += spots[i][j][n];
        j = oj + 2;
        i = oi - 1;
        if (j >= 0 && j < size && i >= 0 && i < size)
            possibleCombinations += spots[i][j][n];

        j = oj - 2;
        i = oi + 1;
        if (j >= 0 && j < size && i >= 0 && i < size)
            possibleCombinations += spots[i][j][n];

        j = oj + 2;
        i = oi + 1;
        if (j >= 0 && j < size && i >= 0 && i < size)
            possibleCombinations += spots[i][j][n];

        j = oj - 1;
        i = oi - 2;
        if (j >= 0 && j < size && i >= 0 && i < size)
            possibleCombinations += spots[i][j][n];

        j = oj + 1;
        i = oi - 2;
        if (j >= 0 && j < size && i >= 0 && i < size)
            possibleCombinations += spots[i][j][n];

        j = oj - 1;
        i = oi + 2;
        if (j >= 0 && j < size && i >= 0 && i < size)
            possibleCombinations += spots[i][j][n];

        j = oj + 1;
        i = oi + 2;
        if (j >= 0 && j < size && i >= 0 && i < size)
            possibleCombinations += spots[i][j][n];
        return possibleCombinations;
    }
}
