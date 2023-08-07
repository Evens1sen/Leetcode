package graph;

public class LC785IsBipartite {

    // Potential Bug with static
    static boolean result = true;

    public static void main(String[] args) {
        int[][] graph = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
        System.out.println(isBipartite(graph));
    }

    // Use graph coloring to check bipartite
    // We can use dfs or union-find set
    public static boolean isBipartite(int[][] graph) {
        return dfsSolution(graph);
    }

    // DFS solution
    public static boolean dfsSolution(int[][] graph) {
        int[] colors = new int[graph.length];
        for (int start = 0; start < graph.length; start++) {
            if (colors[start] == 0) {
                colors[start] = 1;
                dfs(graph, start, colors);
                if (!result) {
                    break;
                }
            }
        }
        return result;
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

    // Union-Find set solution
    public static boolean unionFindSolution(int[][] graph) {
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

}
