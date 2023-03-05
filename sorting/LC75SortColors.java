package sorting;

import java.util.Arrays;

public class LC75SortColors {

    public static void main(String[] args) {
        int[] nums = {2, 0, 1};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    // Pay attention to details
    public static void sortColors(int[] nums) {
        int zero = -1; // The right bound for zeros
        int two = nums.length; // The left bound for twos
        int i = 0;
        while (i < two) {
            if (nums[i] == 0) {
                zero++;
                swap(nums, i, zero); // The new nums[i] must be 1
                i++;
            } else if (nums[i] == 2) {
                two--;
                swap(nums, i, two); // The new nums[i] may be 0 or 1
            } else {
                i++; // nums[i] == 1
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
