package graph;

public class LC329LongestIncreasingPathInMatrix {

    static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int m, n;

    public static void main(String[] args) {
        int[][] matrix = {{7, 8, 9}, {9, 7, 6}, {7, 2, 3}};
        System.out.println(longestIncreasingPath(matrix));
    }

    public static int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, dfs(matrix, i, j, new boolean[m][n]));
            }
        }
        return res;
    }

    public static int dfs(int[][] matrix, int i, int j, boolean[][] visited) {
        int res = 1;
        visited[i][j] = true;
        for (int[] dir : directions) {
            int nx = i + dir[0];
            int ny = j + dir[1];
            if (0 <= nx && nx < m && 0 <= ny && ny < n
                    && !visited[nx][ny] && matrix[nx][ny] > matrix[i][j]) {
                res = Math.max(res, 1 + dfs(matrix, nx, ny, visited));
            }
        }
        return res;
    }
}
