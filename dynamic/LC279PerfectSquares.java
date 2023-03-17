package dynamic;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

public class LC279PerfectSquares {

    public int numSquares(int n) {
        return dpSolution(n);
    }

    public int dpSolution(int n) {
        // dp[i] = min(dp[i - j^2]) + 1 for j^2 < i
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int minn = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                minn = Math.min(minn, dp[i - j * j]);
            }
            dp[i] = minn + 1;
        }

        return dp[n];
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
