package tree;

import java.util.ArrayList;
import java.util.List;

public class LC589NaryTreePreorderTraversal {

    List<Integer> res = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        traverse(root);
        return res;
    }

    public void traverse(Node root){
        if (root == null){
            return;
        }

        if (root.children == null){
            res.add(root.val);
            return;
        }

        res.add(root.val);
        for (Node node : root.children) {
            traverse(node);
        }
    }
}
