import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class missingnumbers {
        public static void main(final String[] args) {
            Scanner sc = new Scanner(System.in);
            sc.useDelimiter("\\n");
            int amount = sc.nextInt();
                    sc.next();
            for (int i = 0; i <= amount; i++) {
                String[] input = sc.next().split(" ");
                List<Integer> numbers = new ArrayList<>();
                for (String s : input) {
                    numbers.add(Integer.parseInt(s));
                }
                Collections.sort(numbers);
//                for (int x = 0; x < numbers.)
            }

        }
}
