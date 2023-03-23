package array;

import java.util.HashMap;
import java.util.Map;

public class LC4544SumII {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> ABSum = new HashMap<>();
        for (int i : A) {
            for (int j : B) {
                int pairSum = i + j;
                ABSum.put(pairSum, ABSum.getOrDefault(pairSum, 0) + 1);
            }
        }

        int ans = 0;
        for (int k : C) {
            for (int l : D) {
                int target = -(k + l);
                if (ABSum.containsKey(target)) {
                    ans += ABSum.get(target);
                }
            }
        }

        return ans;
    }
}
