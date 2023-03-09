package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LC637AverageOfLevelsInBinaryTree {

    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Double> res = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int cnt = queue.size();
            double avg = 0;
            for (int i = 0; i < cnt; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null){
                    queue.add(cur.left);
                }
                if (cur.right != null){
                    queue.add(cur.right);
                }
                avg += cur.val;
            }
            avg = avg / cnt;
            res.add(avg);
        }

        return res;
    }
}
