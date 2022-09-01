package binarySearch;

public class LC153FindMin {

    public static void main(String[] args) {
        int[] nums = {11, 13, 15, 17};
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= nums[0]) {
                left = mid + 1;
            } else if (nums[mid] < nums[0]) {
                right = mid;
            }
        }

        return left >= nums.length ? nums[0] : nums[left];
    }
}
