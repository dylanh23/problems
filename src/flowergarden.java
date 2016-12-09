import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by D on 10/15/2016.
 */
public class flowergarden {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int amount = Integer.parseInt(sc.nextLine());
        for (int testCases = 0; testCases < amount; testCases++) {
            int flowers = sc.nextInt();
            int distance = sc.nextInt();
            double distanceTravelled = 0;
            sc.nextLine();
            Point currentPosition = new Point(0, 0);
            int amountOfFlowers = 0;
            for (int i = 0; i < flowers; i++) {
                int newX = sc.nextInt();
                int newY = sc.nextInt();
                distanceTravelled += Math.sqrt(Math.pow(Math.abs(newX - currentPosition.x), 2) + Math.pow(Math.abs(newY - currentPosition.y), 2));
                if (distanceTravelled >= distance) {
                    if (distanceTravelled == distance) {
                        amountOfFlowers += 1;
                    }
                    for (int i2 = 0; i2 < flowers - i; i2++) {
                        sc.nextLine();
                    }
                    break;
                } else {
                    amountOfFlowers += 1;
                    currentPosition = new Point(newX, newY);
                }
                sc.nextLine();
            }
            if (amountOfFlowers == 0) {
                System.out.println(0);
            } else {
                for (int i = amountOfFlowers; i >= 0; i--) {
                    if (isPrime(i)) {
                        System.out.println(i);
                        break;
                    }
                }
            }
        }
    }

    static boolean isPrime(int n) {
        if (n != 1) {
            for (int i = 2; i < n; i++) {
                if (n % i == 0)
                    return false;
            }
            return true;
        } else{
            return false;
        }
    }
}
