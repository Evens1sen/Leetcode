package graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LC1584MinCostToConnectAllPoints {


    // Kruskal Algorithm for MST
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        UnionFind uf = new UnionFind(n);
        List<Edge> edges = new ArrayList<Edge>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                edges.add(new Edge(dist(points, i, j), i, j));
            }
        }

        edges.sort(Comparator.comparingInt(edge -> edge.len));
        int res = 0, num = 1;
        for (Edge edge : edges) {
            int len = edge.len, x = edge.x, y = edge.y;
            if (!uf.isConnected(x, y)) {
                res += len;
                num++;
                if (num == n) {
                    break;
                }
            }
        }
        return res;
    }

    public int dist(int[][] points, int x, int y) {
        return Math.abs(points[x][0] - points[y][0]) + Math.abs(points[x][1] - points[y][1]);
    }

    static class Edge {
        int len;
        int x;
        int y;

        public Edge(int len, int x, int y) {
            this.len = len;
            this.x = x;
            this.y = y;
        }
    }

}
