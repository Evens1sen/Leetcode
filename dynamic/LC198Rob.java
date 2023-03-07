package dynamic;

public class LC198Rob {

    public int rob(int[] nums) {
        // Base cases: Used for preventing array index out of bound
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }

        // The definition of the state transfer function (The dp array):
        // dp[i] should be the state terminates at i
        // and consider the nums[i]
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        return dp[n - 1];
    }
}
