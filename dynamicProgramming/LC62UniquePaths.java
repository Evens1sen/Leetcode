package dynamicProgramming;

public class LC62UniquePaths {

    // The rolling array to optimize the space
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        for (int j = 0; j < n; j++) {
            dp[j] = j;
        }

        for (int i = 1; i < m; i++) {
            dp[0] = 1;
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j - 1] + dp[j];
            }
        }

        return dp[n - 1];
    }

    // The standard two dimension dynamic programming
//    public int uniquePaths(int m, int n) {
//        int[][] dp = new int[m][n];
//        for (int i = 0; i < m; i++) {
//            dp[i][0] = i;
//        }
//        for (int j = 0; j < n; j++) {
//            dp[0][j] = j;
//        }
//
//        for (int i = 1; i < m; i++) {
//            for (int j = 1; j < n; j++) {
//                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
//            }
//        }
//
//        return dp[m - 1][n - 1];
//    }
}
