import java.util.Scanner;

/**
 * Created by D on 10/26/2016.
 */
public class airplane {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String seat = input.substring(input.length() - 1, input.length());
        long rowNum = Long.parseLong(input.substring(0, input.length() - 1));
        long newRowNum = rowNum;
        long totalSecsBeforeServe = 0;
        if (rowNum % 2 == 0) {
            newRowNum -= 1;
        }
        if (newRowNum == 1 || newRowNum == 3) {
            totalSecsBeforeServe = 0;
        } else if ((newRowNum - 1) % 4 == 0) {
            totalSecsBeforeServe = (((newRowNum - 1) / 4) * (1 + 6 + 3 + 6));
        } else if ((newRowNum - 3) % 4 == 0) {
            totalSecsBeforeServe = (((newRowNum - 3) / 4) * (1 + 6 + 3 + 6));
        }
        if (rowNum != newRowNum) {
            totalSecsBeforeServe += 7;
        }
        if (seat.equals("c")) {
            totalSecsBeforeServe += 6;
        } else if (seat.equals("b")) {
            totalSecsBeforeServe += 5;
        } else if (seat.equals("a")) {
            totalSecsBeforeServe += 4;
        } else if (seat.equals("d")) {
            totalSecsBeforeServe += 3;
        } else if (seat.equals("e")) {
            totalSecsBeforeServe += 2;
        } else if (seat.equals("f")) {
            totalSecsBeforeServe += 1;
        }
        System.out.print(totalSecsBeforeServe);
    }
}
