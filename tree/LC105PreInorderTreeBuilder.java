package tree;

import java.util.HashMap;
import java.util.Map;

public class LC105PreInorderTreeBuilder {

    Map<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return recursiveBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    public TreeNode recursiveBuildTree(int[] preorder, int[] inorder,
                                       int preOrderLeft, int preOrderRight,
                                       int inOrderLeft, int inOrderRight) {
        if (preOrderLeft > preOrderRight) {
            return null;
        }

        if (preOrderLeft == preOrderRight) {
            return new TreeNode(preorder[preOrderLeft]);
        }

        TreeNode root = new TreeNode(preorder[preOrderLeft]);
        int rootIndex = indexMap.get(root.val);
        int leftSize = rootIndex - inOrderLeft;

        root.left = recursiveBuildTree(preorder, inorder,
                preOrderLeft + 1, preOrderLeft + leftSize,
                inOrderLeft, rootIndex - 1);
        root.right = recursiveBuildTree(preorder, inorder,
                preOrderLeft + leftSize + 1, preOrderRight,
                rootIndex + 1, inOrderRight);
        return root;
    }
}
