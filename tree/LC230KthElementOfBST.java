package tree;

import java.util.HashMap;
import java.util.Map;

public class LC230KthElementOfBST {

    public int kthSmallest(TreeNode root, int k) {
        return 1;
    }

    static class BST{
        TreeNode root;
        Map<TreeNode, Integer> sizeMap;

        public BST(TreeNode root){
            this.root = root;
            sizeMap = new HashMap<>();
            if(root != null){
                sizeMap.put(root, 1);
            }
        }
    }
}
