package graph;

public class LC200NumberOfIslands {

    public int numIslands(char[][] grid) {
        return dfsSolution(grid);
    }

    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int dfsSolution(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }

        return res;
    }

    public void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';
        for (int[] d : directions) {
            dfs(grid, i + d[0], j + d[1]);
        }
    }
}
