package tree;

import java.util.HashMap;
import java.util.Map;

public class LC106PostInorderTreeBuilder {

    Map<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = postorder.length;
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return recursiveBuildTree(postorder, inorder, 0, n - 1, 0, n - 1);
    }

    public TreeNode recursiveBuildTree(int[] postorder, int[] inorder,
                                       int postOrderLeft, int postOrderRight,
                                       int inOrderLeft, int inOrderRight) {
        if (postOrderLeft > postOrderRight) {
            return null;
        }

        if (postOrderLeft == postOrderRight) {
            return new TreeNode(postorder[postOrderLeft]);
        }

        TreeNode root = new TreeNode(postorder[postOrderRight]);
        int rootIndex = indexMap.get(root.val);
        int leftSize = rootIndex - inOrderLeft;

        root.left = recursiveBuildTree(postorder, inorder,
                postOrderLeft, postOrderLeft + leftSize - 1,
                inOrderLeft, rootIndex - 1);
        root.right = recursiveBuildTree(postorder, inorder,
                postOrderLeft + leftSize, postOrderRight - 1,
                rootIndex + 1, inOrderRight);
        return root;
    }
}
