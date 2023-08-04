package greedy;

public class LC55JumpGame {

    // Greedy solution with complexity O(n)
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean canJumpDp(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return true;
        }

        // dp[i]: The maximum index the position can reach
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            if (dp[i - 1] < i) {
                return false;
            }
            dp[i] = Math.max(dp[i - 1], nums[i] + i);
        }
        return dp[n - 2] >= n - 1;
    }
}
