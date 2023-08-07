package graph;

// A template for union-find set
public class UnionFind {
    int[] parent;

    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int i) {
        if (parent[i] == i) {
            return i;
        }
        return parent[i] = find(parent[i]);
    }

    public void union(int p, int q) {
        parent[find(p)] = find(q);
    }

    public boolean isConnected(int p, int q) {
        return find(q) == find(p);
    }
}