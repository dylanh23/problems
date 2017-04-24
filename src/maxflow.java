import java.util.LinkedList;

/**
 * Created by D on 3/14/2017.
 */
class maxflow {
  static final int V = 6; //Number of vertices in graph

  /* Returns true if there is a path from source 's' to sink
    't' in residual graph. Also fills parent[] to store the
    path */
  boolean bfs(int rGraph[][], int s, int t, int parent[]) {
    // Create a visited array and mark all vertices as not
    // visited
    boolean visited[] = new boolean[V];
    for (int i = 0; i < V; ++i)
      visited[i] = false;

    // Create a queue, enqueue source vertex and mark
    // source vertex as visited
    LinkedList<Integer> queue = new LinkedList<>();
    queue.add(s);
    visited[s] = true;
    parent[s] = -1;

    // Standard BFS Loop
    while (queue.size() != 0) {
      int u = queue.poll();

      for (int v = 0; v < V; v++) {
        if (!visited[v] && rGraph[u][v] > 0) {
          queue.add(v);
          parent[v] = u;
          visited[v] = true;
          if (v == t) {
            return true;
          }
        }
      }
    }
    return false;
  }

  // Returns tne maximum flow from s to t in the given graph
  int fordFulkerson(int rGraph[][], int s, int t) {
    int u, v;

    // Create a residual graph and fill the residual graph
    // with given capacities in the original graph as
    // residual capacities in residual graph

    // This array is filled by BFS and to store path
    int parent[] = new int[V];

    int max_flow = 0;  // There is no flow initially

    // Augment the flow while tere is path from source
    // to sink
    while (bfs(rGraph, s, t, parent)) {
      // Find minimum residual capacity of the edhes
      // along the path filled by BFS. Or we can say
      // find the maximum flow through the path found.
      int path_flow = Integer.MAX_VALUE;
      for (v = t; v != s; v = parent[v]) {
        u = parent[v];
        path_flow = Math.min(path_flow, rGraph[u][v]);
      }

      // update residual capacities of the edges and
      // reverse edges along the path
      for (v = t; v != s; v = parent[v]) {
        u = parent[v];
        rGraph[u][v] -= path_flow;
//        rGraph[v][u] += path_flow;
      }

      // Add path flow to overall flow
      max_flow += path_flow;
    }

    // Return the overall flow
    return max_flow;
  }

  // Driver program to test above functions
  public static void main(String[] args) throws java.lang.Exception {
    // Let us create a graph shown in the above example
    int graph[][] = new int[][]{{0, 16, 13, 0, 0, 0},
        {0, 0, 10, 12, 0, 0},
        {0, 4, 0, 0, 14, 0},
        {0, 0, 9, 0, 0, 20},
        {0, 0, 0, 7, 0, 4},
        {0, 0, 0, 0, 0, 0}
    };
    maxflow m = new maxflow();

    System.out.println(m.fordFulkerson(graph, 0, 5));
  }
}
