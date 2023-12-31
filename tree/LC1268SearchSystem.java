package tree;

import java.util.ArrayList;
import java.util.List;

public class LC1268SearchSystem {

    public static void main(String[] args) {
        String[] products = {"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        String searchWord = "mouse";
        System.out.println(suggestedProducts(products, searchWord));
    }

    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Node root = new Node(-1);
        for (String product : products) {
            insert(root, product);
        }

        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < searchWord.length(); i++) {
            String prefix = searchWord.substring(0, i + 1);
            List<String> lst = search(root, prefix);
            res.add(lst);
        }

        return res;
    }

    public static List<String> search(Node root, String prefix) {
        List<String> res = new ArrayList<>();

        Node cur = root;
        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';
            if (cur.children[index] == null) {
                return res;
            }
            cur = cur.children[index];
        }

        res = collectWord(cur).stream()
                .limit(3)
                .map(s -> prefix.substring(0, prefix.length() - 1) + s)
                .toList();
        return res;
    }

    // Collect all the words from root
    public static List<String> collectWord(Node root) {
        List<String> res = new ArrayList<>();
        if (root.isLeaf) {
            res.add(String.valueOf((char) (root.index + 'a')));
        }

        char ch = (char) (root.index + 'a');
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                List<String> sub = collectWord(root.children[i]);
                for (String s : sub) {
                    res.add(ch + s);
                }
            }
        }

        return res;
    }

    public static void insert(Node root, String str) {
        Node cur = root;
        for (char ch : str.toCharArray()) {
            int index = ch - 'a';
            if (cur.children[index] == null) {
                cur.children[index] = new Node(index);
            }
            cur = cur.children[index];
        }
        cur.isLeaf = true;
    }

    static class Node {
        int index;

        boolean isLeaf;

        Node[] children;

        public Node(int index) {
            this.index = index;
            this.isLeaf = false;
            children = new Node[26];
        }
    }
}
