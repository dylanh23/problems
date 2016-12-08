import java.util.*;

/**
 * Created by D on 10/11/2016.
 */
public class converstationlog {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int amount = Integer.parseInt(sc.nextLine());
        ArrayList<wordData> words = new ArrayList<>();
        ArrayList<String> allUsers = new ArrayList<>();
        for (int messageCount = 0; messageCount < amount; messageCount++) {
            String[] input = sc.nextLine().split(" ");
            String userName = input[0];
            for (int i = 1; i < input.length; i++) {
                boolean contains = false;
                for (wordData wd : words) {
                    if (wd.word.equals(input[i])) {
                        wd.count += 1;
                        if (!wd.users.contains(userName)) {
                            wd.users.add(userName);
                            if (!allUsers.contains(userName))
                                allUsers.add(userName);
                        }
                        contains = true;
                        break;
                    }
                }
                if (!contains) {
                    words.add(new wordData(userName, input[i]));
                    if (!allUsers.contains(userName))
                        allUsers.add(userName);
                }
            }
        }
        for (Iterator<wordData> iterator = words.iterator(); iterator.hasNext(); ) {
            wordData wd = iterator.next();
            if (wd.users.size() != allUsers.size())
                iterator.remove();
        }
        if (words.size() > 0) {
            words = bubbleSort(words);
            for (wordData wd : words)
                System.out.println(wd.word);
        } else {
            System.out.println("ALL CLEAR");
        }
    }

    static ArrayList<wordData> bubbleSort(ArrayList<wordData> words) {
        boolean swapped = true;
        int j = 0;
        wordData tmp;
        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < words.size() - j; i++) {
                if (words.get(i).count < words.get(i + 1).count) {
                    tmp = words.get(i);
                    words.set(i, words.get(i + 1));
                    words.set(i + 1, tmp);
                    swapped = true;
                }
            }
        }
        return words;
    }

    static class wordData {
        String word;
        ArrayList<String> users = new ArrayList<>();
        int count;

        wordData(String user, String word) {
            users.add(user);
            this.word = word;
            this.count = 1;
        }
    }
}
