package tree;

class Trie {

    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isLeaf;
    }

    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        recursiveInsert(word, root);
    }

    private void iterativeInsert(String word) {
        TrieNode cur = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (cur.children[index] == null) {
                cur.children[index] = new TrieNode();
            }
            cur = cur.children[index];
        }

        cur.isLeaf = true;
    }

    private void recursiveInsert(String word, TrieNode root) {
        if (root == null) {
            return;
        }

        if (word.length() == 0) {
            root.isLeaf = true;
            return;
        }

        int index = word.charAt(0) - 'a';
        if (root.children[index] == null) {
            root.children[index] = new TrieNode();
        }
        recursiveInsert(word.substring(1), root.children[index]);
    }

    public boolean search(String word) {
        return iterativeSearch(word);
    }

    private boolean iterativeSearch(String word) {
        TrieNode cur = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (cur.children[index] == null) {
                return false;
            }
            cur = cur.children[index];
        }

        return cur.isLeaf;
    }

    private boolean recursiveSearch(String word, TrieNode root) {
        if (root == null) {
            return false;
        }

        if (word.length() == 0) {
            return root.isLeaf;
        }

        int index = word.charAt(0) - 'a';
        return recursiveSearch(word.substring(1), root.children[index]);
    }


    public boolean startsWith(String prefix) {
        return iterativeStartWith(prefix);
    }

    private boolean iterativeStartWith(String prefix) {
        TrieNode cur = root;
        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';
            if (cur.children[index] == null) {
                return false;
            }
            cur = cur.children[index];
        }

        return true;
    }

    private boolean recursiveStartWith(String prefix, TrieNode root) {
        if (root == null) {
            return false;
        }

        if (prefix.length() == 0) {
            return true;
        }

        int index = prefix.charAt(0) - 'a';
        return recursiveSearch(prefix.substring(1), root.children[index]);
    }
}
