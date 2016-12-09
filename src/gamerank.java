import java.util.Scanner;

/**
 * Created by D on 10/22/2016.
 */
public class gamerank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] wins = scanner.nextLine().split("");
        int rank = 25;
        int stars = 0;
        int winstreak = 0;
        for (int i = 0; i < wins.length; i++) {
            if (wins[i].equalsIgnoreCase("W")) {
                winstreak += 1;
                stars += 1;
                if (winstreak >= 3 && rank <= 25 && rank >= 6) {
                    stars += 1;
                }
                if (rank <= 25 && rank >= 21 && stars > 2) {
                    rank -= 1;
                    stars -= 2;
                } else if (rank <= 20 && rank >= 16 && stars > 3) {
                    rank -= 1;
                    stars -= 3;
                } else if (rank <= 15 && rank >= 11 && stars > 4) {
                    rank -= 1;
                    stars -= 4;
                } else if (rank <= 10 && rank >= 1 && stars > 5) {
                    rank -= 1;
                    stars -= 5;
                }
            } else {
                winstreak = 0;
                if (rank >= 1 && rank <= 20) {
                    if (rank < 20 && stars == 0) {
                        rank += 1;
                        if (rank <= 25 && rank >= 21) {
                            stars = 2;
                        } else if (rank <= 20 && rank >= 16) {
                            stars = 3;
                        } else if (rank <= 15 && rank >= 11) {
                            stars = 4;
                        } else if (rank <= 10 && rank >= 1) {
                            stars = 5;
                        }
                    }
                    if (stars > 0)
                        stars -= 1;
                }
            }
        }
        if (rank == 0) {
            System.out.println("Legend");
        } else {
            System.out.println(rank);
        }
    }
}
