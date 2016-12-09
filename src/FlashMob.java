import java.util.*;

public class FlashMob {
    private static int caseCounter = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        fm(sc);
    }

    public static void fm(Scanner sc) {
        caseCounter += 1;
        int membersCount = sc.nextInt();
        if (membersCount > 0) {
            int[] membersX = new int[membersCount];
            int[] membersY = new int[membersCount];
            for (int i = 0; i < membersCount; i += 1) {
                membersX[i] = sc.nextInt();
                membersY[i] = sc.nextInt();
            }
            Arrays.sort(membersX);
            Arrays.sort(membersY);
            int resultX = membersX[(membersCount - 1) / 2];
            int resultY = membersY[(membersCount - 1) / 2];
            int blocksTravelled = 0;
            for (int x : membersX) {
                blocksTravelled += Math.abs(x - resultX);
            }
            for (int y : membersY) {
                blocksTravelled += Math.abs(y - resultY);
            }
            System.out.println("Case " + caseCounter + ": (" + resultX + "," + resultY + ") " + blocksTravelled);
        }
        if (sc.hasNext()) fm(sc);
    }
}
