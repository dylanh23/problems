import java.util.*;

public class unicyclecounting {
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\\n");
        while (sc.hasNext()) {
            String[] input = sc.next().split(" ");
            int length = Integer.parseInt(input[0]) - 1;
//            int[] marks = new int[input.length - 2];
            ArrayList<mark> marks = new ArrayList<>();
            for (int i = 0; i < input.length - 2; i++)
                marks.add(new mark(Integer.parseInt(input[i + 2]), false));
            int numOfUnicycles = 0;
            for (mark m : marks) {
                if (!m.used) {
                    incrementloop:
                    for (int increment = 1; increment < length - m.spot; increment++) {
                        if (containMark(marks, m.spot + increment)) {
                            int currentMark = m.spot + increment;
                            ArrayList<Integer> marksToBeRemoved = new ArrayList<>();
                            marksToBeRemoved.add(m.spot + increment);
                            while (true) {
                                currentMark += increment;
                                if (currentMark > length) {
                                    numOfUnicycles += 1;
                                    for (Integer markKey : marksToBeRemoved)
                                        for (mark markBeingRemoved : marks)
                                            if (markBeingRemoved.spot == markKey)
                                                markBeingRemoved.used = true;
                                    break incrementloop;
                                } else if (!containMark(marks, currentMark)) {
                                    break;
                                } else {
                                    marksToBeRemoved.add(currentMark);
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(numOfUnicycles);
        }
    }

    static boolean containMark(ArrayList<mark> marks, int i) {
        for (mark m : marks)
            if (m.spot == i)
                return true;
        return false;
    }

    static class mark {
        Boolean used;
        int spot;

        mark(int spot, Boolean used) {
            this.used = used;
            this.spot = spot;
        }
    }
}