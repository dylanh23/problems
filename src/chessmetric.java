import java.awt.*;
import java.lang.reflect.Array;
import java.util.*;

public class chessmetric {
    //    static ArrayList<int[][]> possibleWaysOfReaching = new ArrayList<>();
    static int size;
    static Point endingP;
    static int amountOfMoves;
    static int totalMoves;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        size = Integer.parseInt(sc.nextLine());
        String[] start = sc.nextLine().replaceAll("[^\\d.]", "").split("");
        String[] end = sc.nextLine().replaceAll("[^\\d.]", "").split("");
        Point startingP = new Point(Integer.parseInt(start[0]), Integer.parseInt(start[1]));
        endingP = new Point(Integer.parseInt(end[0]), Integer.parseInt(end[1]));
        amountOfMoves = Integer.parseInt(sc.nextLine());
        allMoves(0, startingP);
        System.out.print(totalMoves);
    }

    static void allMoves(int moveCount, Point point) {
        //square
        moveCount += 1;
        for (int y = point.y - 1; y <= point.y + 1; y++)
            for (int x = point.x - 1; x <= point.x + 1; x++)
                if (x >= 0 && x < size && y >= 0 && y < size && !(x == point.x && y == point.y))
                    if (endingP.x == x && endingP.y == y && moveCount == amountOfMoves) {
                        totalMoves += 1;
                    } else if (moveCount < amountOfMoves) {
                        allMoves(moveCount, new Point(x, y));
                    }
        int x = point.x - 2;
        int y = point.y - 1;
        if (x >= 0 && x < size && y >= 0 && y < size)
            if (endingP.x == x && endingP.y == y && moveCount == amountOfMoves) {
                totalMoves += 1;
            } else if (moveCount < amountOfMoves) {
                allMoves(moveCount, new Point(x, y));
            }
        x = point.x + 2;
        y = point.y - 1;
        if (x >= 0 && x < size && y >= 0 && y < size)
            if (endingP.x == x && endingP.y == y && moveCount == amountOfMoves) {
                totalMoves += 1;
            } else if (moveCount < amountOfMoves) {
                allMoves(moveCount, new Point(x, y));
            }
        x = point.x - 2;
        y = point.y + 1;
        if (x >= 0 && x < size && y >= 0 && y < size)
            if (endingP.x == x && endingP.y == y && moveCount == amountOfMoves) {
                totalMoves += 1;
            } else if (moveCount < amountOfMoves) {
                allMoves(moveCount, new Point(x, y));
            }
        x = point.x + 2;
        y = point.y + 1;
        if (x >= 0 && x < size && y >= 0 && y < size)
            if (endingP.x == x && endingP.y == y && moveCount == amountOfMoves) {
                totalMoves += 1;
            } else if (moveCount < amountOfMoves) {
                allMoves(moveCount, new Point(x, y));
            }
        x = point.x - 1;
        y = point.y - 2;
        if (x >= 0 && x < size && y >= 0 && y < size)
            if (endingP.x == x && endingP.y == y && moveCount == amountOfMoves) {
                totalMoves += 1;
            } else if (moveCount < amountOfMoves) {
                allMoves(moveCount, new Point(x, y));
            }
        x = point.x + 1;
        y = point.y - 2;
        if (x >= 0 && x < size && y >= 0 && y < size)
            if (endingP.x == x && endingP.y == y && moveCount == amountOfMoves) {
                totalMoves += 1;
            } else if (moveCount < amountOfMoves) {
                allMoves(moveCount, new Point(x, y));
            }
        x = point.x - 1;
        y = point.y + 2;
        if (x >= 0 && x < size && y >= 0 && y < size)
            if (endingP.x == x && endingP.y == y && moveCount == amountOfMoves) {
                totalMoves += 1;
            } else if (moveCount < amountOfMoves) {
                allMoves(moveCount, new Point(x, y));
            }
        x = point.x + 1;
        y = point.y + 2;
        if (x >= 0 && x < size && y >= 0 && y < size)
            if (endingP.x == x && endingP.y == y && moveCount == amountOfMoves) {
                totalMoves += 1;
            } else if (moveCount < amountOfMoves) {
                allMoves(moveCount, new Point(x, y));
            }
    }
}
