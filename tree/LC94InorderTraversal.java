package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LC94InorderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        inorderTraversal(root);
        System.out.println(res);
    }

    public static List<Integer> morrisTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode prev = null;

        while (root != null) {
            if (root.left == null) {
                res.add(root.val);
                root = root.right;
            } else {
                prev = root.left;
                while (prev.right != root && prev.right != null) {
                    prev = prev.right;
                }

                if (prev.right == null) {
                    prev.right = root;
                    root = root.left;
                } else {
                    res.add(root.val);
                    prev.right = null;
                    root = root.right;
                }
            }
        }

        return res;
    }

    static List<Integer> res = new ArrayList<>();

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root);
        return res;
    }

    public static void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        Deque<Pair> stack = new LinkedList<>();
        stack.push(new Pair(root, 0));
        while (!stack.isEmpty()) {
            Pair cur = stack.pop();
            if (cur.color == 0) {
                if (cur.node.right != null) {
                    stack.push(new Pair(cur.node.right, 0));
                }
                stack.push(new Pair(cur.node, 1));
                if (cur.node.left != null) {
                    stack.push(new Pair(cur.node.left, 0));
                }
            } else {
                res.add(cur.node.val);
            }
        }
    }

    static class Pair {
        TreeNode node;

        int color;

        public Pair(TreeNode node, int color) {
            this.node = node;
            this.color = color;
        }
    }
}
