package binary;

public class LC410SplitArrayLargestSum {

    public static void main(String[] args) {
        int[] nums = {7, 2, 5, 10, 8};
        int k = 2;
        System.out.println(splitArray(nums, k));
    }

    public static int splitArray(int[] nums, int k) {
        int left = 0;
        int right = 0;
        for (int num : nums) {
            left = Math.max(left, num);
            right += num;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(nums, k, mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    // Can split nums into at least k subarray with sum x
    public static boolean check(int[] nums, int k, int x) {
        int sum = 0;
        int cnt = 1;
        for (int num : nums) {
            if (sum + num > x) {
                cnt++;
                sum = num;
            } else {
                sum += num;
            }
        }
        return cnt > k;
    }
}
