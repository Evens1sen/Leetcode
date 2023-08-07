package graph;

import java.util.Deque;
import java.util.LinkedList;

public class LC994RottingOranges {

    // Multi-source BFS problem
    public int orangesRotting(int[][] grid) {
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int time = 0;
        int cnt = 0;

        int m = grid.length;
        int n = grid[0].length;

        Deque<int[]> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    cnt++;
                }
            }
        }

        if (cnt == 0) {
            return 0;
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int[] d : directions) {
                    int nx = cur[0] + d[0];
                    int ny = cur[1] + d[1];
                    if (nx >= 0 && ny >= 0 && nx < m && ny < n && grid[nx][ny] == 1) {
                        grid[nx][ny] = 2;
                        queue.offer(new int[]{nx, ny});
                        cnt--;
                    }
                }
            }
            time++;
        }

        return cnt == 0 ? time - 1 : -1;
    }
}
