package sorting;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 6, 8, 5};
        int[] res = mergeSort(nums);
        System.out.println(Arrays.toString(res));
    }

    public static int[] mergeSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }

        int n = nums.length;
        int half = n / 2;
        int[] left = new int[half];
        int[] right = new int[n - half];
        System.arraycopy(nums, 0, left, 0, half);
        System.arraycopy(nums, half, right, 0, n - half);

        int[] sortedLeft = mergeSort(left);
        int[] sortedRight = mergeSort(right);
        return merge(sortedLeft, sortedRight);
    }

    // arr1 and arr2 are sorted
    // return a new array
    public static int[] merge(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        int[] res = new int[m + n];
        int i = 0, j = 0;
        for (int k = 0; k < m + n; k++) {
            if (i == m) {
                res[k] = arr2[j];
                j++;
            } else if (j == n) {
                res[k] = arr1[i];
                i++;
            } else if (arr1[i] <= arr2[j]) {
                res[k] = arr1[i];
                i++;
            } else {
                res[k] = arr2[j];
                j++;
            }
        }

        return res;
    }
}
