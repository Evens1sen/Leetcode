package graph;

public class LC79WordSearch {

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return false;
        }

        if (word.charAt(index) != board[i][j]) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '0';
        boolean res = false;
        res |= dfs(board, word, i + 1, j, index + 1);
        res |= dfs(board, word, i - 1, j, index + 1);
        res |= dfs(board, word, i, j + 1, index + 1);
        res |= dfs(board, word, i, j - 1, index + 1);
        board[i][j] = temp;
        return res;
    }
}
