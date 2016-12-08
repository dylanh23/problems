import java.util.Scanner;

/**
 * Created by D on 10/24/2016.
 */
public class closematch {
    static int[] total = {0, 0};
    static StringBuilder[] scores = new StringBuilder[2];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = Integer.parseInt(sc.nextLine());
        for (int tc = 1; tc <= testCases; tc++) {
            scores = new StringBuilder[2];
            String[] inputs = sc.nextLine().split(" ");
            scores[0] = new StringBuilder(inputs[0]);
            scores[1] = new StringBuilder(inputs[1]);
            for (int i = 0; i < scores[0].length(); i++) {
                if (String.valueOf(scores[0].charAt(i)).equals("?") && String.valueOf(scores[1].charAt(i)).equals("?")) {
                    if (total[0] > total[1]) {
                        scores[1].setCharAt(i, '9');
                        scores[0].setCharAt(i, '0');
                    } else if (total[0] < total[1]) {
                        scores[0].setCharAt(i, '9');
                        scores[1].setCharAt(i, '0');
                    } else {
                        scores[1].setCharAt(i, '0');
                        scores[0].setCharAt(i, '0');
                    }
                } else if (String.valueOf(scores[0].charAt(i)).equals("?") && !String.valueOf(scores[1].charAt(i)).equals("?")) {
                    if (total[0] > total[1]) {
                        scores[0].setCharAt(i, '0');
                    } else if (total[0] < total[1]) {
                        scores[0].setCharAt(i, '9');
                    } else {
                        scores[0].setCharAt(i, scores[1].charAt(i));
                    }
                } else if (!String.valueOf(scores[0].charAt(i)).equals("?") && String.valueOf(scores[1].charAt(i)).equals("?")) {
                    if (total[0] > total[1]) {
                        scores[1].setCharAt(i, '9');
                    } else if (total[0] < total[1]) {
                        scores[1].setCharAt(i, '0');
                    } else {
                        scores[1].setCharAt(i, scores[0].charAt(i));
                    }
                }
                calcTotal(i + 1);
            }
            System.out.println("Case #" + tc + ": " + scores[0] + " " + scores[1]);
            total[0] = 0;
            total[1] = 0;
        }
    }

    public static void calcTotal(int limit) {
        int total1 = 0;
        for (int i = 0; i < limit; i++) {
            total1 += Character.getNumericValue(scores[0].charAt(i));
        }
        total[0] = total1;
        int total2 = 0;
        for (int i = 0; i < limit; i++) {
            total2 += Character.getNumericValue(scores[1].charAt(i));
        }
        total[1] = total2;
    }
}
