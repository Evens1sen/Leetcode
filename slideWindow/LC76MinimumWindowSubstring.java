package slideWindow;

import java.util.HashMap;
import java.util.Map;

public class LC76MinimumWindowSubstring {

    public static void main(String[] args) {
        String s = "cabwefgewcwaefgcf";
        String t = "cae";
        System.out.println(minWindow(s, t));
    }

    // FIXME
    public static String minWindow(String s, String t) {
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> target = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            target.put(t.charAt(i), target.getOrDefault(t.charAt(i), 0) + 1);
        }

        int left = 0;
        int min = Integer.MAX_VALUE;
        int minLeft = -1;
        for (int right = 0; right <= s.length(); right++) {
            while (check(window, target)) {
                min = Math.min(min, right - left);
                minLeft = left;
                char toRemove = s.charAt(left);
                window.put(toRemove, window.get(toRemove) - 1);
                left++;
            }

            if (right < s.length()) {
                char toAdd = s.charAt(right);
                window.put(toAdd, window.getOrDefault(toAdd, 0) + 1);
            }
        }

        return minLeft == -1 ? "" : s.substring(minLeft, minLeft + min);
    }

    public static boolean check(Map<Character, Integer> window, Map<Character, Integer> target) {
        for (Character ch : target.keySet()) {
            int freq = target.get(ch);
            if (window.get(ch) == null || window.get(ch) < (freq)) {
                return false;
            }
        }

        return true;
    }
}
