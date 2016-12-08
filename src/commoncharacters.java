import java.util.*;

public class commoncharacters {
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\\n");
        sc.next();
        while (sc.hasNext()) {
            String[] input = sc.next().split(" ");
            ArrayList<String[]> stringArrays = new ArrayList<>();
            for (int i = 0; i < input.length; i++) {
                stringArrays.add(input[i].split(""));
            }
            ArrayList<String> commonCharacter = new ArrayList<>();
            for (int i = 0; i < stringArrays.get(0).length; i++) {
                String character = stringArrays.get(0)[i];
                for (int x = 1; x < stringArrays.size(); x++) {
                    if (!Arrays.asList(stringArrays.get(x)).contains(character)) {
                        character = " ";
                    }
                }
                if (character != " " && !commonCharacter.contains(character)) {
                    commonCharacter.add(character);
                }
            }
            Collections.sort(commonCharacter);
            for (String s : commonCharacter) {
                System.out.print(s);
            }
            if (sc.hasNext()) {
                System.out.println("");
            }
        }
    }
}
