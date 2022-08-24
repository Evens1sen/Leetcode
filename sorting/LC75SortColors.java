package sorting;

import java.util.Arrays;

public class LC75SortColors {

    public static void main(String[] args) {
        int[] nums = {1, 2, 0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sortColors(int[] nums) {
        int zeros = 0;
        int twos = nums.length - 1;
        for (int i = 0; i <= twos; i++) {
            while (nums[i] == 2 && i <= twos) {
                swap(nums, i, twos--);
            }

            if (nums[i] == 0) {
                swap(nums, i, zeros++);
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
