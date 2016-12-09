import java.awt.*;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by D on 10/15/2016.
 */
public class bits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int amount = sc.nextInt();
        sc.nextLine();
        for (int testCases = 0; testCases < amount; testCases++) {
            String number = sc.nextLine();
//            String[] input = number.split("");
            int maxBits = 0;
            for (int i = 1; i <= number.length(); i++) {
                String[] binary = Integer.toBinaryString(Integer.parseInt(number.substring(0, i))).split("");
                int bitCount = 0;
                for (int i2 = 0; i2 < binary.length; i2++) {
                    if (binary[i2].equals("1"))
                        bitCount += 1;
                }
                if (bitCount > maxBits)
                    maxBits = bitCount;
            }
            System.out.println(maxBits);
        }
    }
}
