import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class charity {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < testcases; i++) {
            int amount = sc.nextInt();
            sc.nextLine();
            String[] input = sc.nextLine().split(" ");
            int[] cities = new int[amount];
            int totalCoins = 0;
            for (int x = 0; x < amount; x++) {
                cities[x] = Integer.parseInt(input[x]);
            }
            Arrays.sort(cities);
            ArrayList<Integer> cities1 = new ArrayList<>();
            ArrayList<Integer> cities2 = new ArrayList<>();
            for (int x = 0; x < amount; x += 2) {
                cities1.add(cities[x]);
            }
            for (int x = 1; x < amount; x += 2) {
                cities2.add(cities[x]);
            }

            Collections.reverse(cities2);
            ArrayList<Integer> citiesBoth = new ArrayList<>();
            citiesBoth.addAll(cities1);
            citiesBoth.addAll(cities2);
            for (int x = 1; x < amount; x++) {
                if (citiesBoth.get(x) + citiesBoth.get(x-1) > 0) {
                    totalCoins += citiesBoth.get(x) + citiesBoth.get(x-1);
                }
            }
            System.out.println(totalCoins);
        }
    }
}
