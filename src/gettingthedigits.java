import com.sun.javafx.image.IntPixelGetter;

import java.util.*;

/**
 * Created by D on 10/24/2016.
 */
public class gettingthedigits {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int testCases = Integer.parseInt(sc.nextLine());
        for (int tc = 0; tc < testCases; tc++) {
            String origNum = sc.nextLine();
            List<String> inputNum = Arrays.asList(origNum.split(""));
            String[] nums = {"ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE"};
            ArrayList<String> possibleNums = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                boolean possibleNumber = true;
                for (int i2 = 0; i2 < nums[i].length(); i2++) {
                    if (!inputNum.contains(String.valueOf(nums[i].charAt(i2)))) {
                        possibleNumber = false;
                        break;
                    }
                }
                if (possibleNumber) {
                    possibleNums.add(nums[i]);
                }
            }
            String result = "";
            for (int i = 0; i < (int) Math.pow(possibleNums.size(), 2); i++) {
                String tempInputNum = origNum;
                String pos = String.format("%" + Integer.toString(possibleNums.size()) + "s", Integer.toBinaryString(i)).replace(" ", "0");
//                ArrayList<String> chosenPos = new ArrayList<>();
                String t = "";
                for (int x = 0; x < pos.length(); x++) {
                    if (String.valueOf(pos.charAt(x)).equals("1")) {
                        t += possibleNums.get(x) + " ";
                    }
                }
                boolean wrong = false;
                for (char c : t.replace(" ", "").toCharArray()) {
                    if (tempInputNum.indexOf(c) != -1) {
                        tempInputNum = tempInputNum.replaceFirst(String.valueOf(c), "");
                    } else {
                        wrong = true;
                        break;
                    }
                }
                if (!wrong && tempInputNum.equals("")) {
                    ArrayList<Integer> correctNums = new ArrayList<>();
                    for (String s : t.split(" ")) {
                        if (s.equals("ZERO")) {
                            correctNums.add(0);
                        } else if (s.equals("ONE")) {
                            correctNums.add(1);
                        } else if (s.equals("TWO")) {
                            correctNums.add(2);
                        } else if (s.equals("THREE")) {
                            correctNums.add(3);
                        } else if (s.equals("FOUR")) {
                            correctNums.add(4);
                        } else if (s.equals("FIVE")) {
                            correctNums.add(5);
                        } else if (s.equals("SIX")) {
                            correctNums.add(6);
                        } else if (s.equals("SEVEN")) {
                            correctNums.add(7);
                        } else if (s.equals("EIGHT")) {
                            correctNums.add(8);
                        } else if (s.equals("NINE")) {
                            correctNums.add(9);
                        }
                    }
                    Collections.sort(correctNums);
                    for (int cn : correctNums) {
                        result += String.valueOf(cn);
                    }
                }
            }
            System.out.println("Case #" + tc + ": " + result);
        }
    }
}
