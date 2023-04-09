package dynamic;

public class LC10RegularExpressionMatching {

    // dp[i][j]: s[0:i] matches p[0:j]
    // if p[j] != '*'
    //      dp[i][j] = dp[i-1][j-1] if s[i] == p[j] else false
    // if p[j] == '*'
    //      dp[i][j] = dp[i][j-2] if s[i] != p[j-1] else dp[i-1][j] || dp[i][j-2]
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) != '*') {
                    if (matches(s, p, i, j)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    dp[i][j] = dp[i][j - 2]; // Cannot match
                    if (matches(s, p, i, j - 1)) {
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j];
                    }
                }
            }
        }

        return dp[m][n];
    }

    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}
