package stack;

import java.util.Deque;
import java.util.LinkedList;

public class LC150EvaluateRPN {

    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for (String token : tokens) {
            if (!isOperator(token)) {
                stack.push(Integer.valueOf(token));
            } else {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(operate(a, b, token));
            }
        }
        return stack.pop();
    }

    public boolean isOperator(String token) {
        return token.equals("+") || token.equals("-")
                || token.equals("*") || token.equals("/");
    }

    public int operate(int a, int b, String operator) {
        return switch (operator) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> 0;
        };
    }
}
