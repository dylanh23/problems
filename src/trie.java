import java.util.*;

/**
 * Created by D on 3/31/2017.
 */
public class trie {

  static class node {
    HashMap<Character, node> characternodeHashMap = new HashMap<>();
    boolean complete = false;
    String w = "";
  }

  static node root;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s = sc.nextLine();
    root = new node();
    while (!s.equals("")) {
      node temp = root;
      int i = s.length() - 1;
      while (i >= 0) {
        if (temp.characternodeHashMap.get(s.charAt(i)) != null) {
          temp = temp.characternodeHashMap.get(s.charAt(i));
        } else {
          node t = new node();
          temp.characternodeHashMap.put(s.charAt(i), t);
          temp = t;
        }
        i--;
      }
      temp.complete = true;
      temp.w = s;
      s = sc.nextLine();
    }
    while (sc.hasNextLine()) {
      System.out.println(answer(new StringBuilder(sc.nextLine()).reverse().toString()));
    }
  }

  private static String answer(String s) {
    node temp = root;
    int i = 0;
    node lastNotEmpty = root;
    while (temp.characternodeHashMap.get(s.charAt(i)) != null) {
      temp = temp.characternodeHashMap.get(s.charAt(i));
      i++;
      if (i == s.length()) {
        if (temp.characternodeHashMap.isEmpty()) {
          temp = lastNotEmpty;
        }
        break;
      }
      if (temp.characternodeHashMap.size() > 1 || temp.complete) {
        node t = new node();
        t.characternodeHashMap = (HashMap<Character, node>) temp.characternodeHashMap.clone();
        t.w = temp.w;
        t.complete = temp.complete;
        t.characternodeHashMap.remove(s.charAt(i));
        lastNotEmpty = t;
      }
    }
    return getWord(temp);
//    return getLexicographicallySmallest(words);
  }

//  private static String getLexicographicallySmallest(ArrayList<String> words) {
//    ArrayList<String> r = new ArrayList<>();
//    for (String s : words) {
//
//    }
//    return getLexicographicallySmallest(r);
//  }

  private static String getWord(node root) {
    //first completed, all ties with n return sorted first
    Queue<node> stack = new LinkedList<>();
    stack.add(root);
    ArrayList<String> strings = new ArrayList<>();
    while (!stack.isEmpty()) {
      node n = stack.remove();
      if (n.complete) {
        strings.add(n.w);
      }
      Iterator it = n.characternodeHashMap.entrySet().iterator();
      while (it.hasNext()) {
        Map.Entry pair = (Map.Entry) it.next();
        stack.add((node) pair.getValue());
      }
    }
    Collections.sort(strings);
    return strings.get(0);
  }

}
