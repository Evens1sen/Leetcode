package tree;

public class LC124MaxPathSum {

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxStartPathSum(root);
        return max;
    }

    public int maxStartPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMax = Math.max(maxStartPathSum(root.left), 0);
        int rightMax = Math.max(maxStartPathSum(root.right), 0);

        max = Math.max(leftMax + rightMax + root.val, max);
        return root.val + Math.max(leftMax, rightMax);
    }
}
