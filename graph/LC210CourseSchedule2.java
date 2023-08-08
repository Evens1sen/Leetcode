package graph;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LC210CourseSchedule2 {

    // Kahn algorithm for topological sort in a graph
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        int[] degree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            graph[prerequisite[1]].add(prerequisite[0]);
            degree[prerequisite[0]]++;
        }

        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            res.add(node);
            for (Integer to : graph[node]) {
                degree[to]--;
                if (degree[to] == 0) {
                    queue.offer(to);
                }
            }
        }

        // To check the cycle in the graph
        if (res.size() == numCourses) {
            return res.stream().mapToInt(i -> i).toArray();
        } else {
            return new int[]{};
        }
    }
}
