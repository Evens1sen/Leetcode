package string;

import java.util.Map;

public class LC5LongestPalindrome {

    public static void main(String[] args) {
        String s = "babad"; // "bab"
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String odd = expand(s, i, i);
            String even = expand(s, i, i + 1);
            if (odd.length() > res.length()) {
                res = odd;
            }
            if (even.length() > res.length()) {
                res = even;
            }
        }

        return res;
    }

    public static String expand(String s, int left, int right) {
        while (left >= 0 && right <= s.length() - 1
                && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return s.substring(left + 1, right);
    }
}
