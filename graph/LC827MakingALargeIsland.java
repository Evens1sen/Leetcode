package graph;

import java.util.HashSet;
import java.util.Set;

public class LC827MakingALargeIsland {

    static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        int[][] grid = {{1, 1}, {1, 0}};
        System.out.println(largestIsland(grid));
    }

    public static int largestIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        UnionFind uf = new UnionFind(m * n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    for (int[] dir : directions) {
                        int nx = i + dir[0];
                        int ny = j + dir[1];
                        if (0 <= nx && nx < m && 0 <= ny && ny < n && grid[nx][ny] == 1) {
                            uf.union(i * m + j, nx * m + ny);
                        }
                    }
                }
            }
        }

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, uf.getArea(i * m + j));
                } else {
                    int area = 1;
                    Set<Integer> roots = new HashSet<>();
                    for (int[] dir : directions) {
                        int nx = i + dir[0];
                        int ny = j + dir[1];
                        if (0 <= nx && nx < m && 0 <= ny && ny < n && grid[nx][ny] == 1) {
                            int root = uf.find(nx * m + ny);
                            if (roots.contains(root)) {
                                continue;
                            }
                            area += uf.getArea(nx * m + ny);
                            roots.add(root);
                        }
                    }
                    res = Math.max(res, area);
                }
            }
        }
        return res;
    }

    static class UnionFind {
        int N;
        int[] parent;
        int[] area;

        public UnionFind(int n) {
            this.N = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            area = new int[n];
            for (int i = 0; i < n; i++) {
                area[i] = 1;
            }
        }

        public int find(int x) {
            if (parent[x] == x) {
                return x;
            }

            return parent[x] = find(parent[x]);
        }

        public int getArea(int x) {
            return area[find(x)];
        }

        public void union(int u, int v) {
            int rootU = find(u);
            int rootV = find(v);
            if (rootU == rootV) {
                return;
            }

            if (getArea(u) > getArea(v)) {
                area[rootU] += getArea(rootV);
                parent[rootV] = rootU;
            } else {
                area[rootV] += getArea(rootU);
                parent[rootU] = rootV;
            }
        }
    }
}
