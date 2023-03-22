package dynamic;

import java.util.HashMap;
import java.util.Map;

public class LC91DecodeWays {

    public static void main(String[] args) {
        String s = "226";
        System.out.println(numDecodings(s));
    }

    static Map<String, Integer> memo = new HashMap<>();

    public static int numDecodings(String s) {
        return dpSolution(s);
    }

    public static int dpSolution(String s) {
        int n = s.length();
        int[] dp = new int[n + 1]; // dp[i]: decoding ways for s[i:]
        dp[n] = 1;
        dp[n - 1] = (s.charAt(n - 1) == '0' ? 0 : 1);
        for (int i = n - 2; i >= 0; i--) {
            char first = s.charAt(i);
            char second = s.charAt(i + 1);
            if (first != '0') {
                dp[i] += dp[i + 1];
            }

            if (first == '1' || (first == '2' && '0' <= second && second <= '6')) {
                dp[i] += dp[i + 2];
            }
        }

        return dp[0];
    }

    public static int memoSolution(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        int ans = memoSolution(s.substring(1)); // Decode using s[0] + s[1:]
        char first = s.charAt(0);
        char second = s.charAt(1);
        if (first == '1' || (first == '2' && '0' <= second && second <= '6')) {
            ans += memoSolution(s.substring(2)); // Decode using s[0:2] + s[2:]
        }

        memo.put(s, ans);
        return ans;
    }
}
