package sorting;

import java.util.Arrays;

public class QuickSort {
    /*
        Inline quicksort in python syntax:
        qsort = lambda lst : qsort([for num in lst[1:] if num <= lst[0]]) + [lst[0]] + qsort([for num in lst[1:] if num > lst[0]]) if len(lst) > 1 else lst
    */

    public static void main(String[] args) {
        int[] nums = {4, 5, 5, 1, 4, 2, 6, 2, 2, 2, 4, 3, 6};
        quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    public static void quickSort(int[] nums, int left, int right) {
        if (right <= left) {
            return;
        }

        int pivot = partition(nums, left, right);
        quickSort(nums, left, pivot - 1);
        quickSort(nums, pivot + 1, right);
    }


    public static int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int i = right;
        for (int j = right; j > left; j--) {
            if (nums[j] >= pivot) {
                swap(nums, i, j);
                i--;
            }
        }
        swap(nums, i, left);
        return i;
    }

    // Used for array with many duplicate elements
    public static void triplePartition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int lt = left;
        int gt = right;
        int i = left;
        while (i <= gt) {
            if (nums[i] < pivot) {
                swap(nums, i, lt);
                lt++;
                i++;
            } else if (nums[i] > pivot) {
                swap(nums, i, gt);
                gt--;
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
