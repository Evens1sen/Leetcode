package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC261GraphValidTree {

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        System.out.println(validTree(n, edges));
    }

    public static boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }

        Graph graph = new Graph(n);
        for (int[] edge : edges) {
            graph.addEdge(edge[0], edge[1]);
            graph.addEdge(edge[1], edge[0]);
        }

        return graph.checkValidTree();
    }

    static class Graph {
        int V;
        List<Integer>[] adjacency;

        boolean valid;

        public Graph(int n) {
            V = n;
            adjacency = new List[n];
            for (int i = 0; i < n; i++) {
                adjacency[i] = new ArrayList<>();
            }
            valid = true;
        }

        public void addEdge(int u, int v) {
            adjacency[u].add(v);
        }

        public boolean checkValidTree() {
            Set<Integer> visited = new HashSet<>();
            Set<Integer> path = new HashSet<>();
            visited.add(0);
            path.add(0);
            dfsRecursive(0, -1, visited, path);
            if (visited.size() != V) {
                valid = false;
            }
            return valid;
        }

        public void dfsRecursive(int start, int parent, Set<Integer> visited, Set<Integer> path) {
            List<Integer> adj = adjacency[start];
            for (Integer neighbour : adj) {
                if (neighbour == parent) {
                    continue;
                }

                if (visited.contains(neighbour)) {
                    return;
                }

                if (path.contains(neighbour)) {
                    valid = false;
                    return;
                }

                visited.add(neighbour);
                path.add(neighbour);
                dfsRecursive(neighbour, start, visited, path);
                path.remove(neighbour);
            }
        }
    }
}
