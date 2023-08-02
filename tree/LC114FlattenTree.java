package tree;

public class LC114FlattenTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
//        flatten(root);
    }

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;
        flatten(root.left);
        flatten(root.right);

        root.left = null;
        root.right = left;
        while (root.right != null) {
            root = root.right;
        }
        root.right = right;
    }

    public static TreeNode flattenWithLast(TreeNode root) {
        if (root == null) {
            return null;
        }

        if (root.left == null && root.right == null) {
            return root;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;
        TreeNode leftLast = flattenWithLast(left);
        TreeNode rightLast = flattenWithLast(right);
        root.left = null;
        if (left != null) {
            root.right = left;
        }
        if (leftLast != null) {
            leftLast.right = right;
        }
        return rightLast;
    }
}
