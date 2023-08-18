package dynamic;

public class LC918MaxCircularSubarray {

    public static void main(String[] args) {
        int[] nums = {3, -1, 2, -1};
        System.out.println(maxSubarraySumCircular(nums));
    }

    public static int maxSubarraySumCircular(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int max = nums[0];
        int dpMax = nums[0];
        int min = nums[0];
        int dpMin = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dpMax = Math.max(dpMax + nums[i], nums[i]);
            max = Math.max(max, dpMax);
            dpMin = Math.min(dpMin + nums[i], nums[i]);
            min = Math.min(min, dpMin);
            sum += nums[i];
        }

        if (max < 0) {
            return max;
        } else {
            return Math.max(max, sum - min);
        }
    }
}
