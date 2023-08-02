package tree;

public class LC654MaxBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    public TreeNode buildTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int max = nums[left];
        int maxIndex = left;
        for (int i = left; i <= right; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }

        TreeNode leftTree = buildTree(nums, left, maxIndex - 1);
        TreeNode rightTree = buildTree(nums, maxIndex + 1, right);
        TreeNode root = new TreeNode(nums[maxIndex], leftTree, rightTree);
        return root;
    }
}
