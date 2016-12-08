import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by D on 10/24/2016.
 */
public class thelastword {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = Integer.parseInt(sc.nextLine());
        for (int tc = 1; tc <= testCases; tc++) {
            char[] s = sc.nextLine().toCharArray();
            String result = String.valueOf(s[0]);
            for (int i = 1; i < s.length; i++) {
                if (s[i] >= result.charAt(0)) {
                    result = s[i] + result;
                } else {
                    result += s[i];
                }
            }
            System.out.println("Case #" + tc + ": " + result);
        }
    }
}
