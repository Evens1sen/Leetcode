package dynamic;

public class LC213HouseRobber2 {

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }

        return Math.max(robRange(nums, 0, n - 2), robRange(nums, 1, n - 1));
    }

    public int robRange(int[] nums, int left, int right) {
        if (left > right) {
            return 0;
        }

        int n = right - left + 1;
        int[] dp = new int[n];
        dp[0] = nums[left];
        dp[1] = Math.max(nums[left], nums[left + 1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[left + i], dp[i - 1]);
        }

        return dp[n - 1];
    }
}
