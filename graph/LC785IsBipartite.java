package graph;

public class LC785IsBipartite {

    // Potential Bug with static
    static boolean result = true;

    public static void main(String[] args) {
//        int[][] graph = {{3, 4, 6}, {3, 6}, {3, 6}, {0, 1, 2, 5}, {0, 7, 8}, {3}, {0, 1, 2, 7}, {4, 6}, {4}, {}};
//        int[][] graph = {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
        int[][] graph = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
        System.out.println(isBipartite(graph));
    }

    // DFS solution
//    public static boolean isBipartite(int[][] graph) {
//        int[] colors = new int[graph.length];
//        for (int start = 0; start < graph.length; start++) {
//            if (colors[start] == 0) {
//                colors[start] = 1;
//                dfs(graph, start, colors);
//                if (!result) {
//                    break;
//                }
//            }
//        }
//        return result;
//    }

    //Union-Find set solution
    public static boolean isBipartite(int[][] graph) {
        UnionFind unionFind = new UnionFind(graph.length);
        for (int i = 0; i < graph.length; i++) {
            int[] adjacency = graph[i];
            for (int neighbour : adjacency) {
                if (unionFind.isConnected(i, neighbour)) {
                    return false;
                }
                unionFind.union(adjacency[0], neighbour);
            }
        }
        return true;
    }

    // The template for dfs in graph
    // Be careful about passing arguments by value and reference
    public static void dfs(int[][] graph, int start, int[] colors) {
        int[] adjacency = graph[start];
        int currentColor = colors[start];
        for (Integer neighbour : adjacency) {
            if (colors[neighbour] == currentColor) {
                result = false;
                return;
            }

            if (colors[neighbour] == 0) {
                colors[neighbour] = -currentColor;
                dfs(graph, neighbour, colors);
            }
        }
    }

    // A template for union-find set
    static class UnionFind {
        int[] fathers;

        public UnionFind(int n) {
            fathers = new int[n];
            for (int i = 0; i < n; i++) {
                fathers[i] = i;
            }
        }

        public int find(int i) {
            if (fathers[i] == i) {
                return i;
            }
            return fathers[i] = find(fathers[i]);
        }

        public void union(int p, int q) {
            fathers[find(p)] = find(q);
        }

        public boolean isConnected(int p, int q) {
            return find(q) == find(p);
        }
    }


}
