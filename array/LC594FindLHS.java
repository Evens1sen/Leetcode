package array;

import java.util.Arrays;
import java.util.HashMap;

public class LC594FindLHS {

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 2, 5, 2, 3, 7};
        System.out.println(findLHS(nums));
    }

    public static int findLHS(int[] nums) {
        return hashSolution(nums);
    }

    public static int hashSolution(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }

        int maxSize = 0;
        for (int num : nums) {
            if (hashMap.containsKey(num + 1)){
                maxSize = Math.max(maxSize, hashMap.get(num) + hashMap.get(num + 1));
            }
        }

        return maxSize;
    }

    public static int slideWindowSolution(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
        int maxSize = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int j = i + 1;
            while (j < nums.length && nums[j] == nums[i]) {
                j++;
            }
            if (j < nums.length && nums[j] == nums[i] + 1) {
                while (j < nums.length && nums[j] == nums[i] + 1) {
                    j++;
                }
                maxSize = Math.max(maxSize, j - i);
            }
        }

        return maxSize;
    }
}
