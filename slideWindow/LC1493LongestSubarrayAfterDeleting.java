package slideWindow;

public class LC1493LongestSubarrayAfterDeleting {

    public static void main(String[] args) {
        int[] nums = {0, 1, 1, 1, 0, 1, 1, 0, 1};
        System.out.println(longestSubarray(nums));
    }

    public static int longestSubarray(int[] nums) {
        boolean flag = true;
        for (Integer num : nums) {
            if (num != 1) {
                flag = false;
                break;
            }
        }
        if (flag) {
            return nums.length - 1;
        }


        int res = 0;
        int left = 0, right = 0;
        int deleted = 0;
        while (right < nums.length) {
            if (nums[right] == 1) {
                right++;
            } else {
                if (deleted == 0) {
                    deleted++;
                    right++;
                } else {
                    while (nums[left] != 0) {
                        left++;
                    }
                    left++;
                    deleted--;
                }
            }
            res = Math.max(res, right - left - deleted);
        }
        return res;
    }
}
