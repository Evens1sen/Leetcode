package graph;

import java.util.*;

public class LC743NetworkDelayTime {

    public static void main(String[] args) {
        int[][] times = {{1, 2, 1}};
        int n = 2, k = 2;
        System.out.println(networkDelayTime(times, n, k));
    }

    // SSSP: k to the farest node => Djistkra
    public static int networkDelayTime(int[][] times, int n, int k) {
        List<Edge>[] graph = new List[n + 1];
        for (int[] edge : times) {
            int u = edge[0];
            if (graph[u] == null) {
                graph[u] = new ArrayList<>();
            }
            graph[u].add(new Edge(edge[0], edge[1], edge[2]));
        }

        // Pair: [index, distance]
        PriorityQueue<int[]> pq = new PriorityQueue<>((Comparator.comparingInt(o -> o[1])));
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k] = 0;
        pq.add(new int[]{k, 0});
        while (!pq.isEmpty()) {
            int[] pair = pq.poll();
            int u = pair[0], dist = pair[1];

            if (graph[u] != null) {
                for (Edge edge : graph[u]) {
                    if (dist + edge.w < distance[edge.v]) {
                        distance[edge.v] = dist + edge.w;
                        pq.add(new int[]{edge.v, distance[edge.v]});
                    }
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                return -1;
            }
            max = Math.max(max, distance[i]);
        }
        return max;
    }

    static class Edge {
        int u;
        int v;
        int w;

        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
}
