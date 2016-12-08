import java.util.Scanner;

public class countingsheep {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCaseAmount = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= testCaseAmount; i++) {
            int num = Integer.parseInt(sc.nextLine());
            if (num == 0) {
                System.out.println("Case #" + i + ": INSOMNIA");
            } else {
                boolean[] seen = new boolean[10];
                int counter = 1;
                int tempNum = num;
                while (true) {
                    for (String s : String.valueOf(tempNum).split("")) {
                        seen[Integer.valueOf(s)] = true;
                    }
                    boolean allSeen = true;
                    for (boolean b : seen) {
                        if (!b) {
                            allSeen = false;
                            break;
                        }
                    }
                    if (allSeen) {
                        System.out.println("Case #" + i + ": " + tempNum);
                        break;
                    }
                    counter += 1;
                    tempNum = num * counter;
                }
            }
        }
    }
}
