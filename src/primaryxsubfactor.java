import java.util.*;

/**
 * Created by D on 10/11/2016.
 */
public class primaryxsubfactor {
    private static List<List<Integer>> xSubfactorSequences = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = Integer.parseInt(sc.nextLine());
        while (number != 0) {
            ArrayList<Integer> xSubfactorSequence = new ArrayList<>();
            xSubfactorSequence.add(number);
            xSubfactor(xSubfactorSequence);
            List<Integer> bestXSubfactorSequence = xSubfactorSequences.get(0);
            for (List<Integer> xss : xSubfactorSequences) {
                if (xss.size() > bestXSubfactorSequence.size()) {
                    bestXSubfactorSequence = xss;
                } else if (xss.size() == bestXSubfactorSequence.size()) {
                    for (int i = 1; i < xss.size(); i++) {
                        if (xss.get(i) < bestXSubfactorSequence.get(i)) {
                            bestXSubfactorSequence = xss;
                            break;
                        }
                        if (xss.get(i) > bestXSubfactorSequence.get(i)) {
                            break;
                        }
                    }
                }
            }
            for (Integer i : bestXSubfactorSequence)
                System.out.print(i + " ");
            System.out.println();
            xSubfactorSequences.clear();
            number = Integer.parseInt(sc.nextLine());
        }
    }


    private static void xSubfactor(ArrayList<Integer> xSubfactorSequence) {
        int number = xSubfactorSequence.get(xSubfactorSequence.size() - 1);
        String stringNumber = String.valueOf(number);
        boolean addedOne = false;
        for (int i = 0; i < stringNumber.length(); i++) {
            for (int i2 = i + 1; i2 < stringNumber.length() + 1; i2++) {
                if (!String.valueOf(stringNumber.substring(i, i2).toCharArray()[0]).equals("0")) {
                    int subFactor = Integer.parseInt(stringNumber.substring(i, i2));
                    if (subFactor > 1 && subFactor != number && number % subFactor == 0) {
                        String temp = stringNumber.substring(0, i) + stringNumber.substring(i2, stringNumber.length());
                        ArrayList<Integer> tempSubfactorSequence = new ArrayList<>();
                        tempSubfactorSequence.addAll(xSubfactorSequence);
                        tempSubfactorSequence.add(Integer.valueOf(temp));
                        xSubfactor(tempSubfactorSequence);
                        addedOne = true;
                    }
                }
            }
        }

        if (!addedOne)
            xSubfactorSequences.add(xSubfactorSequence);
    }
}
