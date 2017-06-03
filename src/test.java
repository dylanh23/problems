import java.util.*;

/**
 * Created by dhare on 6/1/2017.
 */
public class test {
    static public class Solution {
        int MOD = 1000000;
        List<String> wordDict;
        String s;

//        public boolean wordBreak(String s, List<String> wordDict) {
//            this.wordDict = wordDict;
//            this.s = s;
//            int sHash = getHash(s);
//            int[] hashes = new int[wordDict.size()];
//            for (int i = 0; i < hashes.length; i++) {
//                hashes[i] = getHash(wordDict.get(i));
//            }
//        }
//
//        boolean dp(int p, ArrayList<Integer> ints) {
//            if (p == wordDict.size()) {
//                //TODO: get hash based on position
//                int hash = ints.get(0);
//                int length =
//                for (int i = 0; i <)
//                if () {
//                    return true;
//                } else {
//                    return false;
//                }
//            } else {
//                for (int i = 0; i <= ints.size(); i++) {
//                    ArrayList<Integer> clone = (ArrayList<Integer>) ints.clone();
//                    clone.add(i, getHash(wordDict.get(i)));
//                    if (dp(p + 1, clone)) {
//                        return true;
//                    }
//                }
//                return false;
//            }
//        }
//
//        boolean dp2(int p, boolean[] ) {
//            if (p == wordDict.size()) {
//                //TODO: get hash based on position
//                int hash = ints.get(0);
//                int length =
//                for (int i = 0; i <)
//                    if () {
//                        return true;
//                    } else {
//                        return false;
//                    }
//            } else {
//                for (int i = 0; i <= ints.size(); i++) {
//                    ArrayList<Integer> clone = (ArrayList<Integer>) ints.clone();
//                    clone.add(i, getHash(wordDict.get(i)));
//                    if (dp(p + 1, clone)) {
//                        return true;
//                    }
//                }
//                return false;
//            }
//        }

        public boolean wordBreak(String s, ArrayList<String> dict) {

            boolean[] f = new boolean[s.length() + 1];

            f[0] = true;


        /* First DP
        for(int i = 1; i <= s.length(); i++){
            for(String str: dict){
                if(str.length() <= i){
                    if(f[i - str.length()]){
                        if(s.substring(i-str.length(), i).equals(str)){
                            f[i] = true;
                            break;
                        }
                    }
                }
            }
        }*/

            //Second DP
            for(int i=1; i <= s.length(); i++){
                for(int j=0; j < i; j++){
                    if(f[j] && dict.contains(s.substring(j, i))){
                        f[i] = true;
                        break;
                    }
                }
            }

            return f[s.length()];
        }
    }

//        public int getHash(String s) {
//            int hash = 7;
//            char[] chars = s.toCharArray();
//            for (int i = 0; i < s.length(); i++) {
//                hash += Math.pow(2, i) * (chars[i] - 96);
//                hash %= MOD;
//            }
//            return hash;
//        }

    public static void main(String[] args) {
        Solution s = new Solution();
        ArrayList<String> strings = new ArrayList<>();
        strings.add("jk");
        strings.add("a");
        strings.add("bcd");
        s.wordBreak("abcdjk" , strings);
    }
}
