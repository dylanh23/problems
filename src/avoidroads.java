import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class avoidroads {
    static ArrayList<line> badRoads = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sizeJ = Integer.parseInt(sc.nextLine());
        int sizeV = Integer.parseInt(sc.nextLine());
        String input = sc.nextLine();
        input = input.replaceAll("[^\\d.]", "");
        for (int i = 0; i < input.length(); i += 4) {
            badRoads.add(new line(Integer.valueOf(input.substring(i, i + 1)), Integer.valueOf(input.substring(i + 1, i + 2)), Integer.valueOf(input.substring(i + 2, i + 3)), Integer.valueOf(input.substring(i + 3, i + 4))));
        }
        long[][] possiblePaths = new long[sizeJ + 1][sizeV + 1];
        for (int j = 0; j <= sizeJ; j++)
            for (int v = 0; v <= sizeV; v++) {
                long previousTotalAmount = 0;
                if (v != 0 && notBadRoad(new line(j, v, j, v - 1), badRoads)) {
                    previousTotalAmount += possiblePaths[j][v - 1];
                }
                if (j != 0 && notBadRoad(new line(j, v, j - 1, v), badRoads)) {
                    previousTotalAmount += possiblePaths[j - 1][v];
                }
                if (j == 0 && v == 0) {
                    previousTotalAmount = 1;
                }
                possiblePaths[j][v] = previousTotalAmount;
            }
        System.out.print(possiblePaths[sizeJ][sizeV]);
    }

    private static boolean notBadRoad(line line, ArrayList<line> badRoads) {
        for (line l : badRoads) {
            if (l.smaller.x == line.smaller.x && l.smaller.y == line.smaller.y && l.bigger.x == line.bigger.x && l.bigger.y == line.bigger.y) {
                return false;
            }
        }
        return true;
    }

    public static class line {
        Point smaller;
        Point bigger;

        line(int x, int y, int x2, int y2) {
            if (x > x2 || y > y2) {
                smaller = new Point(x2, y2);
                bigger = new Point(x, y);
            } else {
                smaller = new Point(x, y);
                bigger = new Point(x2, y2);
            }
        }
    }
}
