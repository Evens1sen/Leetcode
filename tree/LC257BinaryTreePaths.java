package tree;

import java.util.ArrayList;
import java.util.List;

public class LC257BinaryTreePaths {

    List<String> res = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root, "");
        return res;
    }

    public void dfs(TreeNode root, String path) {
        if (root.left == null && root.right == null) {
            res.add(path + root.val);
            return;
        }

        if (root.left != null) {
            dfs(root.left, path + String.valueOf(root.val) + "->");
        }
        if (root.right != null) {
            dfs(root.right, path + String.valueOf(root.val) + "->");
        }
    }

    public List<String> recursiveSolution(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        if (root.left == null && root.right == null) {
            res.add(String.valueOf(root.val));
            return res;
        }

        List<String> leftPaths = binaryTreePaths(root.left);
        List<String> rightPaths = binaryTreePaths(root.right);
        for (String path : leftPaths) {
            res.add(root.val + "->" + path);
        }
        for (String path : rightPaths) {
            res.add(root.val + "->" + path);
        }
        return res;
    }
}
