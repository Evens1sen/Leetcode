package dynamic;

public class LC115DistinctSubsequences {

    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }

        // dp[i][j] = dp[i-1][j-1] + dp[i-1][j] if s[i] == t[j]
        //          = dp[i-1][j-1] if s[i] != t[j]
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    // Using s[i] to match t[i]: dp[i-1][j-1]
                    // Not using s[i]: dp[i-1][j]
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[m][n];
    }
}
