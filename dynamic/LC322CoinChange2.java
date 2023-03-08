package dynamic;

import java.util.Arrays;

public class LC322CoinChange2 {

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));
    }


    // Be aware that this is not a knapsack problem, because we need to find the minimal value
    public static int coinChange(int[] coins, int amount) {
        // The minimal number of coins sum to amount i
        // dp[i] = min(dp[i-coins[j]]) + 1
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 0; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

}
