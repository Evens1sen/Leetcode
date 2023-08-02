package tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC297SerializeBinaryTree {

    static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            return recursiveSerialize(root, "");
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] dataArray = data.split(",");
            List<String> dataList = new LinkedList<String>(Arrays.asList(dataArray));
            return recursiveDeserialize(dataList);
        }

        public String recursiveSerialize(TreeNode root, String str) {
            if (root == null) {
                str += "None,";
            } else {
                str += root.val + ",";
                str = recursiveSerialize(root.left, str);
                str = recursiveSerialize(root.right, str);
            }
            return str;
        }

        public TreeNode recursiveDeserialize(List<String> dataList) {
            if (dataList.get(0).equals("None")) {
                dataList.remove(0);
                return null;
            }

            TreeNode root = new TreeNode(Integer.parseInt(dataList.get(0)));
            dataList.remove(0);
            root.left = recursiveDeserialize(dataList);
            root.right = recursiveDeserialize(dataList);

            return root;
        }
    }

}




