import java.awt.*;
import java.lang.reflect.Array;
import java.time.temporal.Temporal;
import java.util.*;
import java.util.List;

/**
 * Created by dhare on 6/1/2017.
 */
public class test {
    static class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            boolean[][] edges = new boolean[numCourses][numCourses];
            for (int i = 0; i < prerequisites.length; i++) {
                edges[prerequisites[i][1]][prerequisites[i][0]] = true;
            }
            HashMap<Integer, ArrayList<Integer>> map = new HashMap();
            boolean[] visited = new boolean[numCourses];
            ArrayList<Integer> root = new ArrayList();
            for (int i = 0; i < numCourses; i++) {
                ArrayList<Integer> parents = new ArrayList();
                for (int k = 0; k < numCourses; k++) {
                    if (edges[k][i]) {
                        parents.add(k);
                    }
                }
                if (parents.size() == 0) {
                    root.add(i);
                }
                map.put(i, parents);
            }
            Queue<Integer> stack = new LinkedList<>();
            if (root.size() == 0) {
                return new int[0];
            }
            for (Integer i : root) {
                stack.add(i);
            }
            int[] ans = new int[numCourses];
            int i = 0;
            int count = 0;
            while (!stack.isEmpty()) {
                int cur = stack.remove();
                boolean req = true;
                for (int p : map.get(cur)) {
                    if (!visited[p]) {
                        req = false;
                        break;
                    }
                }
                if (!req) {
                    if (count > stack.size())
                        return new int[0];
                    count ++;
                    if (stack.isEmpty())
                        return new int[0];
                    stack.add(cur);
                } else {
                    count = 0;
                    visited[cur] = true;
                    for (int n = 0; n < numCourses; n++) {
                        if (edges[cur][n]) {
                            if (visited[n])
                                return new int[0];
                            if (!stack.contains(n))
                            stack.add(n);
                        }
                    }
                    ans[i] = cur;
                    i++;
                }
            }
            for (boolean b : visited)
                if (!b)
                    return new int[0];
            return ans;
        }
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] a = {{1, 0}, {2, 1}, {3, 2}, {1, 3}};
        s.findOrder(4, a);
        System.out.println();
    }
}

