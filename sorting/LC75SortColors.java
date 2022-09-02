package sorting;

import java.util.Arrays;

public class LC75SortColors {

    public static void main(String[] args) {
        int[] nums = {2, 0, 1};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sortColors(int[] nums) {
        int zero = 0;
        int two = nums.length - 1;
        int i = 0;
        while (i <= two) {
            if (nums[i] == 0) {
                swap(nums, i, zero);
                zero++;
                i++;
            } else if (nums[i] == 2) {
                swap(nums, i, two);
                two--;
            } else {
                i++;
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
