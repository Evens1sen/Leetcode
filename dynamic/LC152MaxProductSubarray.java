package dynamic;

public class LC152MaxProductSubarray {

    public int maxProduct(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        int[] maxDp = new int[n];
        int[] minDp = new int[n];
        maxDp[0] = nums[0];
        minDp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            maxDp[i] = max3(maxDp[i - 1] * nums[i], minDp[i - 1] * nums[i], nums[i]);
            minDp[i] = min3(maxDp[i - 1] * nums[i], minDp[i - 1] * nums[i], nums[i]);
            max = Math.max(max, maxDp[i]);
        }

        return max;
    }

    public int max3(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public int min3(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    public int scanSolution(String s) {
        int left = 0;
        int right = 0;
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }

            if (right > left) {
                left = 0;
                right = 0;
            }

            if (left == right) {
                maxLength = Math.max(maxLength, left + right);
            }
        }

        left = 0;
        right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }

            if (right < left) {
                left = 0;
                right = 0;
            }

            if (left == right) {
                maxLength = Math.max(maxLength, left + right);
            }
        }

        return maxLength;
    }
}
