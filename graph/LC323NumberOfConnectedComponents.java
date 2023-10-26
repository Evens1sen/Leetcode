package graph;

public class LC323NumberOfConnectedComponents {

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0, 1}, {0, 2}, {1, 2}, {2, 3}, {2, 4}};
        System.out.println(countComponents(n, edges));
    }

    public static int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (!uf.isConnected(u, v)) {
                uf.union(u, v);
            }
        }
        return uf.getCount();
    }

}
