package tree;

public class LC222CompleteTreeNodes {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        System.out.println(check(root, 2, 6));
    }

    public static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        TreeNode cur = root;
        int depth = 0;
        while (cur.left != null) {
            cur = cur.left;
            depth++;
        }

        int left = 1 << depth;
        int right = (1 << (depth + 1));
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(root, depth, mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left - 1;
    }

    public static boolean check(TreeNode root, int level, int index) {
        int bits = 1 << (level - 1);
        TreeNode node = root;
        while (node != null && bits > 0) {
            if ((bits & index) == 0) {
                node = node.left;
            } else {
                node = node.right;
            }
            bits >>= 1;
        }
        return node != null;
    }

    // O(h^2) = O(log^2 n) time complexity
    public int countNodesRecursive(TreeNode root) {
        if (root == null) {
            return 0;
        }

        TreeNode left = root;
        TreeNode right = root;
        int heightLeft = 0;
        int heightRight = 0;
        while (left != null) {
            left = left.left;
            heightLeft++;
        }
        while (right != null) {
            right = right.right;
            heightRight++;
        }

        if (heightLeft == heightRight) {
            return (int) Math.pow(2, heightLeft) - 1;
        }

        return 1 + countNodesRecursive(root.left) + countNodesRecursive(root.right);
    }
}
