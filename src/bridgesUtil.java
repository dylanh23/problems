//import java.util.Iterator;
//
///**
// * Created by D on 3/14/2017.
// */
//public class bridgesUtil {
//
//  void bridgeUtilM(int u, boolean visited[], int disc[],
//                  int low[], int parent[])
//  {
//
//    // Count of children in DFS Tree
//    int children = 0;
//
//    // Mark the current node as visited
//    visited[u] = true;
//
//    // Initialize discovery time and low value
//    disc[u] = low[u] = ++time;
//
//    // Go through all vertices aadjacent to this
//    Iterator<Integer> i = adj[u].iterator();
//    while (i.hasNext())
//    {
//      int v = i.next();  // v is current adjacent of u
//
//      // If v is not visited yet, then make it a child
//      // of u in DFS tree and recur for it.
//      // If v is not visited yet, then recur for it
//      if (!visited[v])
//      {
//        parent[v] = u;
//        bridgeUtilM(v, visited, disc, low, parent);
//
//        // Check if the subtree rooted with v has a
//        // connection to one of the ancestors of u
//        low[u]  = Math.min(low[u], low[v]);
//
//        // If the lowest vertex reachable from subtree
//        // under v is below u in DFS tree, then u-v is
//        // a bridge
//        if (low[v] > disc[u])
//          System.out.println(u+" "+v);
//      }
//
//      // Update low value of u for parent function calls.
//      else if (v != parent[u])
//        low[u]  = Math.min(low[u], disc[v]);
//    }
//  }
//
//}
