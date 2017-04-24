import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;

/**
 * Created by D on 3/6/2017.
 */
public class carrepair {
  public static void main(String[] args) {
    int N, C, R;
    HashMap<String, Node> nodeHashMap = new HashMap<>();
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    C = sc.nextInt();
    R = sc.nextInt();
    Node[] destinations = new Node[C + 1];
    int tc = 1;
    while (N != 0) {
      for (int i = 0; i < C + 1; i++) {
        destinations[i] = new Node();
        nodeHashMap.put(sc.next(), destinations[i]);
      }
      sc.nextLine();
      for (int i = 0; i < R; i++) {
        String[] input = sc.nextLine().split("\\s+");
        if (nodeHashMap.get(input[0]) == null) {
          nodeHashMap.put(input[0], new Node());
        }
        if (nodeHashMap.get(input[2]) == null) {
          nodeHashMap.put(input[2], new Node());
        }
        int cost = Integer.parseInt(input[1].replaceAll("[\\D]", ""));
        if (input[1].charAt(0) == '<') {
          nodeHashMap.get(input[2]).roads.add(nodeHashMap.get(input[0]));
          nodeHashMap.get(input[2]).roadSpeed.add(cost);
        }
        if (input[1].charAt(input[1].length() - 1) == '>') {
          nodeHashMap.get(input[0]).roads.add(nodeHashMap.get(input[2]));
          nodeHashMap.get(input[0]).roadSpeed.add(cost);
        }
      }
      int a = 0;
      Node previousNode = destinations[0];
      for (int i = 1; i < C + 1; i++) {
        a += bfs(previousNode, destinations[i]);
        previousNode = destinations[i];
        for (Object o : nodeHashMap.entrySet()) {
          Map.Entry pair = (Map.Entry) o;
          Node n = (Node) pair.getValue();
          n.distance = Integer.MAX_VALUE;
          n.visited = false;
        }
      }
      a += bfs(previousNode, destinations[0]);
      System.out.println(tc + ". " + a);
      tc++;
      N = sc.nextInt();
      C = sc.nextInt();
      R = sc.nextInt();
    }
  }

  static class Node {
    //    String label;
    ArrayList<Node> roads = new ArrayList<>();
    ArrayList<Integer> roadSpeed = new ArrayList<>();
    Boolean visited = false;
    int distance = Integer.MAX_VALUE;

//    Node(String label) {
//      this.label = label;
//    }
  }

  static int bfs(Node root, Node target) {
    ArrayList<Node> nodes = new ArrayList<>();
    root.visited = true;
    root.distance = 0;
    nodes.add(root);
    while (!nodes.isEmpty()) {
      Node shortestDistanceNode = nodes.get(0);
      for (Node n : nodes) {
        if (n.distance < shortestDistanceNode.distance) {
          shortestDistanceNode = n;
        }
      }
      if (shortestDistanceNode == target) {
        return shortestDistanceNode.distance;
      }
      shortestDistanceNode.visited = true;
      ArrayList<Node> toBeAdded = new ArrayList<>();
      for (int i = 0; i < shortestDistanceNode.roads.size(); i++) {
        Node n = shortestDistanceNode.roads.get(i);
        if (!n.visited) {
          if (toBeAdded.contains(n)) {
            toBeAdded.get(toBeAdded.indexOf(n)).distance = Math.min(toBeAdded.get(toBeAdded.indexOf(n)).distance, shortestDistanceNode.roadSpeed.get(i) + shortestDistanceNode.distance);
          } else {
            n.distance = shortestDistanceNode.roadSpeed.get(i) + shortestDistanceNode.distance;
            toBeAdded.add(n);
          }
        }
      }
      nodes.addAll(toBeAdded);
      nodes.remove(shortestDistanceNode);
    }
    return -1;
  }

}
