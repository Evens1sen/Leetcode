package dynamic;

public class LC494TargetSum {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(findTargetSumWays(nums, target));
    }

    public static int findTargetSumWays(int[] nums, int s) {
        int shift = 1000;
        int[][] dp = new int[nums.length + 1][2 * shift + 1];
        dp[0][shift] = 1;

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j < 2 * shift + 1; j++) {
                if (j - nums[i - 1] >= 0) {
                    dp[i][j] += dp[i - 1][j - nums[i - 1]];
                }
                if (j + nums[i - 1] <= 2 * shift) {
                    dp[i][j] += dp[i - 1][j + nums[i - 1]];
                }
            }
        }

        return dp[nums.length][s + shift];
    }
}
