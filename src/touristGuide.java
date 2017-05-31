import java.awt.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by dhare on 5/30/2017.
 */

public class touristGuide {
    static int[][] edges;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        edges = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(edges[i], 0);
        }
        for (int i = 0; i < r; i++) {
            int city1 = sc.nextInt() - 1;
            int city2 = sc.nextInt() - 1;
            edges[city1][city2] = sc.nextInt();
            sc.nextLine();
        }
        int S = sc.nextInt() - 1;
        int D = sc.nextInt() - 1;
        int T = sc.nextInt() - 1;

        double[] distance = new double[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(distance, Integer.MIN_VALUE);
        distance[S] = 0;
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                distance[i] = edges[0][i];
            }
        }
        while (true) {
            boolean nonLeft = true;
            double max = Integer.MIN_VALUE;
            int maxNode = -1;
            for (int i = 0; i < n; i++) {
                if (!visited[i] && distance[i] > max) {
                    max = distance[i];
                    maxNode = i;
                    nonLeft = false;
                }
            }
            if (nonLeft) {
                break;
            }
            visited[maxNode] = true;
            for (int i = 0; i < n; i++) {
                if (maxNode != i) {
                    if (Math.min(distance[maxNode], edges[maxNode][i]) > distance[i]) {
                        distance[i] = Math.min(distance[maxNode], edges[maxNode][i]);
                    }
                }
            }
        }

//        int[] distance = new int[n];
//        boolean[] visited = new boolean[n];
//        Arrays.fill(distance, Integer.MIN_VALUE);
//        distance[S] = 0;
//        while (true) {
//            boolean noneLeft = true;
//            int max = Integer.MIN_VALUE;
//            int maxNode = -1;
//            for (int i = 0; i < n; i++) {
//                if (!visited[i] && distance[i] > max) {
//                    max = distance[i];
//                    maxNode = i;
//                    noneLeft = false;
//                }
//            }
//            if (noneLeft) {
//                break;
//            }
//            visited[maxNode] = true;
//            for (int i = 0; i < n; i++) {
//                if (maxNode != i) {
//                    if (distance[i] < distance[maxNode] + edges[maxNode][i]) {
//                        distance[i] = distance[maxNode] + edges[maxNode][i];
//                    }
//                }
//            }
//        }
//        int a = maxFlow(edges, S, D);
//        System.out.println(Math.ceil((long) T / a));
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
        System.out.println(Math.ceil((long) T / distance[D]));
        return;
    }

    public static int maxFlow(int[][] cap, int s, int t) {
        for (int flow = 0; ; ) {
            int df = findPath(cap, new boolean[cap.length], s, t, Integer.MAX_VALUE);
            if (df == 0)
                return flow;
            flow += df;
        }
    }

    static int findPath(int[][] cap, boolean[] vis, int u, int t, int f) {
        if (u == t)
            return f;
        vis[u] = true;
        for (int v = 0; v < vis.length; v++)
            if (!vis[v] && cap[u][v] > 0) {
                int df = findPath(cap, vis, v, t, Math.min(f, cap[u][v]));
                if (df > 0) {
                    cap[u][v] -= df;
                    cap[v][u] += df;
                    return df;
                }
            }
        return 0;
    }
}
