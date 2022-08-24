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

        int left = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            int oddLength = expand(s, i, i);
            int evenLength = expand(s, i, i + 1);
            int maxLength = Math.max(oddLength, evenLength);
            if (maxLength > (right - left + 1)) {
                left = i - (maxLength - 1) / 2;
                right = i + maxLength / 2;
            }
        }

        return s.substring(left, right + 1);
    }

    public static int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }
}
