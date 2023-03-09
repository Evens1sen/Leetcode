package tree;

import java.util.ArrayList;
import java.util.List;

public class LC22GenerateParentheses {

    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        generate("", 0, n * 2);
        return res;
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
