package greedy;

import java.util.Arrays;

public class LC45JumpGame2 {

    // O(n) solution
    public int jump(int[] nums) {
        int n = nums.length;
        int end = 0, farthest = 0;
        int jumps = 0;
        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(nums[i] + i, farthest);
            if (end == i) {
                jumps++;
                end = farthest;
            }
        }
        return jumps;
    }

    // dp[i] = min(dp[j]) + 1 for j + nums[j] >= i
    // O(n^2) solution
    public int jumpDp(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }

        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (j + nums[j] >= i) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }

        return dp[n - 1];
    }
}
