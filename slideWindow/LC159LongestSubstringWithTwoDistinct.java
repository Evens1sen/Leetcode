package slideWindow;

import java.util.*;

public class LC159LongestSubstringWithTwoDistinct {

    public static void main(String[] args) {
        String s = "ccaabbb";
        System.out.println(lengthOfLongestSubstringTwoDistinct(s));
    }

    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        int res = 0;
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;

        while (right < s.length()) {
            if (window.size() < 2) {
                window.put(s.charAt(right), window.getOrDefault(s.charAt(right), 0) + 1);
                right++;
            } else if (window.size() == 2) {
                if (window.containsKey(s.charAt(right))) {
                    window.put(s.charAt(right), window.getOrDefault(s.charAt(right), 0) + 1);
                    right++;
                } else {
                    if (window.get(s.charAt(left)) == 1) {
                        window.remove(s.charAt(left));
                    } else {
                        window.put(s.charAt(left), window.get(s.charAt(left)) - 1);

                    }
                    left++;
                }
            }
            res = Math.max(res, right - left);
        }

        return res;
    }
}
