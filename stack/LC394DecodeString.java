package stack;

import java.util.Deque;
import java.util.LinkedList;

public class LC394DecodeString {

    public static void main(String[] args) {
        String s = "2[abc]3[cd]ef";
        System.out.println(decodeString(s));
    }

    public static String decodeString(String s) {
        Deque<StringBuilder> strs = new LinkedList<>();
        Deque<Integer> nums = new LinkedList<>();

        int num = 0;
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } else if (ch == '[') {
                nums.push(num);
                num = 0;
                strs.push(sb);
                sb = new StringBuilder();
            } else if (ch == ']') {
                int repeat = nums.pop();
                StringBuilder prev = strs.pop();
                for (int i = 0; i < repeat; i++) {
                    prev.append(sb);
                }
                sb = prev;
            } else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }

}