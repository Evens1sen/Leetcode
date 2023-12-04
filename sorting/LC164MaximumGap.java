package sorting;

import java.util.Arrays;

public class LC164MaximumGap {

    // Radix sort
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return 0;
        }

        long exp = 1;
        int[] buf = new int[n];
        int maxVal = Arrays.stream(nums).max().getAsInt();

        while (maxVal >= exp) {
            int[] cnt = new int[10];
            for (int num : nums) {
                int digit = (num / (int) exp) % 10;
                cnt[digit]++;
            }

            for (int i = 1; i < 10; i++) {
                cnt[i] += cnt[i - 1];
            }

            for (int i = n - 1; i >= 0; i--) {
                int digit = (nums[i] / (int) exp) % 10;
                buf[cnt[digit] - 1] = nums[i];
                cnt[digit]--;
            }

            System.arraycopy(buf, 0, nums, 0, n);
            exp *= 10;
        }

        int res = 0;
        for (int i = 1; i < n; i++) {
            res = Math.max(res, nums[i] - nums[i - 1]);
        }
        return res;
    }
}
