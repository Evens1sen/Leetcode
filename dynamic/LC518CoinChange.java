package dynamic;

public class LC518CoinChange {

    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i - 1] < 0) {
                    // Pay attention when amount < 0
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // Complete knapsack problem:
                    // Coins are not limited, so dp[i][j-coins[i-1]], not dp[i-1][j-coins[i-1]]
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }

        return dp[n][amount];
    }
}
