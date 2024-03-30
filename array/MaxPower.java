package array;

import java.util.Arrays;

public class MaxPower {

    public static void main(String[] args) {
        int[] arr = {3, 5, 6, 0, 7};
        int[] power = {3, 1, 0, 2};
        System.out.println(getMaximumPower(arr, power));
    }

    public static int getMaximumPower(int[] arr, int[] power) {
        int res = 0;
        Arrays.sort(power);

        int[] prefixSum = new int[arr.length + 1]; // sum for [0, i)
        for (int i = 1; i <= arr.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i - 1];
        }

        int left = 0, right = power.length - 1;
        while (left < right) {
            int i = power[left];
            int j = power[right];
            int sum = prefixSum[j + 1] - prefixSum[i];
            res += sum;

            left++;
            right--;
        }

        return res;
    }
}
