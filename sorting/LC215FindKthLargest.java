package sorting;

import java.util.PriorityQueue;
import java.util.Random;

public class LC215FindKthLargest {

    public static void main(String[] args) {
        int[] nums = {1, 5, 2, 6, 3};
        int k = 4;
        System.out.println(findKthLargest(nums, k));
    }

    public static int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    // A in-place implementation for quickSort
    public static void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivotIndex = randomPartition(nums, left, right);
        quickSort(nums, left, pivotIndex - 1);
        quickSort(nums, pivotIndex + 1, right);
    }

    public static int quickSelect(int[] nums, int left, int right, int index) {
        int partitionIndex = randomPartition(nums, left, right);
        if (partitionIndex == index) {
            return nums[partitionIndex];
        } else if (partitionIndex < index) {
            return quickSelect(nums, partitionIndex + 1, right, index);
        } else {
            return quickSelect(nums, left, partitionIndex - 1, index);
        }
    }

    // The iterative version for the quick select
    // Idea is similar to binary search
    public static int quickSelect(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int index = partition(nums, left, right);
            if (index == k) {
                return nums[index];
            } else if (index < k) {
                left = index + 1;
            } else if (index > k) {
                right = index - 1;
            }
        }
        return nums[left];
    }

    public static int randomPartition(int[] nums, int left, int right) {
        Random random = new Random();
        int pivotIndex = random.nextInt(right - left + 1) + left;
        swap(nums, pivotIndex, right);
        return partition(nums, left, right);
    }

    public static int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left;
        for (int j = left; j < right; j++) {
            if (nums[j] < pivot) {
                swap(nums, i++, j);
            }
        }
        swap(nums, i, right);
        return i;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    // The heap implementation
    public static int heapSolution(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int num : nums) {
            priorityQueue.add(num);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }

        return priorityQueue.peek();
    }
}
