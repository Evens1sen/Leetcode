package dynamic;

public class LC486PredictTheWinner {

    public boolean PredictTheWinner(int[] nums) {
        return score(nums, 0, nums.length - 1, 1) > 0;
    }

    // Recursive solution
    // The function score() stands for the total evaluation for the current game
    // Positive for the first player, and negative for the second player
    // This definition is to simplify the score for first and second player
    // Otherwise, we may need something like first(l, r) and second(l, r)
    public int score(int[] nums, int left, int right, int turn) {
        if (left == right) {
            return nums[left] * turn;
        }

        int scoreLeft = nums[left] * turn + score(nums, left + 1, right, -turn);
        int scoreRight = nums[right] * turn + score(nums, left, right - 1, -turn);
        if (turn == 1) {
            return Math.max(scoreLeft, scoreRight);
        } else {
            return Math.min(scoreLeft, scoreRight);
        }
    }

    // dp[i][j][0]: The score for stones[i:j], current player is first player
    // dp[i][j][1]: The score for stones[i:j], current player is second player
    public boolean dpScore(int[] nums) {
        int n = nums.length;
        int[][][] dp = new int[n][n][2];
        for (int i = 0; i < n; i++) {
            dp[i][i][0] = nums[i];
            dp[i][i][1] = -nums[i];
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                int scoreLeft, scoreRight;
                scoreLeft = nums[i] + dp[i + 1][j][1];
                scoreRight = nums[j] + dp[i][j - 1][1];
                dp[i][j][0] = Math.max(scoreLeft, scoreRight);

                scoreLeft = -nums[i] + dp[i + 1][j][0];
                scoreRight = -nums[j] + dp[i][j - 1][0];
                dp[i][j][1] = Math.min(scoreLeft, scoreRight);
            }
        }

        return dp[0][n - 1][0] >= 0;
    }

    // The evaluation for a certain player
    // The definition is the relative score
    public int simpleScore(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }

        int scoreLeft = nums[left] - simpleScore(nums, left + 1, right);
        int scoreRight = nums[right] - simpleScore(nums, left, right - 1);
        return Math.max(scoreLeft, scoreRight);
    }

    public boolean simpleDp(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                int scoreLeft = nums[i] - dp[i + 1][j];
                int scoreRight = nums[j] - dp[i][j - 1];
                dp[i][j] = Math.max(scoreLeft, scoreRight);
            }
        }

        return dp[0][n - 1] >= 0;
    }

}
