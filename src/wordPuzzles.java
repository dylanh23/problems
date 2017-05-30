import java.util.*;

/**
 * Created by D on 5/29/2017.
 */
public class wordPuzzles {

  /***
   Trie:
   O(8 * 1000 * 1000 * 1000 (length of text: 8 directions, 1000000 starting spots, 1000 max length from one spot) +
   1000 * 1000 (total number of char in words) +
   1000 (total number of occurrences of words in text))
   O(9m)

   Heap:
   add/remove O(log(1000))
   contains O(1000)
   O(1000)
   **/

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tc = sc.nextInt();
    for (int gg = 0; gg < tc; gg++) {
      int h = sc.nextInt();
      int w = sc.nextInt();
      int wordsLength = sc.nextInt();
      sc.nextLine();
      char[][] board = new char[w][h];
      for (int k = 0; k < h; k++) {
        char[] chars = sc.nextLine().toCharArray();
        for (int j = 0; j < w; j++) {
          board[j][k] = chars[j];
        }
      }
      AhoCorasick ahoCorasick = new AhoCorasick(h * w);
      for (int i = 0; i < wordsLength; i++) {
        ahoCorasick.addString(new StringBuilder(sc.nextLine()).reverse().toString(), i);
      }
      PriorityQueue<Result> results = new PriorityQueue<>(new PriorityQueue<>(11, new Comparator<Result>() {
        public int compare(Result a, Result b) {
          if (a.i > b.i) return 1;
          if (a.i == b.i) return 0;
          return -1;
        }
      }));
      for (int k = 0; k < h; k++) {
        //left
        int node = 0;
        for (int j = 0; j < w; j++) {
          node = ahoCorasick.transition(node, board[j][k]);
          if (nodes[node].leaf) {
            if (!results.contains(new Result(j, k, 'G', nodes[node].index)))
              results.add(new Result(j, k, 'G', nodes[node].index));
          }
        }
        node = 0;
        //right
        for (int j = w - 1; j >= 0; j--) {
          node = ahoCorasick.transition(node, board[j][k]);
          if (nodes[node].leaf) {
            if (!results.contains(new Result(j, k, 'C', nodes[node].index)))
              results.add(new Result(j, k, 'C', nodes[node].index));
          }
        }
      }
      for (int j = 0; j < w; j++) {
        int node = 0;
        //up
        for (int k = 0; k < h; k++) {
          node = ahoCorasick.transition(node, board[j][k]);
          if (nodes[node].leaf) {
            if (!results.contains(new Result(j, k, 'A', nodes[node].index)))
              results.add(new Result(j, k, 'A', nodes[node].index));
          }
        }
        node = 0;
        //down
        for (int k = h - 1; k >= 0; k--) {
          node = ahoCorasick.transition(node, board[j][k]);
          if (nodes[node].leaf) {
            if (!results.contains(new Result(j, k, 'E', nodes[node].index)))
              results.add(new Result(j, k, 'E', nodes[node].index));
          }
        }
      }
      for (int J = 0; J < w; J++) {
        for (int K = 0; K < h; K++) {
          int node = 0;
          int j = J;
          int k = K;
          //up-left
          while (j < w && k < h) {
            node = ahoCorasick.transition(node, board[j][k]);
            if (nodes[node].leaf) {
              if (!results.contains(new Result(j, k, 'H', nodes[node].index)))
                results.add(new Result(j, k, 'H', nodes[node].index));
            }
            j++;
            k++;
          }
          j = J;
          k = K;
          //down-left
          while (j < w && k >= 0) {
            node = ahoCorasick.transition(node, board[j][k]);
            if (nodes[node].leaf) {
              if (!results.contains(new Result(j, k, 'F', nodes[node].index)))
                results.add(new Result(j, k, 'F', nodes[node].index));
            }
            j++;
            k--;
          }
          j = J;
          k = K;
          //down-right
          while (j >= 0 && k >= 0) {
            node = ahoCorasick.transition(node, board[j][k]);
            if (nodes[node].leaf) {
              if (!results.contains(new Result(j, k, 'D', nodes[node].index)))
                results.add(new Result(j, k, 'D', nodes[node].index));
            }
            j--;
            k--;
          }
          j = J;
          k = K;
          //up-right
          while (j >= 0 && k < h) {
            node = ahoCorasick.transition(node, board[j][k]);
            if (nodes[node].leaf) {
              if (!results.contains(new Result(j, k, 'B', nodes[node].index)))
                results.add(new Result(j, k, 'B', nodes[node].index));
            }
            j--;
            k++;
          }
        }
      }
//      Iterator<Result> iter = results.iterator();
//      while (iter.hasNext()) {
//        Result current = iter.next();
//        System.out.println(current.k + " " + current.j + " " + current.d);
//      }
      while (results.size() > 0) {
        Result current = results.remove();
        System.out.println(current.k + " " + current.j + " " + current.d);
//      }
      }
    }
  }

  static class Result {
    int j, k, i;
    char d;
    Result(int j, int k, char d, int i) {
      this.j = j;
      this.k = k;
      this.d = d;
      this.i = i;
    }

    @Override
    public boolean equals(Object object)
    {
      if (!(object instanceof Result))
        return false;
      Result result2 = (Result) object;
      return result2.d == this.d && result2.j == this.j && result2.k == this.k && result2.i == this.i;
    }
  }

  static final int ALPHABET_SIZE = 26;

  static Node[] nodes;
  static int nodeCount;

  public static class Node {
    int parent;
    char charFromParent;
    int suffLink = -1;
    int[] children = new int[ALPHABET_SIZE];
    int[] transitions = new int[ALPHABET_SIZE];
    boolean leaf;
    public int index;

    {
      Arrays.fill(children, -1);
      Arrays.fill(transitions, -1);
    }
  }

  static class AhoCorasick {
    public AhoCorasick(int maxNodes) {
      nodes = new Node[maxNodes];
      // create root
      nodes[0] = new Node();
      nodes[0].suffLink = 0;
      nodes[0].parent = -1;
      nodeCount = 1;
    }

    public void addString(String s, int i) {
      int cur = 0;
      for (char ch : s.toCharArray()) {
        int c = (int) ch - 65;
        if (nodes[cur].children[c] == -1) {
          nodes[nodeCount] = new Node();
          nodes[nodeCount].parent = cur;
          nodes[nodeCount].charFromParent = ch;
          nodes[cur].children[c] = nodeCount++;
        }
        cur = nodes[cur].children[c];
      }
      nodes[cur].index = i;
      nodes[cur].leaf = true;
    }

    public int suffLink(int nodeIndex) {
      Node node = nodes[nodeIndex];
      if (node.suffLink == -1)
        node.suffLink = node.parent == 0 ? 0 : transition(suffLink(node.parent), node.charFromParent);
      return node.suffLink;
    }

    public int transition(int nodeIndex, char ch) {
      int c = (int) ch - 65;
      Node node = nodes[nodeIndex];
      if (node.transitions[c] == -1)
        node.transitions[c] = node.children[c] != -1 ? node.children[c] : (nodeIndex == 0 ? 0 : transition(suffLink(nodeIndex), ch));
      return node.transitions[c];
    }
  }
}
