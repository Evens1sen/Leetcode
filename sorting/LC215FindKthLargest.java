package sorting;

import java.util.Random;

public class LC215FindKthLargest {

    public static void main(String[] args) {
        int[] nums = {1, 5, 2, 6, 3};
        int k = 4;
        System.out.println(findKthLargest(nums, k));
    }

    public static int findKthLargest(int[] nums, int k) {
        int index = nums.length - k;
        return quickSelect(nums, 0, nums.length - 1, index);
    }

    // A in-place implementation for quickSort
    public static void quickSort(int[] arr, int left, int right){
        if (left >= right){
            return;
        }

        int pivotIndex = randomPartition(arr, left, right);
        quickSort(arr, left, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, right);
    }

    public static int quickSelect(int[] arr, int left, int right, int index) {
        int partitionIndex = randomPartition(arr, left, right);
        if (partitionIndex == index) {
            return arr[partitionIndex];
        } else if (partitionIndex < index) {
            return quickSelect(arr, partitionIndex + 1, right, index);
        } else {
            return quickSelect(arr, left, partitionIndex - 1, index);
        }
    }

    public static int randomPartition(int[] arr, int left, int right) {
        Random random = new Random();
        int pivotIndex = random.nextInt(right - left + 1) + left;
        swap(arr, pivotIndex, right);
        return partition(arr, left, right);
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left;
        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                swap(arr, i++, j);
            }
        }
        swap(arr, i, right);
        return i;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    // The heap implementation
//    public static int findKthLargest(int[] nums, int k) {
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
//        for (int i = 0; i < nums.length; i++) {
//            priorityQueue.add(nums[i]);
//            if (priorityQueue.size() > k) {
//                priorityQueue.poll();
//            }
//        }
//
//        return priorityQueue.peek();
//    }
}
