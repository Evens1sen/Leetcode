package graph;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LC207CanFinish {

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{0, 1}, {1, 0}};
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
                edges[i] = new LinkedList<Integer>();
            }
        }

        public void addEdge(int u, int v) {
            edges[u].add(v);
        }

        public boolean hasCycle() {
            boolean[] visited = new boolean[V];
            for (int i = 0; i < V; i++) {
                if (!visited[i]) {
                    dfs(i, visited);
                }
            }
            return hasCycle;
        }

        //FIXME
        public void dfs(int start, boolean[] visited) {
            Deque<Integer> stack = new LinkedList<>();
            stack.push(start);
            while (!stack.isEmpty()) {
                Integer cur = stack.peek();
                visited[cur] = true;
                for (Integer neighbour : edges[cur]) {
                    if (stack.contains(neighbour)) {
                        hasCycle = true;
                        continue;
                    }

                    if (!visited[neighbour]) {
                        stack.push(neighbour);
                    }
                }
            }
        }
    }

}
