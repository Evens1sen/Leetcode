package dynamic;

public class LC518CoinChange2 {

    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];

        // dp[0][...] = 0
        // dp[...][0] = 1
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        // dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j]
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i - 1] >= 0) {
                    // Pay attention when amount < 0
                    // Avoid index out of bound
                    dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
                } else {
                    // Complete knapsack problem:
                    // Coins are not limited, so dp[i][j-coins[i-1]], not dp[i-1][j-coins[i-1]]
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][amount];
    }

    // Follow up: How to calculate the combination ways
    // Using a matrix G[i][j]: Choose which term at dp[i][j]

}
