package dynamic;

import java.util.Arrays;

public class LC322CoinChange {

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));
    }


    // Be aware that this is not a knapsack problem, because we need to find the minimal value
    public static int coinChange(int[] coins, int amount) {
        // The minimal number of coins sum to amount i
        // dp[i] = min(dp[i-coins[j]]) + 1 for j < i
        int[] dp = new int[amount + 1];

        // We need to mark a flag for the situation that cannot compose amount
        // Since we want to find the minimum value of dp[i]
        // We set the flag as amount + 1
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 0; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                // Avoid index out of bound
                if (i - coins[j] >= 0) {
                    // Just to find the minimum dp[i] and update it
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        // To check whether we can compose the given amount
        return dp[amount] > amount ? -1 : dp[amount];
    }

}
