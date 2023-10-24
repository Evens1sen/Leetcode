package dynamic;

import java.util.Arrays;
import java.util.List;

/*
    Given an array nums and a integer k
    Split this array into k arrays and minimize the max value of each subarray
    Case1: nums = [20, 40, 60, 80, 50], k = 4 => 190
    Case2: nums = [123, 789, 102, 567], k = 2 => 912
 */
public class AmgenTaskSchedule {

    public static void main(String[] args) {
        int[] nums = {20, 40, 60, 80, 50};
        int n = 4;
        System.out.println(minimumEffort(nums, n));
    }

    // dp[i][j] = min(dp[i-k][j-1] + max(nums[i-k+1:i]))
    public static int minimumEffort(int[] nums, int n) {
        int m = nums.length;
        int[][] dp = new int[m + 1][n + 1];

        // Set illegal states to Integer.MAX_VALUE since later we will find min
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        dp[0][0] = 0; // Corresponding to dp[i][1], always max value later
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int max = 0;
                for (int k = 1; k <= i; k++) {
                    max = Math.max(max, nums[i - k]);
                    // In case of overflow
                    if (dp[i - k][j - 1] == Integer.MAX_VALUE) {
                        continue;
                    }
                    dp[i][j] = Math.min(dp[i][j], dp[i - k][j - 1] + max);
                }
            }
        }

        return dp[m][n];
    }
}
