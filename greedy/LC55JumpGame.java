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

    // O(n^2) solution, not optimal
    public boolean dpSolution(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = dp[i] || (dp[i - j] && nums[i - j] >= j);
            }
        }

        return dp[n - 1];
    }
}
