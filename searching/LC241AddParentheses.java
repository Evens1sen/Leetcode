package searching;

import java.util.ArrayList;
import java.util.List;

public class LC241AddParentheses {

    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = new ArrayList<>();
        if (expression.chars().allMatch(Character::isDigit)) {
            res.add(Integer.parseInt(expression));
            return res;
        }

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*') {
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));
                for (int l : left) {
                    for (int r : right) {
                        int num = 0;
                        if (ch == '+') {
                            num = l + r;
                        } else if (ch == '-') {
                            num = l - r;
                        } else {
                            num = l * r;
                        }
                        res.add(num);
                    }
                }
            }
        }

        return res;
    }
}
