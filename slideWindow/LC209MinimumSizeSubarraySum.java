package slideWindow;

public class LC209MinimumSizeSubarraySum {

    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(target, nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        while (right < nums.length) {
            if (sum < target) {
                sum += nums[right];
                right++;
            }

            while (sum >= target) {
                res = Math.min(res, right - left);
                sum -= nums[left];
                left++;
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
