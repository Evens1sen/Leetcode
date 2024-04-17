package vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuTree {

    public static void main(String[] args) {

    /*
             Existing tree
                a(1, T)
               /        \
            b(2, T)   c(3, T)
           /       \
       d(4, T)   e(5, T)

                 New tree
               a(1, T)
              /       \
         b(2, T)      c(3, T)
          /              \
     d(4, T)            e(5, T)

     */

        Node a = new Node("a", 1, true);
        Node b = new Node("b", 2, true);
        Node c = new Node("c", 3, true);
        Node d = new Node("d", 4, true);
        Node e = new Node("e", 5, true);
        Node f = new Node("f", 6, true);

        a.children.add(b);
        a.children.add(c);

        b.children.add(d);
        b.children.add(e);

        c.children.add(f);

        Node a1 = new Node("a", 1, true);
        Node b1 = new Node("b", 2, true);
        Node c1 = new Node("c", 3, false);
        Node d1 = new Node("d", 4, true);
        Node e1 = new Node("e", 5, true);
        Node f1 = new Node("f", 66, true);
        Node g1 = new Node("g", 7, false);

//        a1.children.add(b1);
        a1.children.add(c1);

        b1.children.add(d1);
//        b1.children.add(e1);
//        b1.children.add(f1);

        c1.children.add(f1);

        int count = getDiffCount(a, a1);
        System.out.println("Changed Items are: " + count);
    }


    static class Node {
        String key;
        int value;
        boolean active;
        List<Node> children;

        public Node(String key, int value, boolean isActive) {
            this.key = key;
            this.value = value;
            this.active = isActive;
            this.children = new ArrayList<>();
        }

        public boolean equals(Node node) {
            return this.key.equals(node.key) && this.value == node.value && this.active == node.active;
        }

        public String toString() {
            return String.format("(%s, %d, %b)", key, value, active);
        }
    }

    private static int getDiffCount(Node t1, Node t2) {
        if (t1 == null && t2 == null) {
            return 0;
        }

        int res = 0;
        if (t1 == null || t2 == null || !t1.equals(t2)) {
            res++;
        }

        Map<String, Node> children1 = getChildrenMap(t1);
        Map<String, Node> children2 = getChildrenMap(t2);
        for (String key : children1.keySet()) {
            res += getDiffCount(children1.get(key), children2.get(key));
        }

        for (String key : children2.keySet()) {
            if (!children1.containsKey(key)) {
                res += getDiffCount(null, children2.get(key));
            }
        }

        return res;
    }

    private static Map<String, Node> getChildrenMap(Node node) {
        Map<String, Node> map = new HashMap<>();
        if (node == null) {
            return map;
        }

        for (Node child : node.children) {
            map.put(child.key, child);
        }
        return map;
    }

}
