package dynamic;

public class LC188MaxProfitK {

    public static void main(String[] args) {
        int k = 2;
        int[] prices = {3, 2, 6, 5, 0, 3};
        System.out.println(maxProfit(k, prices));
    }

    public static int maxProfit(int k, int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        int[][][] dp = new int[n + 1][k + 1][2];
        for (int i = 0; i <= k; i++) {
            dp[0][i][1] = Integer.MIN_VALUE;
        }
        for (int i = 0; i <= n; i++) {
            dp[i][0][1] = Integer.MIN_VALUE;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i - 1]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i - 1]);
            }
        }

        return dp[n][k][0];
    }

}
