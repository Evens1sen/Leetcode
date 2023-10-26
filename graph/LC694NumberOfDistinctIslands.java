package graph;

import java.util.HashSet;
import java.util.Set;

public class LC694NumberOfDistinctIslands {

    /**
     * It's intuitive to use hash methods to calculate it
     * So we need to serialize all the islands
     * Using similar ideas to tree's traversal
     */
    public int numDistinctIslands(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Set<String> islands = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, i, j, sb, 0);
                    islands.add(sb.toString());
                }
            }
        }
        return islands.size();
    }

    /**
     * dir 1: down, -1: up, 2: right, -2: left
     * Need to keep the "undo" operation
     */
    public void dfs(int[][] grid, int x, int y, StringBuilder path, int dir) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return;
        }

        if (grid[x][y] == 0) {
            return;
        }

        path.append(dir).append(",");
        grid[x][y] = 0;
        dfs(grid, x - 1, y, path, -1);
        dfs(grid, x + 1, y, path, 1);
        dfs(grid, x, y - 1, path, -2);
        dfs(grid, x, y + 1, path, 2);
        path.append(-dir).append(",");
    }
}
