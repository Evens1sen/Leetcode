package graph;

import java.util.*;

public class LC133CloneGraph {

    public static void main(String[] args) {
        Node[] graph = new Node[4];
        graph[0] = new Node(1);
        graph[1] = new Node(2);
        graph[2] = new Node(3);
        graph[3] = new Node(4);
        graph[0].neighbors.add(graph[1]);
        graph[0].neighbors.add(graph[3]);
        graph[1].neighbors.add(graph[0]);
        graph[1].neighbors.add(graph[2]);
        graph[2].neighbors.add(graph[1]);
        graph[2].neighbors.add(graph[3]);
        graph[3].neighbors.add(graph[0]);
        graph[3].neighbors.add(graph[2]);
        Node copied = cloneGraph(graph[0]);
        System.out.println(copied);
    }

    static Map<Node, Node> map = new HashMap<>();

    public static Node cloneGraph(Node node) {
        dfsCopy(node, new HashSet<>());
        dfsLink(node, new HashSet<>());
        return map.get(node);
    }

    public static void dfsCopy(Node node, Set<Node> visited) {
        Node copy = new Node(node.val);
        map.put(node, copy);
        visited.add(node);

        for (Node n : node.neighbors) {
            if (visited.contains(n)) {
                continue;
            }

            dfsCopy(n, visited);
        }
    }

    public static void dfsLink(Node node, Set<Node> visited) {
        Node copy = map.get(node);
        visited.add(node);

        for (Node n : node.neighbors) {
            copy.neighbors.add(map.get(n));
            if (!visited.contains(n)) {
                dfsLink(n, visited);
            }
        }
    }

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
