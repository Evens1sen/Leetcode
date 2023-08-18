package stack;

import java.util.Deque;
import java.util.LinkedList;

public class LC151ReverseWords {

    public String reverseWords(String s) {
        Deque<String> stack = new LinkedList<>();
        char[] str = s.toCharArray();

        int i = 0;
        while (i < str.length) {
            int j = i;
            StringBuilder word = new StringBuilder();
            while (j < str.length && (Character.isAlphabetic(str[j]) || Character.isDigit(str[j]))) {
                word.append(str[j]);
                j++;
            }
            if (i != j) {
                stack.push(String.valueOf(word));
                i = j;
            } else {
                i++;
            }
        }

        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
            res.append(" ");
        }
        return res.substring(0, res.length() - 1);
    }
}
