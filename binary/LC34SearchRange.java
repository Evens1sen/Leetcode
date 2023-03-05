package binary;

import java.util.Arrays;

/* Binary search:
   The problem is that in a sorted sequence [a1, a2, a3, .., ak, ... an-1, an]
   there is some function check(ak) that is true for i < k and false for i > k
   In other word, k is the critical point of the series
*/

public class LC34SearchRange {
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 9;
        System.out.println(searchRightBound(nums, target));
//        int[] result = searchRange(nums, target);
//        System.out.println(Arrays.toString(result));
    }

    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }

        int left = searchLeftBound(nums, target);
        int right = searchLeftBound(nums, target + 1) - 1;
        // If target not exists in the nums
        // left is the insert position and may be overflow
        if (left == nums.length || nums[left] != target) {
            return new int[]{-1, -1};
        } else {
            return new int[]{left, right};
        }
    }

    // Ignore index out of bound and missing
    public static int searchLeftBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        // Search interval is [left, right)
        // Terminate when left == right
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] >= target) {
                right = mid;
            }
        }

        // left is the insert position, need to be verified by the caller
        return left;
    }

    public static int searchRightBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }

        return left - 1;
    }

    // Standard version for search the left bound
    public static int searchLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] >= target) {
                right = mid;
            }
        }

        if (left == nums.length) {
            return -1;
        }
        return nums[left] == target ? left : -1;
    }

    // Standard version for search the right bound
    public static int searchRight(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }

        if (left == 0) {
            return -1;
        }
        return nums[left - 1] == target ? left - 1 : -1;
    }
}
