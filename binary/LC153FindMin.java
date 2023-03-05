package binary;

public class LC153FindMin {

    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};
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
