//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Scanner;
//
///**
// * Created by D on 1/29/2017.
// */
//
//public class logic {
//  static HashMap<String, HashMap<doubleBoolean, Boolean>> binary = new HashMap<>();
//  static HashMap<String, HashMap<Boolean, Boolean>> unary = new HashMap<>();
//  static HashMap<String, Boolean> variables = new HashMap<>();
//
//  static class doubleBoolean {
//    boolean first;
//    boolean second;
//
//    doubleBoolean(boolean first, boolean second) {
//      this.first = first;
//      this.second = second;
//    }
//  }
//
//  static ArrayList<String> expression;
//
//  public static void main(String[] args) {
//    Scanner sc = new Scanner(System.in);
//    int u = sc.nextInt();
//    int b = sc.nextInt();
//    while (u != -1) {
//      sc.nextLine();
//      for (int i = 0; i < u; i++) {
//        String s = sc.nextLine();
//        HashMap<Boolean, Boolean> h = new HashMap<>();
//        h.put(false, sc.nextBoolean());
//        h.put(true, sc.nextBoolean());
//        unary.put(s, h);
//        sc.nextLine();
//      }
//      for (int i = 0; i < b; i++) {
//        String s = sc.nextLine();
//        HashMap<doubleBoolean, Boolean> h = new HashMap<>();
//        h.put(new doubleBoolean(false, false), sc.nextBoolean());
//        h.put(new doubleBoolean(false, true), sc.nextBoolean());
//        sc.nextLine();
//        h.put(new doubleBoolean(true, false), sc.nextBoolean());
//        h.put(new doubleBoolean(true, true), sc.nextBoolean());
//        sc.nextLine();
//        binary.put(s, h);
//      }
//      StringBuilder sb = new StringBuilder(sc.nextLine());
//      for (int i = 0; i < sb.length(); i++) {
//        if (sb.charAt(i) == '(' || sb.charAt(i) == ')') {
//          expression.add(String.valueOf(sb.charAt(i)));
//        } else if (sb.charAt(i) == ' ') {
//
//        } else
//      }
//      expression.add(sb.charAt());
//      String v = sc.next();
//      while (!v.equals("*")) {
//        variables.put(v, sc.nextBoolean());
//        sc.nextLine();
//        v = sc.next();
//      }
//      sc.nextLine();
//      u = sc.nextInt();
//      b = sc.nextInt();
//      int i = 0;
//      while (!expression[i].equals(")")) {
//        i++;
//      }
//
//    }
//  }
//
//  private static boolean process(int i) {
//    String s = expression[i];
//    if (s.equals("(")) {
//
//    } else if (s.equals(")")) {
//
//    } else if (unary.get(s) != null) {
//
//    } else if (binary.get(s) != null) {
//
//    } else {
//
//    }
//  }
//
//}
