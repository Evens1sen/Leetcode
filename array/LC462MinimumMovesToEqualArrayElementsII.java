package array;

import java.util.Arrays;

public class LC462MinimumMovesToEqualArrayElementsII {

    // Select the median as the target and move
    // We can sort: O(nlogn)
    // Or use quick select: O(n)
    public int minMoves2(int[] nums) {
        return sortSolution(nums);
    }

    public int sortSolution(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        int i = 0, j = nums.length - 1;
        while (i < j) {
            ans += nums[j] - nums[i];
            i++;
            j--;
        }

        return ans;
    }
}
