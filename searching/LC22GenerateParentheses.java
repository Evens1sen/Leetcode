package searching;

import java.util.ArrayList;
import java.util.List;

public class LC22GenerateParentheses {

    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        //generate("", 0, n * 2);
        StringBuilder track = new StringBuilder();
        backtracking(n, n, track);
        return res;
    }

    // Keep track of left and right parenthesis to prone the tree
    public void backtracking(int left, int right, StringBuilder track) {
        // Not valid
        if (right < left) {
            return;
        }
        if (left < 0 || right < 0) {
            return;
        }

        // Valid
        if (left == 0 && right == 0) {
            res.add(track.toString());
            return;
        }

        // Backtracking
        track.append('(');
        backtracking(left - 1, right, track);
        track.deleteCharAt(track.length() - 1);

        track.append(')');
        backtracking(left, right - 1, track);
        track.deleteCharAt(track.length() - 1);
    }

    public void generate(String path, int depth, int n) {
        if (depth == n) {
            if (valid(path)) {
                res.add(path);
            }
            return;
        }

        generate(path + "(", depth + 1, n);
        generate(path + ")", depth + 1, n);
    }

    public boolean valid(String path) {
        int balance = 0;
        for (char c : path.toCharArray()) {
            if (c == '(') {
                ++balance;
            } else {
                --balance;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }
}
