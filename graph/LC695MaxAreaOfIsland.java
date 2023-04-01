package graph;

public class LC695MaxAreaOfIsland {

    int maxArea = 0;

    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};


    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxArea = Math.max(maxArea, dfs(grid, i, j));
            }
        }

        return maxArea;
    }

    public int dfs(int[][] grid, int x, int y) {
        int m = grid.length;
        int n = grid[0].length;

        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0) {
            return 0;
        }

        grid[x][y] = 0;
        int area = 1;
        for (int[] d : directions) {
            area += dfs(grid, x + d[0], y + d[1]);
        }

        return area;
    }
}
