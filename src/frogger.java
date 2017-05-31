import java.awt.*;
import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by dhare on 5/30/2017.
 */

public class frogger {
    static double[][] edges;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            points[i] = new Point(x, y);
            sc.nextLine();
        }
        edges = new double[n][n];
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
                if (j == k) {
                    edges[j][k] = 0;
                } else {
                    edges[j][k] = Math.sqrt(Math.pow(Math.abs(points[j].x - points[k].x), 2) + Math.pow(Math.abs(points[j].y - points[k].y), 2));
                }
            }
        }
        double[] distance = new double[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = Integer.MAX_VALUE -1;
        while (true) {
            boolean nonLeft = true;
            double min = Integer.MAX_VALUE;
            int minNode = -1;
            for (int i = 0; i < n; i++) {
                if (!visited[i] && distance[i] < min) {
                    min = distance[i];
                    minNode = i;
                    nonLeft = false;
                }
            }
            if (nonLeft) {
                break;
            }
            visited[minNode] = true;
            for (int i = 0; i < n; i++) {
                if (minNode != i) {
                    if (distance[i] > edges[minNode][i]) {
                        distance[i] = edges[minNode][i];
                    }
                }
            }
        }
//        while (true) {
//            boolean nonLeft = true;
//            double min = Integer.MAX_VALUE;
//            int minNode = -1;
//            for (int i = 0; i < n; i++) {
//                if (!visited[i] && distance[i] < min) {
//                    min = distance[i];
//                    minNode = i;
//                    nonLeft = false;
//                }
//            }
//            if (nonLeft) {
//                break;
//            }
//            visited[minNode] = true;
//            for (int i = 0; i < n; i++) {
//                if (distance[i] > edges[minNode][i] + distance[minNode]) {
//                    distance[i] = edges[minNode][i] + distance[minNode];
//                }
//            }
//        }
        return;
    }
}
