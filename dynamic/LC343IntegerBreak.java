package dynamic;

import java.util.HashMap;
import java.util.Map;

public class LC343IntegerBreak {

    public int integerBreak(int n) {
        if (n <= 2) {
            return 1;
        }

        // dp[i]: The max product of integer break for i
        // For integer i, we can split it into j and (i - j)
        // Then the answer is max(j*(i - j), j*dp[i-j])
        // We need to find the max for 1 < j < i
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 2; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }

        return dp[n];
    }

    Map<Integer, Integer> memo = new HashMap<>();

    public int memoSolution(int n) {
        if (n <= 2) {
            return 1;
        }

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        int max = 0;
        for (int i = 1; i < n; i++) {
            max = Math.max(max, Math.max(i * (n - i), i * memoSolution(n - i)));
        }

        memo.put(n, max);
        return max;
    }
}
