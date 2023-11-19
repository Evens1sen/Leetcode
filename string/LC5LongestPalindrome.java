package string;

import java.util.Map;

public class LC5LongestPalindrome {

    public static void main(String[] args) {
        String s = "aaaa"; // "bab"
        System.out.println(dpSolution(s));
    }

    public static String dpSolution(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        String res = s.substring(0, 1);
        for (int i = n; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                boolean matched = s.charAt(i) == s.charAt(j);
                if (j == i + 1) {
                    dp[i][j] = matched;
                } else {
                    dp[i][j] = dp[i + 1][j - 1] && matched;
                }

                if (dp[i][j] && s.substring(i, j + 1).length() > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
        }

        return res;
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String odd = expand(s, i, i);
            String even = expand(s, i, i + 1);
            if (odd.length() > res.length()) {
                res = odd;
            }
            if (even.length() > res.length()) {
                res = even;
            }
        }

        return res;
    }

    public static String expand(String s, int left, int right) {
        while (left >= 0 && right <= s.length() - 1
                && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return s.substring(left + 1, right);
    }
}
