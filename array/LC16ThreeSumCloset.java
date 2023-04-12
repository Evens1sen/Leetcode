package array;

import java.util.Arrays;

public class LC16ThreeSumCloset {

    public static void main(String[] args) {
        int[] nums = {0, 1, 2};
        int target = 3;
        System.out.println(threeSumClosest(nums, target));
    }

    public static int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);

        int minDiff = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1, right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                int diff = Math.abs(sum - target);
                if (diff < minDiff) {
                    minDiff = diff;
                    res = sum;
                }
                if (sum < target) {
                    left++;
                } else { // To ensure the loop can exit
                    right--;
                }
            }
        }

        return res;
    }

}