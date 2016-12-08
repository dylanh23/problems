import java.util.*;

public class wordsequence {
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int dicLength = sc.nextInt();
        sc.useDelimiter("\\n");
        sc.next();
        String[] dic = new String[dicLength];
        for (int i = 0; i < dicLength; i++) {
            dic[i] = sc.next();
        }
        while (sc.hasNext()) {
            String[] input = sc.next().split(" ");
            String word1 = input[0];
            String word2 = input[1];
            int moveCounter = 0;
            while (true) {
                moveCounter += 1;
                List<String> possibleMoves = new ArrayList<>();
                for (String d : dic) {
                    int minLength = Math.min(word1.toCharArray().length, d.toCharArray().length);
                    int differences = 0;
                    for (int i = 0; i < minLength; i++) {
                        if (d.toCharArray()[i] != word1.toCharArray()[i]) {
                            differences += 1;
                        }
                    }
                    differences += Math.max(word1.toCharArray().length, d.toCharArray().length) - minLength;
                    if (differences == 1) {
                        possibleMoves.add(d);
                    }
                }
                if (possibleMoves.size() > 0) {
                    int pmCounter = 0;
                    int[] differencesInPMs = new int[possibleMoves.size()];
                    //shoudve made list from start
                    for (String pm : possibleMoves) {
                        int minLength = Math.min(word2.toCharArray().length, pm.toCharArray().length);
                        int differences = 0;
                        for (int i = 0; i < minLength; i++) {
                            if (pm.toCharArray()[i] != word2.toCharArray()[i]) {
                                differences += 1;
                            }
                        }
                        differencesInPMs[pmCounter] = differences;
                        pmCounter += 1;
                    }
                    int smallest = Integer.MAX_VALUE;
                    for (int i : differencesInPMs) {
                        if (smallest > i) {
                            smallest = i;
                        }
                    }
                    List<Integer> intList = new ArrayList<Integer>();
                    for (int d : differencesInPMs) {
                        intList.add(d);
                    }
                    word1 = possibleMoves.get(intList.indexOf(smallest));
                }
                if (word1.equals(word2)) {
                    System.out.println(moveCounter);
                    break;
                } else if (moveCounter > dic.length) {
                    System.out.println("-1");
                    break;
                }
            }
        }
    }
}