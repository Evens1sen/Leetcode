package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC212WordSearchII {

    static Set<String> res = new HashSet<>();
    static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int m, n;
    static Node root = new Node('-');
    static Node cur = root;

    public static void main(String[] args) {
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        String[] words = {"oath", "pea", "eat", "rain"};
        System.out.println(findWords(board, words));
    }

    public static List<String> findWords(char[][] board, String[] words) {
        for (String str : words) {
            insert(str);
        }

        m = board.length;
        n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, new StringBuilder(), i, j);
            }
        }
        return new ArrayList<>(res);
    }

    public static void dfs(char[][] board, StringBuilder word, int x, int y) {
        char ch = board[x][y];
        if (cur.children[ch - 'a'] == null) {
            return;
        }

        word.append(ch);
        Node prev = cur;
        cur = cur.children[ch - 'a'];
        if (cur.isLeaf) {
            res.add(word.toString());
        }

        board[x][y] = '0';
        for (int[] dir : directions) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (0 <= nx && nx < m && 0 <= ny && ny < n && board[nx][ny] != '0') {
                dfs(board, word, nx, ny);
            }
        }

        board[x][y] = ch;
        cur = prev;
        word.deleteCharAt(word.length() - 1);
    }

    public static void insert(String word) {
        Node cur = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (cur.children[index] == null) {
                cur.children[index] = new Node(ch);
            }
            cur = cur.children[index];
        }
        cur.isLeaf = true;
    }

    static class Node {
        char ch;
        boolean isLeaf;
        Node[] children;

        public Node(char ch) {
            this.ch = ch;
            this.isLeaf = false;
            children = new Node[26];
        }
    }
}
