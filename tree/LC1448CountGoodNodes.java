package tree;

import java.util.Deque;
import java.util.LinkedList;

public class LC1448CountGoodNodes {

    public int goodNodes(TreeNode root) {
        return countNodes(root, -100000);
    }

    public int countNodes(TreeNode root, int max) {
        if (root == null) {
            return 0;
        }

        int res = 0;
        if (root.val >= max) {
            res += 1;
        }
        res += countNodes(root.left, Math.max(max, root.val));
        res += countNodes(root.right, Math.max(max, root.val));
        return res;
    }
}
