package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC792NumberOfMatchingSubsequences {

    public static void main(String[] args) {
        String s = "abcde";
        String[] words = {"a", "bb", "acd", "ace"};
        System.out.println(numMatchingSubseq(s, words));
    }

    static List<Integer>[] indexList = new ArrayList[26];

    public static int numMatchingSubseq(String s, String[] words) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (indexList[ch - 'a'] == null) {
                indexList[ch - 'a'] = new ArrayList<>();
            }
            indexList[ch - 'a'].add(i);
        }

        int res = 0;
        for (String word : words) {
            if (match(word, s)) {
                res++;
            }
        }

        return res;
    }

    // Binary search implementation
    public static boolean match(String s, String t) {
        return true;
    }
}
