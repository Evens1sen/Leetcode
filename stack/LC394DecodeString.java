package stack;

import java.util.Stack;

public class LC394DecodeString {

    public static void main(String[] args) {
        // Scanner input=new Scanner(System.in);
        // String str=input.next();
        String s = "2[abc]3[cd]ef";
        System.out.println(decode(s));
    }

    public static String decode(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<StringBuilder> strs = new Stack<>();
        StringBuilder cur = new StringBuilder();
        int num = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } else if (ch == '[') {
                nums.push(num);
                strs.push(cur);
                cur = new StringBuilder();
                num = 0;
            } else if (ch == ']') {
                StringBuilder sb = cur;
                cur = strs.pop();
                int repeat = nums.pop();
                for (int i = 0; i < repeat; i++) {
                    cur.append(sb);
                }
                num = 0;
            } else {
                cur.append(ch);
            }
        }
        return cur.toString();
    }

}