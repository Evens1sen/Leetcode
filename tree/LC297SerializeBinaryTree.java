package tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC297SerializeBinaryTree {

    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode root = new TreeNode(1);
        TreeNode res = codec.deserialize(codec.serialize(root));
        System.out.println(res.val);
    }

    static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            return recursiveSerialize(root).substring(1);
        }

        public String recursiveSerialize(TreeNode root) {
            if (root == null) {
                return ",null";
            }

            StringBuilder sb = new StringBuilder();
            sb.append(",").append(root.val);
            sb.append(recursiveSerialize(root.left));
            sb.append(recursiveSerialize(root.right));
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] nodes = data.split(",");
            return recursiveDeserialize(nodes);
        }

        static int index = 0;

        public TreeNode recursiveDeserialize(String[] nodes) {
            if (index >= nodes.length || nodes[index].equals("null")) {
                index++;
                return null;
            }

            TreeNode root = new TreeNode(Integer.parseInt(nodes[index]));
            index++;
            root.left = recursiveDeserialize(nodes);
            root.right = recursiveDeserialize(nodes);
            return root;
        }
    }

}




