package tree;

import java.util.HashMap;
import java.util.Map;

public class LC437PathSum3 {

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        int res = rootSum(root, targetSum);
        res += pathSum(root.left, targetSum);
        res += pathSum(root.right, targetSum);
        return res;
    }


    public int rootSum(TreeNode root, int targetSum) {
        int res = 0;

        if (root == null) {
            return 0;
        }

        if (root.val == targetSum) {
            res++;
        }

        res += rootSum(root.left, targetSum - root.val);
        res += rootSum(root.right, targetSum - root.val);
        return res;
    }

    int targetSum, count = 0;

    Map<Integer, Integer> map;

    public int pathSumPrefixSolution(TreeNode root, int targetSum) {
        if (root == null) return 0;
        this.targetSum = targetSum;
        this.map = new HashMap<>();
        map.put(0, 1); // 表示前缀和为0的节点为空，有一个空。否则若pre_i = targetSum，将错过从root到i这条路径。
        dfs(root, 0);
        return count;
    }

    private void dfs(TreeNode node, int preSum) {
        if (node == null) return;
        preSum += node.val;
        count += map.getOrDefault(preSum - targetSum, 0); // #1 累计满足要求的前缀和数量
        map.put(preSum, map.getOrDefault(preSum, 0) + 1); // #2 先累计再put（先#1，再#2）
        dfs(node.left, preSum);
        dfs(node.right, preSum);
        map.put(preSum, map.get(preSum) - 1); // 路径退缩，去掉不再在路径上的当前结点的前缀和。必存在，无需使用getOrDefault。
    }

}
