package searching;

import java.util.ArrayList;
import java.util.List;

public class LC131PalindromePartition {

    List<List<String>> res = new ArrayList<>();

    boolean[][] isPalindromeSubstring;

    public List<List<String>> partition(String s) {
        isPalindromeSubstring = new boolean[s.length()][s.length()];

        // Set left down part of the matrix to false
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (i >= j) {
                    isPalindromeSubstring[i][j] = true;
                }
            }
        }

        // Since dp[i][j] depends on dp[i+1][j-1], iterate from down to up and left to right
        for (int i = s.length() - 2; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (i < j) {
                    isPalindromeSubstring[i][j] = isPalindromeSubstring[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
                }
            }
        }

        backtracking(s, 0, new ArrayList<>());
        return res;
    }

    public void backtracking(String s, int index, List<String> path) {
        if (index == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (isPalindromeSubstring[index][i]) {
                path.add(s.substring(index, i + 1));
                backtracking(s, i + 1, path);
                path.remove(path.size() - 1);
            }
        }
    }


    // The check() to examine the palindrome substring can be optimized by DP
    public boolean check(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
