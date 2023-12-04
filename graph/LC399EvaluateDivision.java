package graph;

import java.util.*;

public class LC399EvaluateDivision {

    public static void main(String[] args) {
        String[][] equations = {{"a", "b"}, {"b", "c"}, {"a", "c"}, {"d", "e"}};
        double[] values = {2.0, 3.0, 6.0, 1.0};
        String[][] queries = {{"a", "c"}, {"b", "c"}, {"a", "e"}, {"a", "a"}, {"x", "x"}, {"a", "d"}};
        System.out.println(Arrays.toString(calcEquation(equations, values, queries)));
    }

    static Map<String, List<Edge>> graph = new HashMap<>();
    static Set<String> symbol = new HashSet<>();

    public static double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        for (int i = 0; i < equations.length; i++) {
            String u = equations[i][0];
            String v = equations[i][1];
            double w = values[i];
            if (!graph.containsKey(u)) {
                graph.put(u, new ArrayList<>());
            }
            graph.get(u).add(new Edge(u, v, w));

            if (!graph.containsKey(v)) {
                graph.put(v, new ArrayList<>());
            }
            graph.get(v).add(new Edge(v, u, 1 / w));

            symbol.add(u);
            symbol.add(v);
        }

        double[] res = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String u = queries[i][0];
            String v = queries[i][1];
            if (!symbol.contains(u) || !symbol.contains(v)) {
                res[i] = -1.0;
                continue;
            }
            double temp = dfs(u, v, null);
            if (temp != 0) {
                res[i] = temp;
            } else {
                res[i] = -1.0;
            }
        }

        return res;
    }

    public static double dfs(String start, String end, String prev) {
        if (Objects.equals(start, end)) {
            return 1.0;
        }

        List<Edge> adjacency = graph.getOrDefault(start, new ArrayList<>());
        double res = 0;
        for (Edge e : adjacency) {
            if (Objects.equals(e.v, prev)) {
                continue;
            }
            res = e.w * dfs(e.v, end, e.u);
            if (res != 0) {
                return res;
            }
        }
        return res;
    }

    public static class Edge {
        String u;
        String v;
        double w;

        public Edge(String u, String v, double w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
}
