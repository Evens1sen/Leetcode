package dynamic;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    Description:
    There is an array, and we can choose numbers from it
    If we choose nums[i], we cannot choose nums[i-1] and nums[i+1]
    Find the maximum sum of the numbers chosen
 */
public class CitadelProcessExecution {

    public static long getMaximumPower(List<Integer> power) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (Integer p : power) {
            freq.put(p, freq.getOrDefault(p, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> lst = freq.entrySet().stream()
                .sorted(Comparator.comparingInt(Map.Entry::getKey)).toList();

        int n = lst.size();
        long[][] dp = new long[n][2];
        dp[0][1] = (long) lst.get(0).getKey() * lst.get(0).getValue();
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][0]);
            if (lst.get(i - 1).getKey() == lst.get(i).getKey() - 1) {
                dp[i][1] = dp[i - 1][0] + (long) lst.get(i).getKey() * lst.get(i).getValue();
            } else {
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0]) + (long) lst.get(i).getKey() * lst.get(i).getValue();
            }
        }

        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }
}
