import java.util.Scanner;

public class needle {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int first = Integer.parseInt(sc.nextLine());
        int second = Integer.parseInt(sc.nextLine());
        int clockwise = second - first;
        if (clockwise < 0) {
            clockwise = 360 + clockwise;
        }
        int counterclockwise = first - second;
        if (counterclockwise < 0) {
            counterclockwise = 360 + counterclockwise;
        }
        if (counterclockwise < clockwise) {
            counterclockwise *= -1;
            System.out.println(counterclockwise);
        } else {
            System.out.println(clockwise);
        }
    }
}
