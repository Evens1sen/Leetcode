package graph;

import java.util.Deque;
import java.util.LinkedList;

public class LC317ShortestDistancefromAllBuildings {

    public static void main(String[] args) {
        int[][] grid = {{1, 0, 2, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}};
        System.out.println(shortestDistance(grid));
    }

    static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int[][] dist;
    static int m, n;

    public static int shortestDistance(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        dist = new int[m][n];

        int round = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    bfs(grid, i, j, round);
                    round--;
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dist[i][j] != 0) {
                    res = Math.min(res, dist[i][j]);
                }
            }
        }

        return res == 0 ? -1 : res;
    }

    public static void bfs(int[][] grid, int x, int y, int round) {
        Deque<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        // grid[x][y] = round;

        int steps = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int[] dir : directions) {
                    int nx = cur[0] + dir[0];
                    int ny = cur[1] + dir[1];
                    if (0 <= nx && nx < m && 0 <= ny && ny < n && grid[nx][ny] == round + 1) {
                        dist[nx][ny] += steps;
                        grid[nx][ny] = round;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
            steps++;
        }
    }
}
