package stack;

import java.util.Deque;
import java.util.LinkedList;

public class LC84LargestRectangleInHistogram {

    public static void main(String[] args) {
        int[] heights = {1, 1};
        System.out.println(largestRectangleArea(heights));
    }

    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] leftSmaller = new int[n];
        int[] rightSmaller = new int[n];

        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int index = stack.pop();
                rightSmaller[index] = i;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int index = stack.pop();
            rightSmaller[index] = n;
        }

        stack.push(n - 1);
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int index = stack.pop();
                leftSmaller[index] = i;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int index = stack.pop();
            leftSmaller[index] = -1;
        }

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int area = (rightSmaller[i] - leftSmaller[i] - 1) * heights[i];
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}
