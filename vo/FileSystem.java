package vo;


import java.util.HashMap;
import java.util.Map;

class FileSystem {

    Node root;

    public FileSystem() {
        root = new Node("/", 0);
    }

    public boolean createPath(String path, int value) {
        String[] dirs = path.split("/");
        Node cur = root;
        for (int i = 1; i < dirs.length - 1; i++) {
            String dir = dirs[i];
            if (!cur.children.containsKey(dir)) {
                return false;
            }
            cur = cur.children.get(dir);
        }

        String dir = dirs[dirs.length - 1];
        if (!cur.children.containsKey(dir)) {
            cur.children.put(dir, new Node(dir, value));
            return true;
        }
        return false;
    }

    public int get(String path) {
        String[] dirs = path.split("/");
        Node cur = root;
        for (int i = 1; i < dirs.length; i++) {
            String dir = dirs[i];
            if (!cur.children.containsKey(dir)) {
                return -1;
            }
            cur = cur.children.get(dir);
        }
        return cur.value;
    }

    public boolean deletePath(String path) {
        String[] dirs = path.split("/");
        Node cur = root;
        for (int i = 1; i < dirs.length - 1; i++) {
            String dir = dirs[i];
            if (!cur.children.containsKey(dir)) {
                return false;
            }
            cur = cur.children.get(dir);
        }

        String dir = dirs[dirs.length - 1];
        if (cur.children.containsKey(dir)) {
            deleteNode(cur.children.get(dir));
            cur.children.remove(dir);
            return true;
        }
        return false;
    }

    public void deleteNode(Node root) {
        if (root.value == 0) {
            return;
        }

        for (Node node : root.children.values()) {
            deleteNode(node);
        }
        root.children.clear();
    }

    static class Node {
        String name;
        int value;
        Map<String, Node> children;

        public Node(String name, int value) {
            this.name = name;
            this.value = value;
            children = new HashMap<>();
        }
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */