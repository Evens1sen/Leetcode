package binarySearch;

import java.util.Arrays;

public class LC34SearchRange {
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] result = searchRange(nums, target);
        System.out.println(Arrays.toString(result));
    }

    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }

        int left = searchLeftBound(nums, target);
        int right = searchLeftBound(nums, target + 1) - 1;
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
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] >= target) {
                right = mid;
            }
        }

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
