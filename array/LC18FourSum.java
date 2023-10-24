package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC18FourSum {

    public static void main(String[] args) {
        int[] nums = {1000000000, 1000000000, 1000000000, 1000000000};
        int target = -294967296;
        System.out.println(fourSum(nums, target));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                long t = (long) target - nums[i] - nums[j];
                int k = j + 1, l = nums.length - 1;
                while (k < l) {
                    if (nums[k] + nums[l] > t) {
                        l--;
                    } else if (nums[k] + nums[l] < t) {
                        k++;
                    } else if (nums[k] + nums[l] == t) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;
                        while (k < l && nums[k] == nums[k - 1]) {
                            k++;
                        }
                        while (k < l && nums[l] == nums[l + 1]) {
                            l--;
                        }
                    }
                }
            }
        }
        return res;
    }
}
