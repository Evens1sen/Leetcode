package dynamic;

import java.util.Arrays;

public class LC322CoinChange {

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));
    }

    // f(n) = min(f(n - coin), f(n))
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1]; // The min number of coins sum to amount i
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 0; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

}
