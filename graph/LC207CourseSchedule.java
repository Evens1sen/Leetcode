package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC207CourseSchedule {

    public static void main(String[] args) {
        int numCourses = 8;
        int[][] prerequisites = {{1, 0}, {2, 6}, {1, 7}, {6, 4}, {7, 0}, {0, 5}};
        System.out.println(canFinish(numCourses, prerequisites));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Graph graph = new Graph(numCourses);
        for (int[] prerequisite : prerequisites) {
            graph.addEdge(prerequisite[1], prerequisite[0]);
        }
        return !graph.hasCycle();
    }

    static class Graph {
        int V;
        List<Integer>[] edges;
        boolean hasCycle = false;

        public Graph(int v) {
            V = v;
            this.edges = new List[V];
            for (int i = 0; i < V; i++) {
                edges[i] = new LinkedList<>();
            }
        }

        public void addEdge(int u, int v) {
            edges[u].add(v);
        }

        public boolean hasCycle() {
            boolean[] visited = new boolean[V];
            for (int i = 0; i < V; i++) {
                if (!visited[i]) {
                    List<Integer> path = new ArrayList<>();
                    path.add(i);
                    dfs(i, visited, path);
                }
            }
            return hasCycle;
        }


        // The recursive implementation of dfs
        public void dfs(int start, boolean[] visited, List<Integer> path) {
            if (visited[start]) {
                return;
            }

            visited[start] = true;
            for (Integer neighbour : edges[start]) {
                if (path.contains(neighbour)) {
                    hasCycle = true;
                    return;
                }

                path.add(neighbour);
                dfs(neighbour, visited, path);
                path.remove(path.size() - 1);
            }
        }
    }

}
