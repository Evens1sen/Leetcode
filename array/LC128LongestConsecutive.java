package array;

import java.util.HashSet;

public class LC128LongestConsecutive {

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
    }

    // Solution1: Sort and slide window with complexity O(nlogn)
    // Solution2: dp (Not practical for negative numbers)
    // Solution3: Hashset with optimization
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        HashSet<Integer> hashSet = new HashSet<>();
        for (int j : nums) {
            hashSet.add(j);
        }

        int maxSize = 1;
        for (int num : hashSet) {
            // Determine whether this is a consecutive sequence
            // Reduce the time complexity from O(n^2) to O(n)
            if (!hashSet.contains(num - 1)) {
                int j = num + 1;
                while (hashSet.contains(j)) {
                    j++;
                }
                maxSize = Math.max(maxSize, j - num);
            }
        }

        return maxSize;
    }
}
