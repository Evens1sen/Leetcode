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
        int i = 0, j = n - 1;
        int leftMax = 0, rightMax = 0;

        // res[i] = min(leftMax[i], rightMax[i]) - height[i]
        // res[j] = min(leftMax[j], rightMax[j]) - height[j]
        // leftMax[i] <= leftMax[j]
        // rightMax[i] >= rightMax[j]
        // res[i] = min(leftMax[i], rightMax[j]) - height[i]
        // res[j] = min(leftMax[i], rightMax[j]) - height[i]

        int res = 0;
        while (i <= j) {
            leftMax = Math.max(leftMax, height[i]);
            rightMax = Math.max(rightMax, height[j]);
            if (height[i] < height[j]) {
                res += leftMax - height[i];
                i++;
            } else {
                res += rightMax - height[j];
                j--;
            }
        }
        return res;
    }
}
