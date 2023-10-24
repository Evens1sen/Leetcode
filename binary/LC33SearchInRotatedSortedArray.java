package binary;

public class LC33SearchInRotatedSortedArray {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5};
        int target = 3;
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (!check(nums, target, nums[mid])) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        if (left == nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }

    // Check x is on the right side of target (Inclusive)
    public static boolean check(int[] nums, int target, int x) {
        if (target >= nums[0]) { // target before min value or not rotated
            if (nums[nums.length - 1] > nums[0]) { // Check whether rotated
                return x >= target;
            }
            return x >= target || x <= nums[nums.length - 1];
        } else { // target after the min value
            return x >= target && x <= nums[nums.length - 1];
        }
    }
}
