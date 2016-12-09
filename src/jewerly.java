import java.lang.reflect.Array;
import java.security.Provider;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by D on 10/19/2016.
 */
public class jewerly {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().replaceAll("[^\\d.]", "").split("");
        int[] jewerly = new int[input.length];
        for (int i = 0; i < jewerly.length; i++)
            jewerly[i] = Integer.parseInt(input[i]);
        int possibleCombinations[][][] = new int[jewerly.length][jewerly.length][jewerly.length];
        Arrays.sort(jewerly);
        for (int i = 0; i < jewerly.length; i += 2) {
            if (jewerly[i] <= jewerly[i + 1]) {
//                possibleCombinations[i][jewerly[i]][jewerly[i]];
            }
                break;
        }
    }
}
