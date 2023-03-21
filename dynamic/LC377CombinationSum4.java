package dynamic;

public class LC377CombinationSum4 {

    public int combinationSum4(int[] nums, int target) {
        // dp[i] = sum(dp[i - nums[j]]) for all nums[j] <= i
        if (nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < n; j++) {
                if (nums[j] <= i) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }

        return dp[target];
    }
}
