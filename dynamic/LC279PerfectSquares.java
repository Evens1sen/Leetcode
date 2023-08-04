package dynamic;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

public class LC279PerfectSquares {

    public int numSquares(int n) {
        return dpSolution(n);
    }

    public int dpSolution(int n) {
        // dp[i] = min(dp[i - j^2]) + 1 for j^2 < i
        int upperBound = (int) Math.sqrt(n);
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 1);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= upperBound; j++) {
                if (j * j <= i) {
                    dp[i] = Math.min(dp[i], dp[i - j*j] + 1);
                }
            }
        }
        return dp[n] == n + 1 ? -1 : dp[n];
    }

    public int bfsSolution(int n) {
        Deque<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>(); // To reduce calculation
        queue.add(n);
        visited.add(n);
        int depth = 0;

        while (!queue.isEmpty()) {
            depth++;
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int cur = queue.poll();
                for (int j = 1; j * j <= cur; j++) {
                    int tmp = cur - j * j;
                    if (tmp == 0) {
                        return depth;
                    }

                    if (!visited.contains(tmp)) {
                        queue.offer(tmp);
                        visited.add(tmp);
                    }
                }
            }
        }

        return depth;
    }
}
