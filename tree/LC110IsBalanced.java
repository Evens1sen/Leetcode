package tree;

public class LC110IsBalanced {

    public boolean balanced = true;

    public boolean isBalanced(TreeNode root) {
        depth(root);
        return balanced;
    }

    public int depth(TreeNode root){
        if (root == null){
            return 0;
        }

        int left = depth(root.left);
        int right = depth(root.right);
        if (Math.abs(left - right) > 1){
            balanced = false;
        }
        return Math.max(left, right) + 1;
    }
}
