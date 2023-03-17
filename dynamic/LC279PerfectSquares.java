package dynamic;

public class LC279PerfectSquares {

    public int numSquares(int n) {
        return dpSolution(n);
    }

    public int dpSolution(int n) {
        // dp[i] = min(dp[i - j^2]) + 1 for j^2 < i
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int minn = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                minn = Math.min(minn, dp[i - j * j]);
            }
            dp[i] = minn + 1;
        }

        return dp[n];
    }
}
