import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by D on 10/22/2016.
 */
public class autocorrect {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int amountOfWordsDic = sc.nextInt();
        int amountOfWordsType = sc.nextInt();
        sc.nextLine();
        String[] dic = new String[amountOfWordsDic];
        for (int i = 0; i < amountOfWordsDic; i++) {
            dic[i] = sc.nextLine();
        }
        //how many keystrokes does it take to get the word, in the dictionary
        int[] dicWordCost = new int[amountOfWordsDic];
        for (int i = 0; i < amountOfWordsDic; i++) {
            String w = dic[i];
            outerloop :
            for (int wIterateCount = 0; wIterateCount < w.length(); wIterateCount++) {
                if (wIterateCount == w.length() - 1) {
                    dicWordCost[i] = -1;
                    break;
                }
                //without using dictionary
                for (int x = 0; x < amountOfWordsDic; x++) {
                    if (dic[x].substring(0, wIterateCount).equals(w.substring(0, wIterateCount))) {
                        break outerloop;
                    }
                }
                //with dictionary, but with no calulated costs yet
            }
        }

        for (int i = 0; i < amountOfWordsType; i++) {
            String word = sc.nextLine();
            //find least keystokeword
            for (int d = 0; d < amountOfWordsDic; d++) {
                String dicWord = dic[i];
                int enumThruWord = 0;
                int keyStrokeCount = 0;
            }
        }
    }
}
