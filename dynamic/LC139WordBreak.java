package dynamic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC139WordBreak {

    public static void main(String[] args) {
        String s = "dogs";
        String[] wordDict = {"dog", "s", "gs"};
        System.out.println(wordBreak(s, List.of(wordDict)));
    }

    // Complete Knapsack Problem
    public static boolean wordBreak(String s, List<String> wordDict) {
        // dp[i] = dp[i - len(words[0])] || dp[i - len(words[1])] || ... || dp[i - len(words[n])]
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        // Foreach substring s[0:i+1] have length i
        // Foreach word in words: need to compare before remove
        // We remove the and get s[0:i-len(word)]
        for (int i = 1; i <= s.length(); i++) {
            for (String word : wordDict) {
                if (i - word.length() >= 0 && s.startsWith(word, i - word.length())) {
                    dp[i] |= dp[i - word.length()];
                }
            }
        }

        return dp[s.length()];

    }
}
