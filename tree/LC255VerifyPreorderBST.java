package tree;

import java.util.Deque;
import java.util.LinkedList;

public class LC255VerifyPreorderBST {

    public static void main(String[] args) {
        int[] preorder = {3, 1, 2};
        System.out.println(verifyPreorder(preorder));
    }

    public static boolean verifyPreorder(int[] preorder) {
        return verify(preorder, 0, preorder.length - 1);
    }

    public static boolean verify(int[] preorder, int left, int right) {
        if (right - left <= 1) {
            return true;
        }

        int i = left;
        while (i <= right) {
            if (preorder[i] > preorder[left]) {
                break;
            }
            i++;
        }

        for (int j = i; j <= right; j++) {
            if (preorder[j] < preorder[left]) {
                return false;
            }
        }

        return verify(preorder, left + 1, i - 1) && verify(preorder, i, right);
    }

    public boolean stackSolution(int[] preorder) {
        Deque<Integer> stack = new LinkedList<>();
        int root = Integer.MIN_VALUE;

        for (int number : preorder) {
            // If we find a node that is on the right side and smaller than root, return false
            if (number < root) {
                return false;
            }

            // If number is in right subtree of stack top,
            // Keep removing items smaller than number and make the last removed item as new root.
            while (!stack.isEmpty() && stack.peek() < number) {
                root = stack.pop();
            }

            // At this point either stack is empty or number is smaller than stack top, push number
            stack.push(number);
        }
        return true;
    }
}
