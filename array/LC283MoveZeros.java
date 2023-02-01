package array;

import java.util.Arrays;

public class LC283MoveZeros {

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }

    // More simple solution
    // Override the last array with zeros
    public static void moveZeroes(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                nums[i] = nums[j];
                i++;
            }
        }

        for (int k = i; k < nums.length; k++) {
            nums[k] = 0;
        }
    }

    // [0, 1, 0, 3, 12] -> [1, 3, 12, 0, 0]
    // Double pointer solution
    public void moveZeroesDoublePointers(int[] nums) {
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            if (nums[j] != 0) {
                swap(nums, i, j);
                i++;
            }
            j++;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
