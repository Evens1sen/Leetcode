package vo;

import java.util.*;

public class DashMart {

    public static void main(String[] args) {
        // D is dash mart, X is wall, O is space, C is client
        // Follow up: Find the number of clients for each dash mart
        char[][] grid = {
                {'X', 'O', 'O', 'D', 'O', 'O', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X', 'X', 'O', 'X', 'O', 'X'},
                {'O', 'C', 'O', 'D', 'X', 'X', 'O', 'X', 'O'},
                {'O', 'O', 'D', 'O', 'D', 'O', 'O', 'O', 'X'},
                {'O', 'C', 'C', 'O', 'O', 'X', 'O', 'O', 'X'},
                {'X', 'O', 'X', 'O', 'O', 'O', 'O', 'X', 'X'}
        };

        int[][] locations = {
                {1, 4},
                {0, 3},
                {5, 8},
                {1, 8},
                {5, 5}
        };

        System.out.println(Arrays.toString(nearestDashMarts(grid, locations)));
    }


    static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int m, n;

    public static int[] nearestDashMarts(char[][] grid, int[][] locations) {
        m = grid.length;
        n = grid[0].length;

        int[][] distance = new int[m][n];
        Map<Integer, Integer> counts = new HashMap<>();
        Deque<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'D') {
                    queue.add(new int[]{i, j});
                    counts.put(i * m + j, 0);
                } else if (grid[i][j] == 'X') {
                    distance[i][j] = -1;
                }
            }
        }

        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int x = cur[0], y = cur[1];
                if (grid[x][y] == 'C' && distance[x][y] == 0) {
                    counts.put(x * m + y, counts.get(x * m + y) + 1);
                }
                distance[x][y] = steps;

                for (int[] dir : directions) {
                    int nx = cur[0] + dir[0];
                    int ny = cur[1] + dir[1];
                    if (0 <= nx && nx < m && 0 <= ny && ny < n) {
                        if (grid[nx][ny] == 'O' && distance[nx][ny] == 0) {
                            queue.add(new int[]{nx, ny});
                        } else if (grid[nx][ny] == 'X' && distance[nx][ny] == -1) {
                            distance[nx][ny] = steps + 1;
                        }
                    }
                }
            }

            steps++;
        }

        int[] res = new int[locations.length];
        for (int i = 0; i < locations.length; i++) {
            int x = locations[i][0];
            int y = locations[i][1];
            res[i] = distance[x][y];
        }
        return res;
    }

}
