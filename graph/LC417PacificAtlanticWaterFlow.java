package graph;

import java.util.ArrayList;
import java.util.List;

public class LC417PacificAtlanticWaterFlow {

    static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        int[][] heights = {{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};
        pacificAtlantic(heights);
        System.out.println(res);
    }

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        return backwardDfs(heights);
    }

    public static List<List<Integer>> forwardDfs(int[][] heights) {
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                int code = dfs1(heights, i, j, new boolean[heights.length][heights[0].length]);
                if (code == 3) {
                    res.add(List.of(i, j));
                }
            }
        }
        return res;
    }

    /**
     * Forward dfs method, from uncertain start point to certain end points
     * with return value, reach pacific: 1, atlantic: 2, both: 3
     * Can avoid add to res in the process of dfs
     */
    public static int dfs1(int[][] heights, int x, int y, boolean[][] visited) {
        if (x == 0 && y == heights[0].length - 1) {
            return 3;
        }

        if (x == heights.length - 1 && y == 0) {
            return 3;
        }

        if (x == -1 || y == -1) {
            return 1;
        }

        if (x == heights.length || y == heights[0].length) {
            return 2;
        }

        boolean pacific = false;
        boolean atlantic = false;
        for (int[] d : directions) {
            int nx = x + d[0];
            int ny = y + d[1];
            if (nx == -1 || nx == heights.length || ny == -1 || ny == heights[0].length || (!visited[nx][ny] && heights[nx][ny] <= heights[x][y])) {
                visited[x][y] = true;
                int r = dfs1(heights, nx, ny, visited);
                if (r == 1) {
                    pacific = true;
                } else if (r == 2) {
                    atlantic = true;
                } else if (r == 3) {
                    pacific = true;
                    atlantic = true;
                }
            }
        }

        if (pacific && atlantic) {
            return 3;
        } else if (atlantic) {
            return 2;
        } else if (pacific) {
            return 1;
        }
        return 0;
    }

    public static List<List<Integer>> backwardDfs(int[][] heights) {
        boolean[][] pacific = new boolean[heights.length][heights[0].length];
        boolean[][] atlantic = new boolean[heights.length][heights[0].length];
        for (int i = 0; i < heights.length; i++) {
            dfs2(heights, i, 0, pacific);
        }
        for (int j = 0; j < heights[0].length; j++) {
            dfs2(heights, 0, j, pacific);
        }
        for (int i = 0; i < heights.length; i++) {
            dfs2(heights, i, heights[0].length - 1, atlantic);
        }
        for (int j = 0; j < heights[0].length; j++) {
            dfs2(heights, heights.length - 1, j, atlantic);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(List.of(i, j));
                }
            }
        }
        return res;
    }


    public static void dfs2(int[][] heights, int x, int y, boolean[][] visited) {
        if (visited[x][y]) {
            return;
        }

        visited[x][y] = true;
        for (int[] d : directions) {
            int nx = x + d[0];
            int ny = y + d[1];
            if (nx >= 0 && nx < heights.length && ny >= 0 && ny < heights[0].length &&
                    heights[nx][ny] >= heights[x][y]) {
                dfs2(heights, nx, ny, visited);
            }
        }
    }
}
