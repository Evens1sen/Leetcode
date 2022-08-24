package array;

import java.util.Arrays;

public class LC283MoveZeros {

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }

    // [0, 1, 0, 3, 12] -> [1, 3, 12, 0, 0]
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
}
