package graph;

public class LC130SurroundedRegions {

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(board, i, 0, visited);
            dfs(board, i, n - 1, visited);
        }
        for (int j = 0; j < n; j++) {
            dfs(board, 0, j, visited);
            dfs(board, m - 1, j, visited);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(char[][] board, int x, int y, boolean[][] visited) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return;
        }

        if (board[x][y] == 'X' || visited[x][y]) {
            return;
        }

        visited[x][y] = true;
        dfs(board, x - 1, y, visited);
        dfs(board, x + 1, y, visited);
        dfs(board, x, y - 1, visited);
        dfs(board, x, y + 1, visited);
    }
}
