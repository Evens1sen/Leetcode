package array;

public class LC42TrappingRainWater {

    public int trap(int[] height) {
        return doublePointerSolution(height);
    }

    // water[i] = min(max(left[0:i]), max(right[i:n])) - height[i]
    public int dpSolution(int[] height) {
        int n = height.length;
        int res = 0;
        int[] leftMax = new int[n]; // leftMax[i] = max(height[0:i])
        int[] rightMax = new int[n];
        leftMax[0] = height[0];
        rightMax[n - 1] = height[n - 1];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        for (int i = 0; i < n; i++) {
            res += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return res;
    }

    public int doublePointerSolution(int[] height) {
        int n = height.length;
        int res = 0;
        int left = 0;
        int right = n - 1;
        int leftMax = height[0];
        int rightMax = height[n - 1];

        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax < rightMax) {
                res += leftMax - height[left];
                left++;
            } else {
                res += rightMax - height[right];
                right--;
            }
        }

        return res;
    }
}
