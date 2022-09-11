package array;

import java.util.Arrays;

public class LC643FindMaxAverage {

    public static void main(String[] args) {
        int[] nums = {0, 4, 0, 3, 2};
        int k = 1;
        System.out.println(findMaxAverage(nums, k));
    }

    public static double findMaxAverage(int[] nums, int k) {
        if (nums.length <= k) {
            return Arrays.stream(nums).average().getAsDouble();
        }

        int maxSum = 0;
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        maxSum = sum;

        for (int i = 1; i <= nums.length - k; i++) {
            sum = sum - nums[i - 1] + nums[i + k - 1];
            maxSum = Math.max(maxSum, sum);
        }

        return (double) maxSum / k;
    }
}
