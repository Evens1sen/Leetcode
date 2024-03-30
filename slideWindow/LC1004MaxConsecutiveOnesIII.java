package slideWindow;

public class LC1004MaxConsecutiveOnesIII {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;
        System.out.println(longestOnes(nums, k));
    }

    public static int longestOnes(int[] nums, int k) {
        int res = 0;
        int left = 0, right = 0;
        int zeros = 0;
        while (left <= right && right < nums.length) {
            if (nums[right] == 1) {
                right++;
            } else {
                if (zeros < k) {
                    zeros++;
                    right++;
                } else {
                    if (nums[left] == 0) {
                        zeros--;
                    }
                    left++;
                }
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
