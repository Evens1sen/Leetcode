package tree;

import java.util.ArrayList;
import java.util.List;

public class LC95UniqueBST2 {

    public static void main(String[] args) {
        System.out.println(generateTrees(2));
    }

    public static List<TreeNode> generateTrees(int n) {
        return generateBST(1, n);
    }

    public static List<TreeNode> generateBST(int left, int right) {
        List<TreeNode> res = new ArrayList<>();

        if (left > right) {
            res.add(null);
            return res;
        }

        if (left == right) {
            res.add(new TreeNode(left));
            return res;
        }

        for (int i = left; i <= right; i++) {
            List<TreeNode> leftTrees = generateBST(left, i - 1);
            List<TreeNode> rightTrees = generateBST(i + 1, right);
            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    res.add(new TreeNode(i, leftTree, rightTree));
                }
            }
        }

        return res;
    }
}
