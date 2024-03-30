package searching;

import java.util.ArrayList;
import java.util.List;

public class LC131PalindromePartition {

    public static void main(String[] args) {
        String s = "abbab";
        System.out.println(partition(s));
    }

    static List<List<String>> res = new ArrayList<>();

    static boolean[][] isPalindrome;

    public static List<List<String>> partition(String s) {
        isPalindrome = new boolean[s.length()][s.length()];

        // Set left down part of the matrix to false
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (i >= j) {
                    isPalindrome[i][j] = true;
                }
            }
        }

        // Since dp[i][j] depends on dp[i+1][j-1], iterate from down to up and left to right
        for (int i = s.length() - 2; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                isPalindrome[i][j] = isPalindrome[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
            }
        }

        return backtracking(s, 0);
//        return res;
    }

    public static List<List<String>> backtracking(String s, int index) {
        List<List<String>> res = new ArrayList<>();
        if (s.length() == index) {
            res.add(new ArrayList<>());
            return res;
        }

        for (int i = index; i < s.length(); i++) {
            if (isPalindrome[index][i]) {
                String first = s.substring(index, i + 1);
                List<List<String>> last = backtracking(s, i + 1);
                for (List<String> lst : last) {
                    lst.add(0, first);
                }
                res.addAll(last);
            }
        }
        return res;
    }

    public static void backtracking(String s, int index, List<String> path) {
        if (index == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (isPalindrome[index][i]) {
                path.add(s.substring(index, i + 1));
                backtracking(s, i + 1, path);
                path.remove(path.size() - 1);
            }
        }
    }


    // The check() to examine the palindrome substring can be optimized by DP
    public static boolean check(String s, int i, int j) {
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
