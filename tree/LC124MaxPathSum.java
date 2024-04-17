package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LC124MaxPathSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5, true);
        root.left = new TreeNode(3, false);
        root.right = new TreeNode(1, false);
        root.left.left = new TreeNode(2, true);
        root.left.right = new TreeNode(6, false);
        root.left.right.right = new TreeNode(-100, true);
        root.right.left = new TreeNode(5, false);
        root.right.right = new TreeNode(10, true);
        System.out.println(maxPathSumAlive(root));
    }

    static int max = Integer.MIN_VALUE;
    static List<Integer> maxPath = null;

    public static int maxPathSum(TreeNode root) {
        maxStartPathSum(root);
        return max;
    }

    public static int maxPathSumLeaf(TreeNode root) {
        maxLeafPathSum(root);
        return max;
    }


    public static int maxStartPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMax = Math.max(maxStartPathSum(root.left), 0);
        int rightMax = Math.max(maxStartPathSum(root.right), 0);

        max = Math.max(leftMax + rightMax + root.val, max);
        return root.val + Math.max(leftMax, rightMax);
    }

    public static Pair maxLeafPathSum(TreeNode root) {
        if (root == null) {
            return new Pair(0, new LinkedList<>());
        }

        Pair left = maxLeafPathSum(root.left);
        int leftDepth = left.value;
        LinkedList<Integer> leftPath = left.path;

        Pair right = maxLeafPathSum(root.right);
        int rightDepth = right.value;
        LinkedList<Integer> rightPath = right.path;

        if (root.left != null && root.right != null) {
            if (leftDepth + rightDepth + root.val > max) {
                max = leftDepth + rightDepth + root.val;
                maxPath = new LinkedList<>(leftPath);
                Collections.reverse(maxPath);
                maxPath.add(root.val);
                maxPath.addAll(rightPath);
            }
        }

        if (leftDepth > rightDepth) {
            leftPath.addFirst(root.val);
            return new Pair(root.val + leftDepth, leftPath);
        } else {
            rightPath.addFirst(root.val);
            return new Pair(root.val + rightDepth, rightPath);
        }
    }

    static int aliveSum = Integer.MIN_VALUE;

    public static int maxPathSumAlive(TreeNode root) {
        maxPathSumAliveFromRoot2(root);
        return aliveSum;
    }


    /**
     * Find the max path from the root to an alive node
     * The root node may be either alive or not
     * Return null if no such path exist
     */
    public static Integer maxPathSumAliveFromRoot2(TreeNode root) {
        if (root == null) {
            return null;
        }

        Integer left = maxPathSumAliveFromRoot2(root.left);
        Integer right = maxPathSumAliveFromRoot2(root.right);

        if (left == null && right == null) {
            if (root.alive) {
                aliveSum = Math.max(aliveSum, root.val);
                return root.val;
            }
            return null;
        }

        if (left != null && right != null) {
            if (root.alive) {
                int sum = Math.max(root.val, Math.max(root.val + left + right,
                        Math.max(root.val + left, root.val + right)));
                aliveSum = Math.max(aliveSum, sum);
                return Math.max(root.val, root.val + Math.max(left, right));
            }
            aliveSum = Math.max(aliveSum, root.val + left + right);
            return Math.max(root.val, root.val + Math.max(left, right));
        }

        int exist = (left == null ? right : left);
        if (root.alive) {
            aliveSum = Math.max(aliveSum, Math.max(root.val, root.val + exist));
            return Math.max(root.val, root.val + exist);
        }
        return root.val + exist;
    }

    static class Pair {
        int value;
        LinkedList<Integer> path;

        public Pair(int value, LinkedList<Integer> path) {
            this.value = value;
            this.path = path;
        }
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        boolean alive;

        TreeNode() {
        }

        TreeNode(int val, boolean alive) {
            this.val = val;
            this.alive = alive;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.alive = false;
        }

    }

}
