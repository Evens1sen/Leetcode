package dynamic;

public class LC518CoinChange2 {

    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[amount + 1][n + 1];
        for (int j = 0; j <= n; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i <= amount; i++) {
            for (int j = 1; j <= n; j++) {
                if (i - coins[j - 1] < 0) {
                    // Pay attention when amount < 0
                    // Avoid index out of bound
                    dp[i][j] = dp[i][j - 1];
                } else {
                    // Complete knapsack problem:
                    // Coins are not limited, so dp[i][j-coins[i-1]], not dp[i-1][j-coins[i-1]]
                    dp[i][j] = dp[i][j - 1] + dp[i - coins[j - 1]][j];
                }
            }
        }

        return dp[amount][n];
    }
}
