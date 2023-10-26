package graph;

// A template for union-find set
public class UnionFind {
    int[] parent;
    int count;

    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    // Path compression, O(1) time complexity
    public int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    public void union(int p, int q) {
        parent[find(p)] = find(q);
    }

    public boolean isConnected(int p, int q) {
        return find(q) == find(p);
    }

    public int getCount() {
        return count;
    }
}