package tree;

import java.util.Deque;
import java.util.LinkedList;

public class LC513FindBottomLeftTreeValue {

    public int findBottomLeftValue(TreeNode root) {
        int res = 0;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.right != null) {
                queue.add(cur.right);
            }
            if (cur.left != null) {
                queue.add(cur.left);
            }
            res = cur.val;
        }
        return res;
    }
}
