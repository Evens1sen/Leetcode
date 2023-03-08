package dynamic;

public class LC53MaximumSubarray {

    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        // dp[i]: The maximum subarray sum ends at i
        // The key is that if we define dp like this
        // We must use nums[i] in iteration
        // So dp[i] = max(dp[i-1] + nums[i], nums[i])
        int max = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }

        return max;
    }

}
