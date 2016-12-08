import java.util.*;

public class topsecret {
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\\n");
        while (sc.hasNext()) {
            String[] input = sc.next().split("\\|");
            List<Integer> code = new ArrayList<>();
            for (int i = 0; i < input[1].toCharArray().length; i++) {
                int charCode = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(input[1].charAt(i));
                code.add(charCode);
            }
            char[] newcode = new char[input[0].toCharArray().length];
            int codeCounter = 0;
            for (int i = 0; i < input[0].toCharArray().length; i++) {
                if (Character.isLetter(input[0].charAt(i))) {
                    int spot = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(Character.toUpperCase(input[0].charAt(i))) + code.get(codeCounter);
                    if (spot > 25) {
                        spot -= 26;
                    }
                    char c = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(spot);
                    if (Character.isUpperCase(input[0].charAt(i))) {
                        newcode[i] = c;
                    } else {
                        newcode[i] = Character.toLowerCase(c);
                    }
                    codeCounter += 1;
                    if (codeCounter == code.size()) {
                        codeCounter = 0;
                    }
                } else {
                    newcode[i] = input[0].charAt(i);
                }
            }
            System.out.print(newcode);
        }
    }
}