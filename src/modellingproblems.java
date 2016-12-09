import java.util.HashMap;
import java.util.Scanner;

public class modellingproblems {

    static Boolean assertionsHold = true;
    static String[] input;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int amount = Integer.parseInt(sc.nextLine());
        for (int testcases = 0; testcases < amount; testcases++) {
            input = sc.nextLine().split("");
            int place = 0;
            HashMap<Character, Integer> variables = new HashMap<>();
            compileCode(variables, place);
            //split off into new and then make sure all equal assertions always hold
            if (assertionsHold) {
                System.out.println("ASSERTIONS ALWAYS HOLD");
            } else {
                System.out.println("ASSERTIONS INVALID");
                assertionsHold = true;
            }
        }

    }

    //TODO: dont pass map?
    private static void compileCode(HashMap<Character, Integer> variables, int place) {
        while (place < input.length) {
            if (input[place].equals("[")) {
                place += 1;
                Character varName = input[place].charAt(0);
                place += 2;
                String varValue = "";
                int varValueInt;
                //TODO: make quicker?
                while (!input[place].equals("]")) {
                    varValue += input[place];
                    place += 1;
                }
                place += 1;
                if (varValue.equals("?")) {
                    varValueInt = 0;
                    variables.put(varName, varValueInt);
                    compileCode(variables, place);
                    varValueInt = 1;
                    variables.put(varName, varValueInt);
                } else if (isNumeric(varValue)) {
                    varValueInt = Integer.parseInt(varValue);
                    variables.put(varName, varValueInt);
                } else {
                    varValueInt = getVarValue(varValue.charAt(0), variables) + getVarValue(varValue.charAt(2), variables);
                    variables.put(varName, varValueInt);
                }
            } else if (input[place].equals("(")) {
                place += 1;
                if (getVarValue(input[place].charAt(0), variables) < getVarValue(input[place + 2].charAt(0), variables)) {
                    place += 4;
                } else {
                    //TODO: make quicker?
                    while (input[place].equals(")")) {
                        place += 1;
                    }
                    place += 1;
                }

            } else if (input[place].equals("}")) {
                place += 2;
            } else if (input[place].equals("<")) {
                if (!(getVarValue(input[place + 1].charAt(0), variables) == getVarValue(input[place + 3].charAt(0), variables))) {
                    assertionsHold = false;
                    break;
                } else {
                    place += 5;
                }
            }
        }
    }

    //TODO: don't pass map?
    public static int getVarValue(Character c, HashMap<Character, Integer> hs) {
        if (hs.containsKey(c)) {
            return hs.get(c);
        } else {
            return 0;
        }
    }

    public static boolean isNumeric(String str) {
        return str.matches("[-+]?\\d*\\.?\\d+");
    }
}
